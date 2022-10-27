package Task2and3;

public class PriceException extends Exception{
    public PriceException(){
        super("Price can't be 0 or less");
    }
}
