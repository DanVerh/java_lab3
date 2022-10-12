package Task1;

import java.util.ArrayList;

public class Bill {
    private ArrayList<Product> products;

    public Bill(ArrayList<Product> products) {
        this.products = products;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public double getSum(){
        double sum = 0;
        for (Product item : products) {
            sum += item.getPrice();
        }
        return sum;
    }
}
