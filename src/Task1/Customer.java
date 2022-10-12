package Task1;

import java.util.ArrayList;

public class Customer {
    private String name;
    private ArrayList<Bill> purchaseHistory;
    private double money;

    public Customer(String name, double money) {
        this.name = name;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Bill> getPurchaseHistory() {
        return purchaseHistory;
    }

    public void setPurchaseHistory(ArrayList<Bill> purchaseHistory) {
        this.purchaseHistory = purchaseHistory;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public void printPurchaseHistory(){
        for (Bill purchase : purchaseHistory){
            for (Product item : purchase.getProducts()) {
                System.out.println(item.getName());
            }
        }
    }
}
