package dataStructure.tree.binaryTree;

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

        root.left = new Node(20);
        root.right = new Node(30);

        /*
                    10
                  /  \
                20     30
              /  \  /  \
          null null null   null
        */

        /*root.left.right = new Node(5);

        root.right.left = new Node(6);
        root.right.right = new Node(7);*/
        root.right.right = new Node(40);
    }

    public Node getRoot(){
        return root;
    }
    public static void main(String [] a){
        NewBinaryTree nbt = new NewBinaryTree();
        root = new Node(10);

        /*
                    1
                  /  \
              null   null
        */
        nbt.createTree(root);
    }

}
