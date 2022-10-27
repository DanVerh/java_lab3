package Task1;

import Task2.PriceException;
import Task2.Storage;
import Task3.Sort;

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

        Storage atb = new Storage(shopProducts);
        atb.printStorageProducts();

        ArrayList<Product> andriyProducts = new ArrayList<Product>();
        andriyProducts.add(snickers);
        andriyProducts.add(mars);
        Bill bill = new Bill(andriyProducts);
        Seller anton = new Seller("Anton", bill);
        Customer andriy = new Customer("Andriy", 125);

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
        atb.addProducts(newProducts);
        atb.printStorageProducts();

        Sort sort = new Sort(atb);
        sort.sortProductName();
        atb.printStorageProducts();
        sort.filterByPrice(25);
        atb.printStorageProducts();
    }
}
