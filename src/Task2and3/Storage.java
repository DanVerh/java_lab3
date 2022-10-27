package Task2and3;

import Task1and3.Bill;
import Task1and3.Customer;
import Task1and3.Product;
import Task1and3.Seller;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Storage {
    private List<Product> allProducts = new ArrayList<>();
    private List<Product> sortedProducts = new ArrayList<>();


    public Storage(List<Product> allProducts) {
        this.allProducts = allProducts;
        this.sortedProducts = null;
    }

    public List<Product> getAllProducts() {
        return allProducts;
    }

    public void setAllProducts(List<Product> allProducts) {
        this.allProducts = allProducts;
    }

    public List<Product> getSortedProducts() {
        return sortedProducts;
    }

    public void setSortedProducts(List<Product> sortedProducts) {
        this.sortedProducts = sortedProducts;
    }

    public void printStorageProducts () {
        System.out.println("All products in the shop:");
        for (Product item : allProducts) {
            System.out.println("- " + item.getName());
        }
        System.out.println();
    }

    public void printSortedProducts () {
        System.out.println("Sorted products in the shop:");
        for (Product item : sortedProducts) {
            System.out.println("- " + item.getName());
        }
        System.out.println();
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
        for (Product product : bill.getProducts()) {
            this.allProducts.remove(product);
        }
    }

    public void sortProductName() {
        this.setSortedProducts(( this.getAllProducts().stream()
                .sorted(Comparator.comparing(Product::getName))
                .collect(Collectors.toList())));
    }

    public void filterByPrice(double price){
        this.setSortedProducts(this.getAllProducts().stream()
                .distinct()
                .filter(o -> o.getPrice() >= price)
                .collect(Collectors.toList()));
    }

    public double averagePrice(){
        return this.getAllProducts().stream()
                .mapToDouble(Product::getPrice)
                .average()
                .orElse(Double.NaN);
    }

    public void mostPopular(){
        allProducts.stream()
                .collect(Collectors.groupingBy(
                        Product::getName,
                        Collectors.counting()
                ))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .ifPresent(System.out::println);
    }

}

