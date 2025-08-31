package com.study.devstudy.java.record;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ShopTest {

    @Test
    void testEquals() {
        Shop shop1 = new Shop("마트", "서울시 강남구");
        Shop shop2 = new Shop("마트", "서울시 강남구");
        assertEquals(shop1, shop2);
        System.out.println(shop1);
        System.out.println(shop2);
    }

    @Test
    void testRecordEquals() {
        ShopRecord shop1 = new ShopRecord("마트", "서울시 강남구");
        ShopRecord shop2 = new ShopRecord("마트", "서울시 강남구");
        assertEquals(shop1, shop2);
        System.out.println(shop1);
        System.out.println(shop2);
    }

    @Test
    void testRecordCreator() {
        ShopRecord shop1 = new ShopRecord("마트");
        ShopRecord shop2 = ShopRecord.unnamed("서울시 강남구");
        Assertions.assertEquals("마트", shop1.name());
        Assertions.assertEquals("Unknown", shop1.address());
        Assertions.assertEquals("Unnamed", shop2.name());
        Assertions.assertEquals("서울시 강남구", shop2.address());
        Assertions.assertThrows(IllegalArgumentException.class, () -> new ShopRecord(null, null));
    }


}