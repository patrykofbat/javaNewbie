package Lab3;

import java.util.LinkedList;
import java.util.Properties;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;


public class EmailMessage {
    private String from;
    private LinkedList<String> to;
    private String subject;
    private String content;
    private String mimeType;
    private LinkedList<String> cc;
    private LinkedList<String> bcc;
    private String smtpMailPassword;


    public String getFrom() {
        return from;
    }

    public void getTo() {
        for (String to : this.to)
            System.out.println(to);
    }

    private EmailMessage(String from_, LinkedList<String> to_, String subject_, String content_, String mimeType_, LinkedList<String> cc_,
                         LinkedList<String> bcc_, String smtpMailPassword_) {
        this.from = from_;
        this.to = to_;
        this.subject = subject_;
        this.content = content_;
        this.mimeType = mimeType_;
        this.cc = cc_;
        this.bcc = bcc_;
        this.smtpMailPassword = smtpMailPassword_;

    }

    public static Builder builder() {
        return new EmailMessage.Builder();
    }

    public void send() throws MessagingException {
        Properties props = System.getProperties();
        props.setProperty("mail.smtp.host", "smtp.gmail.com");
        props.setProperty("mail.smtp.user", this.from);
        props.setProperty("mail.smtp.password", this.smtpMailPassword);
        props.setProperty("mail.smtp.auth", "true");
        props.put("mail.debug", "true");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, smtpMailPassword);
            }
        });
        MimeMessage message = new MimeMessage(session);


        message.setFrom(new InternetAddress(this.from));

        for(String x: this.to)
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(x));

        message.setSubject(this.subject);

        message.setText(this.content);

        Transport.send(message);

        System.out.println("Message sent successfully");


    }

    public static class Builder {

        private String fromTmp = null;
        private LinkedList<String> toTmp = null;
        private String subjectTmp = null;
        private String contentTmp = null;
        private String mimeTypeTmp = null;
        private LinkedList<String> ccTmp = null;
        private LinkedList<String> bccTmp = null;
        private String smtpMailPasswordTmp = null;
        final static String EMAILPATTERN = "[a-zA-Z0-9._!#$%^&*]+@[a-zA-Z0-9]+\\.[a-z]{2,6}";

        public String getFromTmp() {
            return fromTmp;
        }

        public Builder() {
            ccTmp = new LinkedList<String>();
            bccTmp = new LinkedList<String>();
        }

        public Builder addFrom(String from) throws InvalidEmailFormatException {
            if (Validation.validate(EMAILPATTERN, from)) {
                this.fromTmp = from;
                return this;
            } else
                throw new InvalidEmailFormatException();
        }

        public Builder addTo(String... to) throws InvalidEmailFormatException {
            if (this.toTmp == null)
                this.toTmp = new LinkedList<String>();
            for (String tmp : to) {
                if (Validation.validate(EMAILPATTERN, tmp)) {
                    toTmp.add(tmp);
                } else
                    throw new InvalidEmailFormatException();
            }
            return this;
        }

        public Builder addSubject(String subject) {
            this.subjectTmp = subject;
            return this;

        }

        public Builder addContent(String content) {
            this.contentTmp = content;
            return this;

        }

        public EmailMessage build() throws RequriedArgumentsException {
            System.out.print("Password requried: ");
            Scanner userPwd = new Scanner(System.in);
            this.smtpMailPasswordTmp = userPwd.next();
            if (this.fromTmp == null || this.toTmp == null || this.smtpMailPasswordTmp == null)
                throw new RequriedArgumentsException();
            else
                return new EmailMessage(this.fromTmp, this.toTmp, this.subjectTmp, this.contentTmp, this.mimeTypeTmp,
                        this.ccTmp, this.bccTmp, this.smtpMailPasswordTmp);

        }
    }
}
