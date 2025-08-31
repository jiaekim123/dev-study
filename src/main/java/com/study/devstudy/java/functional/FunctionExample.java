package com.study.devstudy.java.functional;

import java.util.List;
import java.util.function.Function;

public class FunctionExample {
    public static void main(String[] args) {
        List<Book> books = SampleBook.sampleBooks;

        System.out.println("전체 책 재고 가격: " + sumFunction(books, book -> book.getPrice() * book.getStock()));

    }

    private static Integer sumFunction(List<Book> books, Function<Book, Integer> function) {
        int sum = 0;
        for (Book book : books) {
            sum += function.apply(book);
        }
        return sum;
    }
}
