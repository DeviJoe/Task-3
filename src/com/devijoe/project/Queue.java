package com.devijoe.project;

import java.util.List;

public class Queue<T> {

    /**
     * Узел очереди
     */
    private class Node {

        public transient T value;
        public transient Node next;

        public Node(T value, Node next) {
            this.next = next;
            this.value = value;
        }

        public Node() {
            this(null, null);
        }
    }

    // Первый элемент очереди
    private Node head = null;
    // Последний элемент очереди
    private Node tail = null;
    // Длина очереди
    private int size = 0;

    /**
     * Получение длины очереди
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * Подсмотреть и удалить верхушку очереди
     * @return
     * @throws Exception
     */
    public T get() throws Exception {
        if (head == null) {
            throw new Exception("Queue is EMPTY!");
        }
        T result = head.value;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return result;
    }

    /**
     * Удаление верхушки
     * @throws Exception
     */
    public void poll() throws Exception {
        if (head == null) {
            throw new Exception("EMPTY!");
        }
        T result = head.value;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
    }

    /**
     * Удаление верхушки
     * @throws Exception
     */
    public void remove() throws Exception {
        poll();
    }

    /**
     * Удаление первого вхождения элемента в очередь
     */
    public void remove(T t) throws Exception {
        if (head.value == t) {
            remove();
        } else {
            Node x = head;
            Node prev = null;
            while (!(x.value == t)) {
                prev = x;
                x = x.next;
            }
            prev.next = x.next;
        }
    }

    /**
     * Добавление элемента
     * @param t
     */
    public void add(T t) {
        if (head == null) {
            head = tail = new Node(t, null);
        } else {
            tail.next = new Node(t, null);
            tail = tail.next;
        }
        size++;
    }

    /**
     * Очистка очереди
     */
    public void clear() {
        head.value = null;
        head.next = null;
        tail.value = null;
        size = 0;
    }

    /**
     * Показывает вершину очереди
     */
    public T peek() {
        return head.value;
    }

    /**
     * Проверка на пустоту
     * @return
     */
    public boolean isEmpty() {
        if (size==0) {
            return true;
        } else {
            return false;
        }
    }

    public void addList(List<T> list) {
        for (int i = 0; i < list.size(); i++) {
            add(list.get(i));
        }
    }

}
