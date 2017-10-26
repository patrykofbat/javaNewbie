package Lab5;


public class MainLab5 {
    public static void main(String[] args){
        Microdvd microdvd = new Microdvd();
        String in = "C:\\Users\\Patryk\\Documents\\FileJava\\input.txt";
        String out = "C:\\Users\\Patryk\\Documents\\FileJava\\output.txt";

        try{
            microdvd.delay(in, out , 1000, 10);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
