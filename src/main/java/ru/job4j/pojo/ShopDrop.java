package ru.job4j.pojo;

public class ShopDrop {
    public Product[] leftShift(Product[] products, int token) {
        for (int i = token; i < products.length - 1; i++) {
            products[i] = products[i + 1];
        }
        products[products.length - 1] = null;
        return products;
    }
}
