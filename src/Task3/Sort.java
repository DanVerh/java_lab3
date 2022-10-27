package Task3;

import Task1.Product;
import Task2.Storage;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Sort {
    private Storage storage;

    public Sort(Storage storage) {
        this.storage = storage;
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

//    public void sortProductName() {
//      storage.setSortedProducts(( storage.getAllProducts().stream()
//              .sorted(Comparator.comparing(Product::getName))
//              .collect(Collectors.toList())));
//    }
//
//    public void filterByPrice(double price){
//        storage.setSortedProducts(storage.getAllProducts().stream()
//                .filter(o -> o.getPrice() >= price)
//                .collect(Collectors.toList()));
//    }
//
//    public double averagePrice(){
////        storage.setSortedProducts(storage.getAllProducts().stream()
////                .filter(o -> o.getPrice() >= price)
////                .collect(Collectors.toList()));
//
//        return storage.getAllProducts().stream()
//                .mapToDouble(Product::getPrice)
//                .average()
//                .orElse(Double.NaN);
//    }
}
