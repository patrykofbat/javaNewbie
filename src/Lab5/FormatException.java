package Lab5;

public class FormatException extends Exception{
    private String errorMessage;
    private String cause;

    //###### param. constructor ########
    FormatException(String errorMessage, String cause) {
        //in constructor first line have to be invoke of superclass constructor
        super(errorMessage);
        this.errorMessage = errorMessage;
        this.cause = cause;
    }

    @Override
    public void printStackTrace() {
        System.out.println("Type of error: " + cause);
        System.out.println(this.errorMessage);
    }
}
