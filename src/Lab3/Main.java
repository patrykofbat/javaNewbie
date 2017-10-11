package Lab3;


import javax.mail.MessagingException;

public class Main {
    public static void main(String[] args){
        try {
            EmailMessage wiadomosc = EmailMessage.builder().addTo("piotr.skalski92@gmail.com").
                    addSubject("Siemka").addContent("siemka").build();
            System.out.println(wiadomosc.getFrom());
            wiadomosc.getTo();


        }
        catch(InvalidEmailFormatException c) {
            System.out.println("Invalid email format");
        }
        catch(NullPointerException g) {
            System.out.println("Null pointer Exception");
        }
        catch (RequriedArgumentsException e){
            System.out.println("Requried argument missing");
        }


    }
}
