package dataStructure.tree.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeInsertion {

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
        BinaryTreeTraversal_BFS btt = new BinaryTreeTraversal_BFS();
        Node root = new Node(1);
        nbt.createTree(root);
        btt.breadthFirstTraversal(root);
        insertion(root,4);
        btt.breadthFirstTraversal(root);
    }
}
