package Lab5;

public class FormatException extends Exception{
    private String errorMessage;

    //###### param. constructor ########
    FormatException(String errorMessage) {
        //in constructor first line have to be invoke of superclass constructor
        super(errorMessage);
        this.errorMessage = errorMessage;
    }

    @Override
    public void printStackTrace() {
        System.out.println(this.errorMessage);
    }
}
