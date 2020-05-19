package java.dataStructure.tree.binaryTree;


import java.util.LinkedList;
import java.util.Queue;


public class BinaryTreeTraversal {

    private static void breadthFirstTraversal(Node root){
        Node temp = null;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            temp = queue.poll();
            System.out.print(temp.data+"-->");
            if (temp.left!=null)
                queue.add(temp.left);
            if (temp.right!=null)
                queue.add(temp.right);
        }
        System.out.print("null");
        System.out.println();
    }

    private static void insertion(Node root,int data){
        Node temp = null;
        Queue<Node> queue = new LinkedList<>();
        Node newNode = new Node(data);
        queue.add(root);
        while (!queue.isEmpty()){
            temp = queue.poll();
            if(temp.left != null)
                queue.add(temp.left);
            else {
                temp.left = newNode;
                break;
            }
            if(temp.right != null)
                queue.add(temp.right);
            else{
                temp.right = newNode;
                break;
            }
        }
    }

    public static void main(String []a){

        NewBinaryTree nbt = new NewBinaryTree();
        Node root = new Node(1);
        nbt.createTree(root);
        breadthFirstTraversal(root);
        insertion(root,4);
        breadthFirstTraversal(root);
    }
}
