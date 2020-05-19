package main.java.dataStructure.linkedList.circular;

import java.util.ArrayList;
import java.util.List;

public class CircularLinkedList {

    public class Node {

        Node next;
        int data;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node head = null;

    public boolean isEmpty() {
        if (head == null)
            return true;
        else
            return false;
    }

    public void addNode(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node tmp = head;
            while (tmp.next != head) {
                tmp = tmp.next;
            }
            tmp.next = newNode;
        }
        newNode.next = head;
    }

    public void displayList() {
        Node tmp = head;
        int data = head.data;
        do {
            System.out.print(tmp.data + "->");
            tmp = tmp.next;
        } while (tmp != head);
        System.out.print(data);
        System.out.println();
    }

    public int countNoOfNodes() {
        int count = 0;
        Node tmp = head;
        do {
            count++;
            tmp = tmp.next;
        } while (tmp != head);
        return count;
    }

    public void sortedInsert(int data){
        Node sptr =head,fptr = head.next;
        Node newNode = new Node(data);
        while (fptr != head){
            if(sptr.data<data && data<fptr.data){
                Node tmp = sptr;
                newNode.next = tmp.next;
                tmp.next = newNode;
            }
            sptr = sptr.next;
            fptr = fptr.next;

        }
    }

    public static int findMaxElement(){
        int maxEle = -1;
        Node current = head;

        while(current.next !=head){
            if(current.data > maxEle)
                maxEle = current.data;
            current = current.next;
        }
        return maxEle;
    }

    private static List<Integer> createFibonacciListUpto (int limit){
        int a=0,b=1,c =0;
        List<Integer> fibonacciList = new ArrayList<>();
        while(c <= limit){
            c = a + b;
            fibonacciList.add(c);
            a = b;
            b = c;
        }
        return fibonacciList;
    }
    public void deleteFibonacciNodes(){

        Node current = head;
        int maxEle = findMaxElement();
        List<Integer> fibonacciList = createFibonacciListUpto(maxEle);

        while (current.next != head){
            if(fibonacciList.contains(current.data))
                deleteNode(current);
            current = current.next;

        }
    }

    public void deleteEvenPositionedNodes(){
        Node current = head;
        int i =0;
        while (current.next != head){
            if(i % 2 == 0)
                deleteNode(current);
            current = current.next;
            i++;
        }
    }

    public void deleteNode(Node del){
        Node current = head;
        if(head == del){
            head = del.next;
        }
        while(current.next != del)
            current = current.next;

        current.next = del.next;

        del = null;

        return;
    }
    public static void main(String[] args) {
        CircularLinkedList cLL = new CircularLinkedList();
        System.out.println(cLL.isEmpty());
        cLL.addNode(99);
        cLL.addNode(11);
        cLL.addNode(22);
        cLL.addNode(33);

        cLL.displayList();
       //cLL.sortedInsert(1);
        int maxEle = findMaxElement();
        //System.out.println("Max Ele is "+maxEle);
        //System.out.println(createFibonacciListUpto(maxEle));
       // cLL.deleteFibonacciNodes();
        cLL.deleteEvenPositionedNodes();
        cLL.displayList();
        System.out.println(cLL.countNoOfNodes());
    }

}
