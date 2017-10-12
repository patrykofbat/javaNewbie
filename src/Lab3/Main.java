package Lab3;


import javax.mail.MessagingException;

public class Main {
    public static void main(String[] args){
        try {
            EmailMessage wiadomosc = EmailMessage.builder().addFrom("patrykofbat@gmail.com").addTo("patrykofbat@gmail.com").
                    addSubject("Siemka").addContent("eloszka jak tam").build();
            wiadomosc.send();

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
        catch (MessagingException f){
            System.out.println("Messaging Exception");
        }


    }
}
