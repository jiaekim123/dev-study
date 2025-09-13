package com.study.devstudy.arraydeque;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class ArrayDequeBasic {
    @Test
    @DisplayName("ArrayDeque 기본 양방향 연산 테스트")
    void testBasicOperations() {
        // 기본 양방향 연산테스트
        Deque<String> deque = new ArrayDeque<>();

        // 양쪽 끝에 추가하기
        deque.addFirst("B");
        deque.addLast("C");
        deque.addFirst("A");
        deque.addLast("D");

        assertThat(deque.toString()).isEqualTo("[A, B, C, D]");

        // 양쪽 끝 조회
        assertThat(deque.peekFirst()).isEqualTo("A");
        assertThat(deque.peekLast()).isEqualTo("D");

        // 양쪽 끝 제거
        assertThat(deque.pollFirst()).isEqualTo("A");
        assertThat(deque.pollLast()).isEqualTo("D");

        // 사이즈 확인
        assertThat(deque.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("ArrayDeque를 스택처럼 사용하기")
    void testAsStack() {
        Deque<Integer> stack = new ArrayDeque<>();

        // Push (LIFO)
        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertThat(stack.toString()).isEqualTo("[3, 2, 1]");

        // Pop (LIFO)
        assertThat(stack.pop()).isEqualTo(3);
        assertThat(stack.peek()).isEqualTo(2);
        assertThat(stack.toString()).isEqualTo("[2, 1]");
    }

    @Test
    @DisplayName("ArrayDeque를 큐처럼 사용하기")
    void testAsQueue() {
        Deque<String> queue = new ArrayDeque<>();

        // Enqueue 연산 (FIFO)
        queue.offer("A");
        queue.offer("B");
        queue.offer("C");

        assertThat(queue.toString()).isEqualTo("[A, B, C]");

        // Dequeue 연산 (FIFO)
        assertThat(queue.poll()).isEqualTo("A");
        assertThat(queue.peek()).isEqualTo("B");
        assertThat(queue.toString()).isEqualTo("[B, C]");

    }

    @Test
    @DisplayName("ArrayDeque vs LinkedList")
    void testPerformance() {
        int size = 1000000;
        long start = System.nanoTime();
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < size; i++) {
            deque.addFirst(i);
        }
        long arrayDequeTime = System.nanoTime() - start;

        start = System.nanoTime();
        List<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            linkedList.add(i);
        }
        long linkedListTime = System.nanoTime() - start;

        start = System.nanoTime();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(i);
        }
        long arrayListTime = System.nanoTime() - start;

        System.out.println("ArrayDeque Time : " + arrayDequeTime + " ns");
        System.out.println("LinkedList Time : " + linkedListTime + " ns");
        System.out.println("ArrayList Time : " + arrayListTime + " ns");
    }
}
