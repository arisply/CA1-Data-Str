package com.example.ca1;

public class CustomList<T> {

    private Node<T> head=null;

    public void addElement (T element){
        Node<T>newNode=new Node<>();
        newNode.setContents(element);
        newNode.next=head;
        head=newNode;
    }

    public void printList(){
        Node<T> temp=head;

        while(temp!=null){
            System.out.println(temp.getContents());
            temp=temp.next;
        }
    }

    public int size() {
        int count = 0;
        Node<T> temp = head;

        while (temp != null) {
            count++;
            temp = temp.next;
        }

        return count;
    }
}
