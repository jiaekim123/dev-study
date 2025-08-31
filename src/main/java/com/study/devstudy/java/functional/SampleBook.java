package com.study.devstudy.java.functional;

import java.util.Arrays;
import java.util.List;

public class SampleBook {
    public static final List<Book> sampleBooks = Arrays.asList(
            Book.builder()
                    .title("스틱!")
                    .authors(new Book.Authors("칩 히스", "댄 히스"))
                    .price(15000)
                    .stock(10)
                    .category(Book.BookCategory.SELF_HELP)
                    .build(),
            Book.builder()
                    .title("역행자 확장판")
                    .authors(new Book.Authors("자청"))
                    .price(10000)
                    .stock(5)
                    .category(Book.BookCategory.SELF_HELP)
                    .build(),
            Book.builder()
                    .title("듄")
                    .authors(new Book.Authors("프랭크 하버트"))
                    .price(20000)
                    .stock(4)
                    .category(Book.BookCategory.FICTION)
                    .build(),
            Book.builder()
                    .title("토비의 스프링 1")
                    .authors(new Book.Authors("토비"))
                    .price(25000)
                    .stock(0)
                    .category(Book.BookCategory.TECHNOLOGY)
                    .build()
    );
}
