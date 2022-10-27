package Task1and3;

import java.util.List;
import java.util.ArrayList;

public class Bill {
    private List<Product> products = new ArrayList<>();
    private int date;
    private Customer customer;

    public Bill(List<Product> products, int date, Customer customer) {
        this.products = products;
        this.date = date;
        this.customer = customer;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public double getSum(){
        double sum = 0;
        for (Product item : products) {
            sum += item.getPrice();
        }
        return sum;
    }


}
