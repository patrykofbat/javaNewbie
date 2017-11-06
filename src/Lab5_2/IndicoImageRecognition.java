package Lab5_2;


import io.indico.Indico;
import io.indico.api.results.BatchIndicoResult;
import io.indico.api.utils.IndicoException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class IndicoImageRecognition {
    public static double getMaxValue(Collection<Double> doubleSet) {
        double max = Double.NEGATIVE_INFINITY;
        for (double i : doubleSet) {
            if (i > max)
                max = i;
        }
        return max;
    }


     void sorter(String pathToDir) throws IndicoException, WrongPathException, IOException{
        //validation if api key does not fit
        Indico indico = new Indico("18cfe2137533995d874996339ba37b53");

        File dirWithImg = new File(pathToDir);
        //validate path
        if(!dirWithImg.isDirectory())
            throw new WrongPathException("You pass wrong path");

        String[] fileNames = dirWithImg.list();
        String[] arrayWithImg = new String[dirWithImg.listFiles().length];
        //counter for looping through array
        int counterForFiles = 0;

        //saving Paths of images to array
        for (File img : dirWithImg.listFiles()) {
            arrayWithImg[counterForFiles] = img.getAbsolutePath();
            counterForFiles++;
        }

        // using api for image recognition and saving the result in list of map<category,probability(value)>
        BatchIndicoResult multiple = indico.imageRecognition.predict(arrayWithImg);
        List<Map<String, Double>> result = multiple.getImageRecognition();

        // reassing counter for looping
        counterForFiles = 0;

        //looping through result of api/looking for the heighst probability/saving img to relevant dir
        for (Map<String, Double> tmp : result) {
            double maxValue = IndicoImageRecognition.getMaxValue(tmp.values());
            String category = "";
            for (String k : tmp.keySet()) {
                if (tmp.get(k).equals(maxValue)) {
                    category = k;
                }
            }
            System.out.println(category + "=" + maxValue);
            //create new dir named as category if exist does not overide
            new File("C:\\Users\\Patryk\\Documents\\Obrazki\\sorted\\" + category).mkdir();

            //create new path
            Path newPath = Paths.get("C:\\Users\\Patryk\\Documents\\Obrazki\\sorted\\" +
                    category + "\\" +
                    fileNames[counterForFiles]);

            Path oldPath = Paths.get(arrayWithImg[counterForFiles]);

            //saving img in new dir
            Files.move(oldPath, newPath);
            counterForFiles++;
        }
    }
}

