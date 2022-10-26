package Task2;

import Task1.Bill;
import Task1.Customer;
import Task1.Product;
import Task1.Seller;

import java.util.ArrayList;

public class Storage {
    public ArrayList<Product> allProducts;

    public void getAllProducts () {
        System.out.println("All products in the shop:");
        for (Product item : allProducts) {
            System.out.println("- " + item.getName());
        }
        System.out.println();
    }

    public Storage(ArrayList<Product> allProducts) {
        this.allProducts = allProducts;
    }

    private boolean validate(ArrayList<Product> newProducts) throws PriceException{
        for (Product product : newProducts){
            if (product.getPrice() <= 0){
                throw new PriceException();
            }
        }
        return true;
    }

    public void addProducts(ArrayList<Product> newProducts) throws PriceException {
        if(validate(newProducts)) {
            this.allProducts.addAll(newProducts);
        }
    }

    public void sell (Customer customer, Seller seller, Bill bill){
        customer.setMoney(customer.getMoney() - bill.getSum());
        seller.setMoney(seller.getMoney() + bill.getSum());
        if (customer.getPurchaseHistory() != null){
            customer.getPurchaseHistory().add(seller.getBill());
        }
        else {
            ArrayList<Bill> bills = new ArrayList<>();
            bills.add(seller.getBill());
            customer.setPurchaseHistory(bills);
        }
        this.allProducts.removeAll(bill.getProducts());
    }

}

