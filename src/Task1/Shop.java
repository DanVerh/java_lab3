package Task1;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.SortedMap;

public class Shop {
    private ArrayList<Product> products;

    public void getAllProducts () {
        System.out.println("All products in the shop:");
        for (Product item : products) {
            System.out.println(item.getName());
        }
        System.out.println();
    }

    public Shop(ArrayList<Product> products) {
        this.products = products;
    }

    public static void main(String[] args) {
        Product snickers = new Product("Snickers", 18.90);
        Product mars = new Product("Mars", 21.50);
        Product twix = new Product("Twix", 19.80);

        ArrayList<Product> shopProducts = new ArrayList<Product>();
        shopProducts.add(snickers);
        shopProducts.add(mars);
        shopProducts.add(twix);

        Shop atb = new Shop(shopProducts);
        atb.getAllProducts();

        ArrayList<Product> andriyProducts = new ArrayList<Product>();
        andriyProducts.add(snickers);
        andriyProducts.add(mars);
        Bill bill = new Bill(andriyProducts);
        Seller anton = new Seller("Anton", bill);
        Customer andriy = new Customer("Andriy", 125);

        System.out.println("Customer money before purchase: " + andriy.getMoney());
        anton.sell(andriy);
        System.out.println("Customer purchase history: ");
        andriy.printPurchaseHistory();
        System.out.println("Customer money after purchase: " + andriy.getMoney());
        System.out.println("Seller money after purchase: " + anton.getMoney());

    }
}

