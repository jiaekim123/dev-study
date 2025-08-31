package com.study.devstudy.java.functional;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateExample {
    public static void main(String[] args) {
        List<Book> sampleBookList = SampleBook.sampleBooks;

        BookShop shop1 = filterOrder(sampleBookList, book -> Book.BookCategory.SELF_HELP == book.getCategory());
        BookShop shop2 = forFilterOrder(sampleBookList, book -> Book.BookCategory.SELF_HELP == book.getCategory());

        System.out.printf("shop1(filterOrder) : %s%n", shop1.getBookNames());
        System.out.printf("shop2(forFilterOrder) : %s%n", shop2.getBookNames());
    }

    private static BookShop filterOrder(List<Book> books, Predicate<Book> predicate) {
        return new BookShop(books.stream().filter(predicate).collect(Collectors.toList()));
    }

    private static BookShop forFilterOrder(List<Book> books, Predicate<Book> predicate) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (predicate.test(book)) {
                result.add(book);
            }
        }
        return new BookShop(result);
    }
}
