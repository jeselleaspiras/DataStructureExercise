package com.example.datastructureexercise;

public class Node {

    public int first;
    public Node next;

    public Node (int first) {
        this.first = first;
        this.next = null;
    }

    public int getFirst() {
        return first;
    }

    public Node getNext() {
        return next;
    }

    public void setFirst(int first) {
        this.first = first;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public static void main(String[] args) {

    }


}
