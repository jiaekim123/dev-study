package com.study.devstudy.java.functional;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample {

    public static void main(String[] args) {
        List<Book> books = SampleBook.sampleBooks;
        consumerBooks(books, Book::showInfo);
    }

    private static void consumerBooks(List<Book> books, Consumer<Book> consumer) {
        for (Book book : books) {
            consumer.accept(book);
        }
    }
}
