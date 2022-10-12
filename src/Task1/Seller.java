package Task1;

import java.util.ArrayList;

public class Seller {
    private String name;
    private double money;
    private Bill bill;

    public Seller(String name, Bill bill) {
        this.name = name;
        this.money = 0;
        this.bill = bill;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public void sell (Customer customer){
        customer.setMoney(customer.getMoney() - bill.getSum());
        this.setMoney(this.getMoney() + bill.getSum());
        if (customer.getPurchaseHistory() != null){             //change to optional
            customer.getPurchaseHistory().add(this.getBill());
        }
        else {
            ArrayList<Bill> bills = new ArrayList<>();
            bills.add(this.getBill());
            customer.setPurchaseHistory(bills);
        }
    }
}
