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
        int count=0;
        Node<T> temp=head;

        while (temp!=null) {
            count++;
            temp=temp.next;
        }

        return count;
    }

    // Get element by index
    public T get(int index) {
        Node<T> temp=head;
        int count=0;
        while(temp!=null) {

            if(count==index) {
                return temp.getContents();
            }

            temp=temp.next;
            count++;
        }
        return null;
    }

    // Remove element by index
    public boolean remove(int index) {
        if(index<0||head==null) {
            return false;
        }
        if(index==0) {
            head=head.next;
            return true;
        }

        Node<T> temp=head;
        int i=0;
        while(i<index-1 && temp.next!=null) {
            temp=temp.next;
            i++;
        }

        if(temp.next!=null) {
            temp.next=temp.next.next;
            return true;
        }
        return false;
    }
}
