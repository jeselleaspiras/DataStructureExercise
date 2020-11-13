package com.example.datastructureexercise;

public class BinaryTree {

    public NodeTree root;

    // Insert element
    public NodeTree addElement(NodeTree element, int value) {
        if (element == null) {
            element = new NodeTree(value);
            return element;
        }

        if (value < element.value) {
            element.left = addElement(element.left, value);
        } else {
            element.right = addElement(element.right, value);
        }
        return element;
    }

    public void add(int value) {
        root = addElement(root, value);
    }


    // Find element ( left element < right element )
    public NodeTree findElement(NodeTree element, int value) {
        if (element.value == value) {
            return element;
        }

        NodeTree n1 = findElement(element.left, value);
        if (n1 != null) {
            System.out.println("Element found");
        }

        NodeTree n2 = findElement(element.right, value);
        if (n2 != null) {
            System.out.println("Element found");
        }

        return element;
    }


    // Traversing ( inorder = check left first -> root -> right)
    public void traverseTree (NodeTree element){
        traverseTree (element.left);
        traverseTree (element.right);
    }


    public static void main(String[] args) {

    }
}
