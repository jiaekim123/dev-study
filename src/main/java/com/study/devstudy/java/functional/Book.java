package com.study.devstudy.java.functional;

import lombok.Builder;

import java.util.Arrays;
import java.util.List;

@Builder
public class Book {
    private final String title;
    private final Authors authors;
    private final BookCategory category;
    private int price;
    private int stock;

    public Book(String title, Authors authors, BookCategory category, int price, int stock) {
        this.title = title;
        this.authors = authors;
        this.category = category;
        this.price = price;
        this.stock = stock;
    }

    public String getTitle() {
        return title;
    }

    public Authors getAuthors() {
        return authors;
    }

    public BookCategory getCategory() {
        return category;
    }

    public int getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public void sellOne() {
        stock--;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", authors=" + authors +
                ", category=" + category +
                ", price=" + price +
                ", stock=" + stock +
                '}';
    }

    public void showInfo() {
        System.out.println(toString());
    }

    enum BookCategory {
        FICTION, NON_FICTION, SCIENCE, TECHNOLOGY, SELF_HELP
    }

    public static class Authors {
        private final List<String> names;

        public Authors(String... names) {
            this.names = Arrays.asList(names);
        }

        public String getAuthorNames() {
            return String.join(",", names);
        }

        @Override
        public String toString() {
            return "Authors{" +
                    "names=" + names +
                    '}';
        }
    }
}
