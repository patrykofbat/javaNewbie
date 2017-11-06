package Lab5_2;


import io.indico.Indico;
import io.indico.api.results.BatchIndicoResult;

import java.io.File;
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

    public void sorter(String pathToDir) throws Exception {
        Indico indico = new Indico("18cfe2137533995d874996339ba37b53");
        File dirWithImg = new File(pathToDir);

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
            double maxValue = IndicoImageRecognition.getMaxValue(tmp.values());
            String category = "";
            for (String k : tmp.keySet()) {
                if (tmp.get(k).equals(maxValue)) {
                    category = k;
                }
            }
            System.out.println(category + "=" + maxValue);
            new File("C:\\Users\\Patryk\\Documents\\Obrazki\\sorted\\" + category).mkdir();
            Path newPath = Paths.get("C:\\Users\\Patryk\\Documents\\Obrazki\\sorted\\" +
                    category + "\\" +
                    fileNames[counterForFiles]);
            Path oldPath = Paths.get(arrayWithImg[counterForFiles]);
            Files.move(oldPath, newPath);
            counterForFiles++;
        }
    }
}

