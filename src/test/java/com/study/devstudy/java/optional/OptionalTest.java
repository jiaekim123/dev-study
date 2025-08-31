package com.study.devstudy.java.optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

public class OptionalTest {

    static class User {
        private final String name;
        private final String email;

        public User(String name, String email) {
            this.name = name;
            this.email = email;
        }
    }

    @Test
    void Optional_of와_ofNullable_차이() {
        // Optional.of - null을 허용하지 않는 Optional 객체 생성
        // Optional.ofNullable - null을 허용하는 Optional 객체 생성
        Assertions.assertThrows(NullPointerException.class, () -> {
            Optional.of(null);
        });

        Optional<String> optionalOf = Optional.of("value");
        Assertions.assertEquals("value", optionalOf.get());
        Assertions.assertTrue(optionalOf.isPresent());
        Assertions.assertFalse(optionalOf.isEmpty());

        Optional<String> optionalOfNullable = Optional.ofNullable("value");
        Assertions.assertEquals("value", optionalOfNullable.get());
        Assertions.assertTrue(optionalOfNullable.isPresent());
        Assertions.assertFalse(optionalOfNullable.isEmpty());

        Optional<String> optionalOfNullableNull = Optional.ofNullable(null);
        Assertions.assertFalse(optionalOfNullableNull.isPresent());
        Assertions.assertTrue(optionalOfNullableNull.isEmpty());
    }

    @Test
    void Optional_map_과_flatMap_차이() {
        Optional<String> nullOptional = Optional.ofNullable(null);
        Optional<String> optionalName = Optional.ofNullable("John Doe");
        // map은 Optional 내부의 값을 변환하여 새로운 Optional을 반환
        Optional<Integer> optionalNameLength = optionalName.map(String::length);
        Assertions.assertEquals(8, optionalNameLength.get());

        // map은 null인 것도 안전하게 처리
        Optional<Integer> nullOptionalLength = nullOptional.map(String::length);
        Assertions.assertTrue(nullOptionalLength.isEmpty());


        // flatMap은 Optional 내부의 값을 변환하여 Optional을 반환하는 함수가 필요
        Optional<String> upperCaseOptional = optionalName.flatMap(name -> {
            if (name != null) {
                return Optional.of(name.toUpperCase());
            } else {
                return Optional.empty();
            }
        });
        Assertions.assertEquals("JOHN DOE", upperCaseOptional.get());

        // flatMap은 null인 것도 안전하게 처리
        Optional<String> nullUpperCaseOptional = nullOptional.flatMap(name -> {
            if (name != null) {
                return Optional.of(name.toUpperCase());
            } else {
                return Optional.empty();
            }
        });
        Assertions.assertTrue(nullUpperCaseOptional.isEmpty());
    }


}
