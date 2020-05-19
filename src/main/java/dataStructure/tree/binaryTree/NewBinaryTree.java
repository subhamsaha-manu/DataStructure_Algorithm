package main.java.dataStructure.tree.binaryTree;

class Node{

    int data;
    Node right,left;

    public Node(int data){
        this.data = data;
        this.right = this.left = null;
    }
}

public class NewBinaryTree {

    static Node root;

    NewBinaryTree(int data){
        this.root = new Node(data);
    }

    NewBinaryTree(){
        this.root = null;
    }

    public void createTree(Node root){

        root.left = new Node(2);
        root.right = new Node(3);

        /*
                    1
                  /  \
                2     3
              /  \  /  \
          null null null   null
        */

        root.left.right = new Node(5);

        root.right.left = new Node(6);
        root.right.right = new Node(7);
    }

    public Node getRoot(){
        return root;
    }
    public static void main(String [] a){
        NewBinaryTree nbt = new NewBinaryTree();
        root = new Node(1);

        /*
                    1
                  /  \
              null   null
        */
        nbt.createTree(root);
    }

}
