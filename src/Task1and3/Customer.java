package Task1and3;

import java.util.List;
import java.util.ArrayList;

public class Customer {
    private String name;
    private List<Bill> purchaseHistory = new ArrayList<>();
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

    public List<Bill> getPurchaseHistory() {
        return purchaseHistory;
    }

    public void setPurchaseHistory(List<Bill> purchaseHistory) {
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
                System.out.println("- " + item.getName());
            }
        }
    }

    public int itemAmount(String name){
        List<String> productName = new ArrayList<>();
        for(Bill bill : purchaseHistory){
            for(Product product : bill.getProducts()){
                productName.add(product.getName());
            }
        }
         return (int) productName.stream()
                .filter(o -> o == name)
                 .count();
    }

    public double customerExpensesByDate(int startDate, int endDate){
        List<Bill> bills = new ArrayList<Bill>();
        for (Bill bill : purchaseHistory){
            if (bill.getDate() >= startDate && bill.getDate() <= endDate){
                bills.add(bill);
            }
        }
        return bills.stream()
                .filter(o -> o.getCustomer().equals(this))
                .mapToDouble(o -> o.getSum())
                .sum();
    }
}
