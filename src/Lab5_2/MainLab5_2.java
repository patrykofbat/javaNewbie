package Lab5_2;




public class MainLab5_2 {

    public static void main(String[] args) {
        try {
            IndicoImageRecognition sampleDir = new IndicoImageRecognition();

            sampleDir.sorter(args[0]);


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
