package Lab2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        LinkedList<Punkt3D> lista = new LinkedList<Punkt3D>();
        while (true) {
            System.out.println("1. Wczytaj punkt 3D");
            System.out.println("2. Wyswietl wszystkie punkty");
            System.out.println("3. Oblicz odległość");
            System.out.println("4. Zakończ");
            System.out.print("Wybierz : ");
            Scanner userInput = new Scanner(System.in);
            if (userInput.hasNextInt()) {
                switch (userInput.nextInt()) {
                    case 1:
                        System.out.print("Podaj współrzędne (kolejnosc x ,y, z, kazda liczbe oddziel spacja): ");
                        Scanner userPoint = new Scanner(System.in);
                        int licznik = 0;
                        double[] tab = new double[3];
                        while (licznik < 3) {
                            if (userPoint.hasNextDouble() || userPoint.hasNextInt()) {
                                tab[licznik] = userPoint.nextDouble();
                                licznik++;
                            } else {
                                System.out.println("Error");
                                break;
                            }
                        }
                        Punkt3D newPoint = new Punkt3D(tab[0], tab[1], tab[2]);
                        lista.add(newPoint);
                        break;  //wczytywanie punkt i umieszczanie w LinkedList

                    case 2:
                        ListIterator<Punkt3D> listIterator = lista.listIterator();
                        int licznik2 = 1;
                        while (listIterator.hasNext()) {
                            System.out.println(licznik2 + "." + listIterator.next().toString());
                            licznik2++;
                        }
                        break; // wyswietlanie punkt

                    case 3:
                        int licznik3=0;
                        Punkt3D[] tmpArray = new Punkt3D[2];
                        System.out.print("Wybierz punkty miedzy ktorymi chcesz obliczyc odlegosc(oodziel spacja indeksy): ");
                        Scanner userChoice = new Scanner(System.in);
                        if (userChoice.hasNextInt()){
                            while(licznik3<2){
                                tmpArray[licznik3] = lista.get(userChoice.nextInt()-1);
                                licznik3++;
                            }
                            System.out.print("Odlegosc wynosi: ");
                            System.out.println(tmpArray[0].distance(tmpArray[1]));

                        }
                        else
                            System.out.println("Nie prawidlowo wprowadzone indeksy");


                        break; // obliczanie odlegosci

                    case 4:
                        System.out.println("Zakonczyłeś program.");
                        System.exit(0);
                }
            } else
                System.out.println("Zla opcja!");

        }
    }
}
