package Task1;

import java.util.List;
import java.util.ArrayList;

public class Bill {
    private List<Product> products = new ArrayList<>();

    public Bill(List<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
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
