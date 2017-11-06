package Lab5_2;


import io.indico.api.utils.IndicoException;

import java.io.IOException;

public class MainLab5_2 {

    public static void main(String[] args) {
        try {
            IndicoImageRecognition sampleDir = new IndicoImageRecognition();

            sampleDir.sorter(args[0]);


        } catch (WrongPathException |IOException |IndicoException e) {
            System.out.println(e.getMessage());
        }

    }

}
