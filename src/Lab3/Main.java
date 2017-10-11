package Lab3;


public class Main {
    public static void main(String[] args){
        try {
            EmailMessage wiadomosc = EmailMessage.builder().addFrom("sspl@pl").addTo("Mail@wp", "hehwp").build();
            System.out.println(wiadomosc.getFrom());

        }
        catch(NullPointerException|InvalidEmailFormatException|RequriedArgumentsException c) {


        }


    }
}
