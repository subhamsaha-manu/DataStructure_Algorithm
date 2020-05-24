package dataStructure.tree.binaryTree;

import java.util.List;

public class BinarySearchTree {

    static Node root = null;

    private Node addRecursively(Node current,int value){
        if(current == null){
            System.out.println("Creating new Node with value "+value);
            return new Node(value);
        }else if(value < current.data){
            current.left = addRecursively(current.left,value);
        }else if (value > current.data){
            current.right = addRecursively(current.right,value);
        }else {
            return current;
        }
        return current;
    }

    private void add(int value){
        root = addRecursively(root,value);
    }


    public Node addNodeFromCollection(List<Integer> list){
        Node newRoot = new Node(list.get(0));
        root = newRoot;
        System.out.println("Creating Root Node with value "+root.data);
        for(int i =1;i<list.size();i++)
            add(list.get(i));
        return root;
    }
}
