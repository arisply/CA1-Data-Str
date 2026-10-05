package com.example.ca1;

public class Node<T> {

    private T contents;
    public Node<T> next=null;

    public T getContents() {
        return contents;
    }

    public void setContents(T contents) {
        this.contents = contents;
    }
}
