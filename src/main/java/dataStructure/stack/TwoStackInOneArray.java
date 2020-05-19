package dataStructure.stack;

public class TwoStackInOneArray {

    int arr[];
    int head1,head2;

    TwoStackInOneArray(int n){
        arr = new int[n];
        head1 = -1;
        head2 = n;
    }

    public void push1(int data){
        if(head1 > head2){
            System.out.println("OVERFLOW CONDITION");
         }else{
            arr[++head1] = data;
            System.out.println("Successfully pushed "+data+" into first stack. ");
        }

    }

    public void push2(int data){
        if(head2 < head1){
            System.out.println("OVERFLOW CONDITION");
         }else{
            arr[--head2] = data;
            System.out.println("Successfully pushed "+data+" into second stack. ");
        }
    }

    public int pop1(){
        if(head1 == -1){
          System.out.println("UNDERFLOW CONDITION");
          return -1;
        }else {
            return arr[head1--];
        }
    }

    public int pop2(){
        if(head2 ==  -1){
            System.out.println("UNDERFLOW CONDITION");
            return -1;
        }else {
            return arr[head2++];
        }
    }

    public static void main(String[] args) {
        TwoStackInOneArray ts = new TwoStackInOneArray(5);
        ts.push1(5);
        ts.push2(10);
        ts.push2(15);
        ts.push1(11);
        ts.push2(7);
        System.out.println("Popped element from" +
                " stack1 is " + ts.pop1());
        ts.push2(40);
        System.out.println("Popped element from" +
                " stack2 is " + ts.pop2());
    }
}

