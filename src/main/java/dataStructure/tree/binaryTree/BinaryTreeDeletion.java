package dataStructure.tree.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeDeletion {


    public Node getDeepestNode(Node root){
        Node temp = null;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            temp =  queue.poll();
            if(temp.left != null)
                queue.add(temp.left);
            if(temp.right != null)
                queue.add(temp.right);
            if(queue.size() == 0){
                System.out.println("Last Node is "+temp.data);
                return temp;
            }
        }
        return temp;
    }
    public void deletion(Node root,int deleteNode){
            Node deepestNode = getDeepestNode(root);
            Queue<Node> queue = new LinkedList<>();
            Node temp = null;
            queue.add(root);
            while(!queue.isEmpty()){
                temp = queue.poll();
                if(temp.left != null){
                    queue.add(temp.left);
                }
                if(temp.right != null){
                    queue.add(temp.right);
                }
                if(temp.data == deleteNode){
                    temp.data = deepestNode.data;
                    deleteNode (deepestNode,root);
                }
            }
    }

    private void deleteNode(Node deepestNode,Node root){
        Node temp = null;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            temp = queue.poll();
            if (temp == deepestNode){
                temp = null;
                return;
            }
            if(temp.left != null){
                if(temp.left == deepestNode){
                    temp.left = null;
                    return;
                }else {
                    queue.add(temp.left);
                }
            }
            if(temp.right != null){
                if(temp.right == deepestNode){
                    temp.right = null;
                    return;
                }else {
                    queue.add(temp.right);
                }
            }
        }
    }



    public static void main(String []args){
        NewBinaryTree nbt = new NewBinaryTree();
        Node root = new Node(10);
        nbt.createTree(root);
        BinaryTreeTraversal_BFS.breadthFirstTraversal(root);
        BinaryTreeDeletion btd = new BinaryTreeDeletion();
        btd.deletion(root,20);
        BinaryTreeTraversal_BFS.breadthFirstTraversal(root);
    }
}
