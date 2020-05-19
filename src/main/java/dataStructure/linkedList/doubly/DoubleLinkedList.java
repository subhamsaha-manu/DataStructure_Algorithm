package main.java.dataStructure.linkedList.doubly;

public class DoubleLinkedList {

    public class Node {
        Node next;
        Node prev;
        int data;

        Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    Node head = null;
    int count =0;

    public void addNode(int data){
        if(head == null){
            head = new Node(data);
            return;
        }
        if(head != null){
            Node newNode = new Node(data);
            Node current = head;
            while(current.next != null)
                current = current.next;
            current.next = newNode;
            newNode.prev = current;
        }
    }

    public void display(boolean showReverse){
        Node current = head;
        Node last = null;
        System.out.println("Traversal in forward direction");
        System.out.print("null"+" <====> ");
        while (current != null){
            System.out.print(current.data+ " <====> ");
            last = current;
            current = current.next;
            count++;
        }
        System.out.print("null"+"\n");
        if(showReverse){
            System.out.println("Traversal in backward direction");
            System.out.print("null"+" <====> ");
            while(last != null){
                System.out.print(last.data+ " <====> ");
                last = last.prev;
            }
            System.out.print("null"+"\n");
        }
    }

    public void insertAfterNode(int nodeData,int data){
        Node current = head;
        Node newNode = new Node(data);
        while (current.data != nodeData){
            current = current.next;
        }
        newNode.next = current.next;
        current.next = newNode;
        newNode.prev = current;
        if(newNode.next != null)
            newNode.next.prev = newNode;
    }


    public void swapNodes(int kthPos){
        Node current = head;
        Node swapA = null;
        Node swapB = null;
        int linkedListLength = count;
        int presentCount = 0;
        while (current != null){
            if(presentCount == kthPos){
                swapA = current;
            }
            if((linkedListLength - presentCount - 1 == kthPos)){
                swapB = current;
            }
            current = current.next;
            presentCount++;
        }
        Node temp = swapB;
        swapA.prev.next = swapB;
        swapB.prev = swapA.prev;
        swapB.next.prev = swapA;
        swapB.next = swapA.next;

        swapA.next.prev =swapB;
        swapA.next = temp;
        temp.prev.next = swapA;
        swapA.prev = temp.prev;

        System.out.println("Swap "+swapA.data+"\t"+swapB.data);
    }

    public void rotate(int k){
        for(int i =0;i<k;i++){
            //rotateDll();
        }
    }

    public void reverseDll(){
        Node current = head;
        while (current.next != null)
            current = current.next;
        while(head != null || current != null || head.next != current.prev){
            swapNodes(head,current);
        }
    }

    private void swapNodes(Node a, Node b) {
        Node temp = null;
     if(a.prev==null && b.next==null){
        temp = b;
        a.next.prev = b;
        b.next = a.next;
        a.prev = temp.prev;
        temp.prev.next = a;
        a.next = null;
        b.prev = null;
     }
    }

    public void swapKth(int k){
        Node current = head;
        while(current != null)
            current = current.next;
        Node tail = current;
        int i =1;
        Node currHead = null;
        for(Node curr = head;curr != null;curr = curr.next){
            if(i == 1) {
                currHead = curr;
            }
            if(i == k){
                Node temp = currHead;
                currHead.next.prev = curr;
                currHead.next = curr.next;
                currHead.prev = curr.prev;
                curr.prev.next = currHead;

            }
        }
    }



    public static void main(String []a){
        DoubleLinkedList dll = new DoubleLinkedList();
        dll.addNode(1);
        dll.addNode(2);
        dll.addNode(6);
        dll.addNode(4);
        dll.addNode(5);
        dll.addNode(3);
        dll.addNode(7);
        dll.addNode(8);
        dll.display(false);
        System.out.println("The number of nodes are "+dll.count);
        //dll.swapNodes(2);
        dll.rotate(2);
        dll.display(false);
    }
}
