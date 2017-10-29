package Lab5;

public class NegativeTimeFrameException extends Exception {
    @Override
    public void printStackTrace() {
        System.out.println("Negative time or frames");
    }
}
