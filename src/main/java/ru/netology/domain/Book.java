package ru.netology.domain;

public class Book extends Product {
    String author;

    public Book(int id, String title, int price, String author) {
        super(id, title, price);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public boolean matches(Product product, String search) {
        if (super.matches(product, search)) {
            return true;
        }
        if (product instanceof Book) {
            Book book = (Book) product;
            return book.getAuthor().equalsIgnoreCase(search);
        }
        return false;
    }
}