package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book book = new Book("Clean code" , 15);
        Book book1 = new Book("Adventure", 25);
        Book book2 = new Book("Romantic", 50);
        Book book3 = new Book("Triller", 150);
        Book[] books = new Book[4];
        books[0] = book;
        books[1] = book1;
        books[2] = book2;
        books[3] = book3;
        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i].getNameBook() + " " + books[i].getPage());
        }

        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;
        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i].getNameBook() + " " + books[i].getPage());
        }

        for (int i = 0; i < books.length; i++) {
            if("Clean code".equals(books[i].getNameBook())) {
                System.out.println(books[i].getNameBook() + " " + books[i].getPage());
            }
        }

    }
}
