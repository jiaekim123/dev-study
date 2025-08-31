package com.study.devstudy.java.record;

public record ShopRecord(String name, String address) {
    public static String UNKNOWN_ADDRESS = "Unknown";

    public ShopRecord(String name) {
        this(name, UNKNOWN_ADDRESS);
    }

    public ShopRecord {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("상점 이름은 필수입니다.");
        }
        if (address == null || address.isBlank()) {
            throw new IllegalArgumentException("상점 주소는 필수입니다.");
        }
    }

    public static ShopRecord unnamed(String address) {
        return new ShopRecord("Unnamed", address);
    }
}
