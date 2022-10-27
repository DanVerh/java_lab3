package Task1and3;

import Service.Service;
import Task2and3.PriceException;
import Task2and3.Storage;

import java.util.ArrayList;

public class Task1 {
    public static void main(String[] args) throws PriceException {
        Product snickers = new Product("Snickers", 18.90);
        Product mars = new Product("Mars", 21.50);
        Product twix = new Product("Twix", 19.80);

        ArrayList<Product> shopProducts = new ArrayList<Product>();
        shopProducts.add(snickers);
        shopProducts.add(mars);
        shopProducts.add(twix);
        shopProducts.add(snickers);

        Storage atb = new Storage(shopProducts);
        atb.printStorageProducts();

        ArrayList<Product> andriyProducts = new ArrayList<Product>();
        andriyProducts.add(snickers);
        andriyProducts.add(mars);

        Customer andriy = new Customer("Andriy", 125);
        Bill bill = new Bill(andriyProducts, 25, andriy);
        Seller anton = new Seller("Anton", bill);

        System.out.println("Customer money before purchase: " + andriy.getMoney());
        atb.sell(andriy, anton, bill);
        System.out.println("Customer money after purchase: " + andriy.getMoney());
        System.out.println("Seller money after purchase: " + anton.getMoney());
        System.out.println("Customer purchase history: ");
        andriy.printPurchaseHistory();
        System.out.println("Things left in storage: ");
        atb.printStorageProducts();

        ArrayList<Product> newProducts = new ArrayList<Product>();
        Product cola = new Product("Cola", 29.50);
        Product pepsi = new Product("Pepsi", 28.80);
        newProducts.add(cola);
        newProducts.add(pepsi);
        newProducts.add(pepsi);
        atb.addProducts(newProducts);
        atb.printStorageProducts();

        atb.printStorageProducts();
        atb.sortProductName();
        atb.printSortedProducts();
        atb.filterByPrice(25);
        atb.printSortedProducts();
        System.out.println("Average price of products in Shop: " + atb.averagePrice());
        System.out.println();

        System.out.println("Customer's amount of Snickers: " + andriy.itemAmount("Snickers"));

        System.out.println("Most popular shop product: ");
        atb.mostPopular();

        System.out.println("Customer expenses between 24 and 26: " + andriy.customerExpensesByDate(24, 26));

        ArrayList<Bill> allBills = new ArrayList<Bill>();
        allBills.add(bill);
        Service income = new Service(allBills, 25);
        System.out.println(income.incomeByDate());
    }
}
