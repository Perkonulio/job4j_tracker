package ru.job4j.pojo;

public class ShopDrop {
    public Product[] leftShift(Product[] products, int token) {
        for (int i = 0; i < products.length; i++) {
            if(i == token && products[i] != null) {
                products[i] = null;
            } else if(i > token) {
                products[i - 1] = products[i];
                products[i] = null;
            }
        }
        return products;
    }
}
