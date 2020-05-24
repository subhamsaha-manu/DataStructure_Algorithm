package dataStructure.tree.binaryTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Class to traverse a binary tree using the
 * 3 DFS techniques. 1.Inorder 2.Preorder 3.Postorder
 */
public class BinaryTreeTraversal_DFS {

    private static void inOrder(Node node){
        if(node == null)
            return;
        inOrder(node.left);
        System.out.print(node.data+"--> ");
        inOrder(node.right);
    }

    public static void inOrderTraversal(Node root){
        inOrder(root);
        System.out.print("null\n");
    }

    public static void main(String []a){
        List<Integer> list = new ArrayList(Arrays.asList(6,4,8,3,5,7,9));
        BinarySearchTree bst = new BinarySearchTree();
        Node root= bst.addNodeFromCollection(list);
        inOrderTraversal(root);
    }

}
