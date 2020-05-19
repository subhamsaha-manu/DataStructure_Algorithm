package java.dataStructure.stack;

public class StackAsLinkedList<E> {

    StackNode head;

    public class StackNode{
        E data;
        StackNode next;

        StackNode(E data){
            this.data = data;
            this.next = null;
        }
    }

    public boolean isEmpty(){
        if(head == null)
            return true;
        else
            return false;
    }

    public void push(E data){
        StackNode node = new StackNode(data);
        if(head == null){
            head = node;
        }else{
            //StackNode tmp = head;
            node.next = head;
            head = node;
        }

        System.out.println(data + " pushed to stack");
    }

    public E pop(){
        E popped= null;
        if(head == null)
            System.out.println("UNDERFLOW OPERATION");
        else{
            popped = head.data;
            head = head.next;
        }
        return popped;
    }

    public E peek(){
        if(head ==  null){
            System.out.println("Stack is Empty");
            return null;
        }else{
            return head.data;
        }
    }
}
