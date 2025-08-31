package com.study.devstudy.java.stream;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 설명 :
 *
 * @author 김지애(Nova) / jiae.kim413@dreamus.io
 * @since 2023/01/26
 */
public class MapTest {

    @Test
    void flatmapTest() {
        Map<Long, TestClass> originList = new HashMap<>();
        originList.put(100L, new TestClass(100L, 1000L, "테스트1"));
        originList.put(101L, new TestClass(101L, 1000L, "테스트2"));
        originList.put(102L, new TestClass(102L, 1001L, "테스트3"));

        
    }

    private static class TestClass {
        private Long id;
        private Long parentId;
        private String name;

        public TestClass(Long id, Long parentId, String name) {
            this.id = id;
            this.parentId = parentId;
            this.name = name;
        }
    }
}
