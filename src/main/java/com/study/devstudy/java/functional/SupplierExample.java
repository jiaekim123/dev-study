package com.study.devstudy.java.functional;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SupplierExample {
    public static void main(String[] args) {

        int count = 2;
        String titles = Stream.generate(() -> getExistBookTitle())
                .limit(count)
                .collect(Collectors.joining(", "));

        System.out.printf("재고가 있는 책 %d권: %s", count, titles);
    }


    public static String getExistBookTitle() {
        List<Book> books = SampleBook.sampleBooks;

        Collections.shuffle(books);
        return books.stream()
                .filter(book -> book.getStock() > 0)
                .map(Book::getTitle)
                .findFirst().orElse("재고 없음");

    }
}
