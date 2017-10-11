package Lab3;


import javax.mail.MessagingException;

public class Main {
    public static void main(String[] args){
        try {
            EmailMessage wiadomosc = EmailMessage.builder().addFrom("patrykpapior1997@gmail.com").addTo("patrykpapior1997@gmail.com").
                    addSubject("Siemka").addContent("siemka").build();
            System.out.println(wiadomosc.getFrom());
            wiadomosc.getTo();
            wiadomosc.send();

        }
        catch(MessagingException|NullPointerException|InvalidEmailFormatException|RequriedArgumentsException c) {


        }


    }
}
