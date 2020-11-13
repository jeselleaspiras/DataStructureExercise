package com.example.datastructureexercise;

import java.util.Objects;

public class Queue {

    public Node first;
    public Node last;
    public int size;

    public Queue() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    public Node getFirst() {
        return first;
    }

    public Node getLast() {
        return last;
    }

    public void pushNode (Node node) {
        if (this.size==0){
            this.first = node;
            this.last = node;
        }
        else {
            this.last.setNext(node);
            this.last = node;
        }
        this.size++;
    }

    public Node popNode (Node node) {
        this.size--;
        Node n = this.first;
        this.first = this.first.getNext();
        return n;
    }

}
