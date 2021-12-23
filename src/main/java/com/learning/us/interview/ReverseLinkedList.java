package com.learning.us.interview;

import java.util.ArrayList;
import java.util.List;

public class ReverseLinkedList {
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
        }
        Node(int data,Node next){
            this.data=data;
            this.next=next;
        }

//        @Override
//        public String toString() {
//            return String.valueOf( this.data);
//        }
    }
    static class LinkedList{
        Node head;
        LinkedList(){
            this.head=null;
        }
        LinkedList(Node head){
            this.head=head;
        }

//        @Override
//        public String toString() {
//            List<String> list=new ArrayList<>();
//            while(head.next !=null)
//            {
//                head=head.next;
//                list.add(String.valueOf(head.toString()));
//            }
//            return list.toString();
//        }
    }



    public static void main(String[] args) {
        Node n5=new Node(7);
        Node n4=new Node(4,n5);
        Node n3=new Node(6,n4);
        Node n2=new Node(3,n3);
        Node n1=new Node(5,n2);
        LinkedList list=new LinkedList(n1);
        reverseList(list);
       // reverseLinkedListNonRecursive(list);
    }

    static void reverseList(LinkedList list){
        list.head=reverseNode(list.head);
        System.out.println(list);
        Node head=list.head;
        while(head!=null){
            System.out.println(head.data);
            head=head.next;
        }
    }

    static Node reverseNode(Node node){
        if(node==null || node.next==null)
            return node;
        Node reversed=reverseNode(node.next);
        node.next.next=node;
        node.next=null;
        return reversed;
    }
// 7 4 6 3 5
    static void reverseLinkedListNonRecursive(LinkedList list){
        Node previous=null;
        Node current= list.head;
        while(current!=null){
            Node next=current.next;
            current.next=previous;
            previous=current;
            current=next;
        }
        list.head=previous;
        System.out.println(list);
    }
}
