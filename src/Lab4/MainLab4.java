package Lab4;

import java.io.File;
import java.util.Scanner;

// to set up program args go to Run -> Edit configurations

public class MainLab4 {
    public MainLab4(){
        File in = new File("C:\\Users\\Patryk\\Desktop\\to.txt");
        File out = new File("C:\\Users\\Patryk\\Desktop\\decrypted.txt");
        System.out.println("1.szyfruj(ROT11)");
        System.out.println("2.szyfruj(Polibiusz)");          //interface with will allows user
        System.out.println("3.deszyfruj(ROT11)");            // to choose option with using switch-case
        System.out.println("4.deszyfruj(Polibius)");         // bellow
        System.out.print("Wybor: ");
        Scanner userInput = new Scanner(System.in);
        int i = userInput.nextInt();
        switch (i) {
            case 1:
                Cryptographer.cryptFile(in, out, new ROT11());
                break;
            case 2:
                Cryptographer.cryptFile(in, out, new Polibius());
                break;
            case 3:
                Cryptographer.deCryptFile(in, out, new ROT11());
                break;
            case 4:
                Cryptographer.deCryptFile(in, out, new Polibius());
                break;
        }

    }
    public static void main(String[] args){
        new MainLab4();
    }
}

