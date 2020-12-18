package ru.job4j.pojo;

public class Book {
    private String nameBook;
    private int page;

    public Book(String nameBook, int page) {
        this.nameBook = nameBook;
        this.page = page;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
