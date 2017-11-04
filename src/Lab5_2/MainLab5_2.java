package Lab5_2;


import io.indico.Indico;
import io.indico.api.image.FacialEmotion;
import io.indico.api.results.BatchIndicoResult;
import io.indico.api.results.IndicoResult;
import io.indico.api.utils.IndicoException;

import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.DoubleBinaryOperator;

public class MainLab5_2 {
    public static double getMaxValue(Collection<Double> doubleSet) {
        double max = Double.NEGATIVE_INFINITY;
        for (double i : doubleSet) {
            if (i > max)
                max = i;
        }
        return max;
    }

    public static void main(String[] args) {
        try {
            Indico indico = new Indico("18cfe2137533995d874996339ba37b53");//exception if not valid api key
            File dirWithImg = new File(args[0]);
            //if(!dirWithImg.isDirectory()) {
                //throw dirDoesNotExistException
            //}

            String[] fileNames = dirWithImg.list();
            String[] arrayWithImg = new String[dirWithImg.listFiles().length];
            int counterForFiles = 0;

            for (File img : dirWithImg.listFiles()) {
                arrayWithImg[counterForFiles] = img.getAbsolutePath();
                counterForFiles++;
            }

            BatchIndicoResult multiple = indico.imageRecognition.predict(arrayWithImg);
            List<Map<String, Double>> result = multiple.getImageRecognition();
            counterForFiles = 0;
            for (Map<String, Double> tmp : result) {
                double maxValue = MainLab5_2.getMaxValue(tmp.values());
                String category = "";
                for (String k : tmp.keySet()) {
                    if (tmp.get(k).equals(maxValue)) {
                        category = k;
                    }
                }
                System.out.println(category + "=" + maxValue);
                new File("C:\\Users\\Patryk\\Documents\\Obrazki\\sorted\\" + category).mkdir();
                Path newPath = Paths.get("C:\\Users\\Patryk\\Documents\\Obrazki\\sorted\\" + category + "\\" +
                fileNames[counterForFiles]);
                Path oldPath = Paths.get(arrayWithImg[counterForFiles]);
                Files.move(oldPath, newPath);
                counterForFiles ++;


            }


        } catch (IndicoException | IOException | NullPointerException e) {
            e.printStackTrace();
        }

    }

}
