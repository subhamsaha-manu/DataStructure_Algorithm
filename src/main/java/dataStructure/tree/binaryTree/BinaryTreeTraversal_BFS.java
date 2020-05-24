package dataStructure.tree.binaryTree;


import java.util.*;

/**
 * Using Breadth First Search
 */
public class BinaryTreeTraversal_BFS {

    public static void breadthFirstTraversal(Node root){
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



    public static void main(String []a){

        List<Integer> list = new ArrayList(Arrays.asList(6,4,8,3,5,7,9));
        BinarySearchTree bst = new BinarySearchTree();
        Node root= bst.addNodeFromCollection(list);
        breadthFirstTraversal(root);

    }
}
