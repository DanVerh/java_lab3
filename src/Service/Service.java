package Service;

import Task1and3.Bill;

import java.util.ArrayList;
import java.util.List;

public class Service {
    private List<Bill> bills = new ArrayList<>();
    private int date;

    public Service(List<Bill> bills, int date) {
        this.bills = bills;
        this.date = date;
    }

    public List<Bill> getBills() {
        return bills;
    }

    public void setBills(List<Bill> bills) {
        this.bills = bills;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public double incomeByDate(){
        List<Bill> datedBills = new ArrayList<>();
        for (Bill bill : bills){
            if (bill.getDate() == this.date){
                datedBills.add(bill);
            }
        }
        return datedBills.stream()
                .mapToDouble(Bill::getSum)
                .sum();
    }
}
