package com.learning.us.interview;

public class PalindromeLinkedList {
    public static void main(String[] args) {
        ReverseLinkedList.Node n5=new ReverseLinkedList.Node(1);
        ReverseLinkedList.Node n4=new ReverseLinkedList.Node(2,n5);
        ReverseLinkedList.Node n3=new ReverseLinkedList.Node(3,n4);
        ReverseLinkedList.Node n2=new ReverseLinkedList.Node(2,n3);
        ReverseLinkedList.Node n1=new ReverseLinkedList.Node(1,n2);
        ReverseLinkedList.LinkedList list=new ReverseLinkedList.LinkedList(n1);
        System.out.println(isPalindromeList(list));;
    }

    public static boolean isPalindromeList(ReverseLinkedList.LinkedList list){
        ReverseLinkedList.Node slow,fast;
        ReverseLinkedList.Node head=list.head;
        slow=fast=head;
        while(slow.next!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        slow=ReverseLinkedList.reverseNode(slow);
        head= list.head;
        while(slow!=null){
            if(slow.data!= head.data)
                return false;
            slow=slow.next;
            head=head.next;
        }
       return true;
    }
}
