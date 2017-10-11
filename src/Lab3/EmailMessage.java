package Lab3;

import java.util.LinkedList;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class EmailMessage {
    private String from;
    private LinkedList<String> to;
    private String subject;
    private String content;
    private String mimeType;
    private LinkedList<String> cc;
    private LinkedList<String> bcc;

    public String getFrom() {
        return from;
    }

    private EmailMessage(String from_, LinkedList<String> to_, String subject_, String content_, String mimeType_, LinkedList<String> cc_,
                         LinkedList<String> bcc_) {
        this.from = from_;
        this.to = to_;
        this.subject = subject_;
        this.content = content_;
        this.mimeType = mimeType_;
        this.cc = cc_;
        this.bcc = bcc_;

    }

    public static Builder builder() {
        return new EmailMessage.Builder();
    }

    public void send() {
        Properties props = new Properties();


    }

    public static class Builder {

        public String fromTmp = null;
        private LinkedList<String> toTmp = null;
        private String subjectTmp = null;
        private String contentTmp = null;
        private String mimeTypeTmp = null;
        private LinkedList<String> ccTmp = null;
        private LinkedList<String> bccTmp = null;
        final static String EMAILPATTERN = "[a-zA-Z0-9._!#$%^&*]+@[a-zA-Z0-9.]+";

        public String getFromTmp() {
            return fromTmp;
        }

        public Builder() {
            ccTmp = new LinkedList<String>();
            bccTmp = new LinkedList<String>();
        }

        public Builder addFrom(String from) throws InvalidEmailFormatException {
            try {
                if (Validation.validate(EMAILPATTERN, from)) {
                    this.fromTmp = from;
                    return this;
                }
                else
                    throw new InvalidEmailFormatException();


            } catch (InvalidEmailFormatException e) {
                System.out.println("Invalid email format");
                return this;

            }


        }

        public Builder addTo(String... to) throws InvalidEmailFormatException {
            if(this.toTmp == null)
                this.toTmp = new LinkedList<String>();
            for (String tmp : to) {
                try {
                    if (Validation.validate(EMAILPATTERN, tmp)) {
                        toTmp.add(tmp);
                    } else
                        throw new InvalidEmailFormatException();
                } catch (InvalidEmailFormatException e) {
                    System.out.println("Invalid email format");
                    return this;
                }
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
            try {
                if (this.fromTmp == null || this.toTmp == null)
                    throw new RequriedArgumentsException();
                else
                    return new EmailMessage(this.fromTmp, this.toTmp, this.subjectTmp, this.contentTmp, this.mimeTypeTmp, this.ccTmp, this.bccTmp);
            } catch (RequriedArgumentsException e) {
                System.out.println("Missing requried arguments");
                return null;
            }

        }
    }
}
