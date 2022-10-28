package Task4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Calculations {
    private double number1;
    private double number2;

    public Calculations(double number1, double number2) {
        this.number1 = number1;
        this.number2 = number2;
    }

    public double getNumber1() {
        return number1;
    }

    public void setNumber1(double number1) {
        this.number1 = number1;
    }

    public double getNumber2() {
        return number2;
    }

    public void setNumber2(double number2) {
        this.number2 = number2;
    }

    private class Sum extends Thread {
        public void sum() {
            try {
                System.out.println("Sum: ");
                Thread.sleep(2000);
                System.out.println(number1 + " + " + number2 + " = " + Double.sum(number1, number2));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Sum is interrupted");
            }
        }

        @Override
        public void run() {
            sum();
        }
    }

    public void runCalc() {
        Sum sumObj = new Sum();
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        try {

            Future<Double> sub = executorService.submit(() -> {
                try {
                    System.out.println("Subtraction: ");
                    Thread.sleep(5000);
                } catch (InterruptedException e) {}

                return number1 - number2;
            });
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {}

            System.out.println(number1 + " - " + number2 + " = " + sub.get());
            sumObj.run();

        }catch (Exception e){}

        try {
            executorService.shutdown();
        }
        catch (Exception e){
            executorService.shutdown();
        }
        finally {
            executorService.shutdown();
        }
    }
}
