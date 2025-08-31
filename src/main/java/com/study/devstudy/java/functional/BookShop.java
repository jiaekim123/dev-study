package com.study.devstudy.java.functional;

import java.util.List;
import java.util.stream.Collectors;

public class BookShop {
    private final List<Book> bookList;

    public BookShop(List<Book> bookList) {
        this.bookList = bookList;
    }

    public void addBook(Book book) {
        bookList.add(book);
    }

    public String getBookNames() {
        return bookList.stream()
                .map(Book::getTitle)
                .collect(Collectors.joining(","));
    }

}
