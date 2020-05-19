package java.dataStructure.linkedList.single;

import java.util.*;

public class LinkedList<E> {

         Node head;
         Node tail;

         public boolean isEmpty() {
             if (head == null)
                 return true;
             else
                 return false;
         }

         public class Node {
             Node next;
             E data;

             Node(E data) {
                 this.data = data;
                 this.next = null;
             }
         }

         public void createLinkedList(Collection<? extends E> col) {
             Object[] eles = col.toArray();
             for (int i = 0; i < eles.length; i++)
                 addNode((E) eles[i]);
         }

         private void addNode(E ele) {
             Node newNode = new Node(ele);
             if (head == null) {
                 head = newNode;
                 tail = newNode;
             } else {
                 tail.next = newNode;
                 tail = newNode;
             }
         }

         private void deleteNode(E e) {
             Node prev = head;
             Node current = head.next;
             if (prev != null && prev.data == e) {
                 head = prev.next; // Changed head
                 return;
             }
             while (current != null && current.data !=e) {
                 current = current.next;
                 prev = prev.next;
             }
              if(current == null)
                  return;

              prev.next = current.next;
         }

         private void display() {
             Node current = head;

             while (current != null) {
                 System.out.print(current.data +"->"+" ");
                 current = current.next;
             }
             System.out.print("null");
             System.out.println();
         }

         private void clearLinkedList() {
             head = null;
         }

         public E getFirst() {
             return head.data;
         }

         public int length() {
             int length = 0;
             Node current = head;
             while (current != null) {
                 length++;
                 current = current.next;
             }
             return length;
         }

         public void push(E e) {
             Node newNode = new Node((E) e);
             newNode.next = head;
             head = newNode;
         }

         public void insertAfter(E after, E newValue) {
             Node current = head;
             Node newNode = new Node((E) newValue);
             while (current != null) {
                 if (current.data == after) {
                     newNode.next = current.next;
                     current.next = newNode;
                     break;
                 } else {
                     current = current.next;
                 }
             }
         }

         public E getNth(int index) {
             Node current = head;
             int count = 0;
             while (current != null) {
                 if (count == index)
                     return current.data;
                 count++;
                 current = current.next;
             }
             return null;
         }

         public E getMiddleElement(){
             Node current = head;
             int count = 0;
             int len = length();
             while(count != len/2){
                 count ++;
                 current = current.next;
             }
             return current.data;
         }

         //Floyd’s Cycle-Finding Algorithm
         public int detectLoop(){
             Node fastPointer = head;
             Node slowPointer = head;
             int count =0;
             while(slowPointer !=null && fastPointer !=null /*&& fastPointer.next != null */){
                 slowPointer = slowPointer.next;
                 fastPointer = fastPointer.next.next;
                 if(slowPointer == fastPointer){
                     while(slowPointer != fastPointer.next){
                        count++;
                        slowPointer = slowPointer.next;
                     }
                     return count;
                 }
             }
             return 0;
         }

         public void removeDuplicates(){
             Node current = head;
             Node prev = null;
             Set eleSet = new HashSet();

             while(current != null){
                 E data = current.data;
                 if(eleSet.contains(data)){
                     prev.next = current.next;
                     current = current.next;
                  }else{
                     eleSet.add(data);
                     prev = current;
                     current = current.next;
                 }
             }
          }

          private boolean isPresent(E e){
             Node current = head;
             while(current != null){
                 if (current.data == e)
                     return true;
                 else
                     current = current.next;
             }
             return false;
          }

          public void intersection(LinkedList l1,LinkedList l2){
             Collection<E> newList = new ArrayList<>();
             Node current = l1.head;

             while(current != null){
                 if(l2.isPresent(current.data)){
                     newList.add(current.data);
                 }
                 current =current.next;
             }
             LinkedList l3 = new LinkedList();
             l3.createLinkedList(newList);
             l3.display();
          }

          public void reverseList(){
             Node next;
             Node curr = head;
             Node prev = null;

             while (curr != null){
                 next = curr.next;
                 curr.next = prev;
                 prev = curr;
                 curr = next;
             }
             head = prev;
          }

          public void mergeTwoList(LinkedList l1,LinkedList l2){
             Node n1 = l1.head;
             Node n2 = l2.head;
             Node res = null;

             while(n1 != null && n2 != null){
                 if((int)n1.data < (int)n2.data){
                    res = n1;
                    n1 = n1.next;
                 }else {
                     res = n2;
                     n2 = n2.next;
                 }
             }

             while (n1 != null){
                 res.next = n1;
                 n1 = n1.next;
             }

             while (n2 != null){
                 res.next = n2;
                 n2 = n2.next;
             }

             res.next = null;
             while(res != null){
                 System.out.print(res.data+"->");
             }
              System.out.print("NULL");
          }
    public static void main(String[] a) {
        LinkedList singleLinkedListFirst = new LinkedList();
        ArrayList<Integer> firstList = new ArrayList<>();
        firstList.add(1);
        firstList.add(2);
        firstList.add(3);
        firstList.add(4);
        firstList.add(6);
        singleLinkedListFirst.createLinkedList(firstList);
        singleLinkedListFirst.display();
        /*singleLinkedListFirst.reverseList();
        singleLinkedListFirst.display();*/
        ArrayList<Integer> secondList = new ArrayList<>();
        LinkedList singleLinkedListSecond = new LinkedList();
        secondList.add(2);
        secondList.add(4);
        secondList.add(6);
        secondList.add(8);
        singleLinkedListSecond.createLinkedList(secondList);
        singleLinkedListSecond.display();
        singleLinkedListFirst.mergeTwoList(singleLinkedListFirst,singleLinkedListSecond);
        //singleLinkedListSecond.intersection(singleLinkedListFirst,singleLinkedListSecond);
        /*singleLinkedList.push("Z");
        singleLinkedList.insertAfter("Z","X");*/
        //singleLinkedList.push("Z");

        //singleLinkedList.removeDuplicates();
        //singleLinkedList.display();
        // singleLinkedList.display();
        //System.out.println("Middle Ele "+singleLinkedList.getMiddleElement());
        //singleLinkedList.head.next.next.next.next = singleLinkedList.head;
        //System.out.printf("Loop Present "+singleLinkedList.detectLoop());
        /*singleLinkedList.deleteNode("Z");
        singleLinkedList.display();
        singleLinkedList.clearLinkedList();
        /*System.out.println(singleLinkedList.getFirst());

        ArrayList<String> listString = new ArrayList<>();
        listString.add("A");
        listString.add("B");
        listString.add("C");
        singleLinkedList.createLinkedList(listString);
        singleLinkedList.display();*/
    }
}

