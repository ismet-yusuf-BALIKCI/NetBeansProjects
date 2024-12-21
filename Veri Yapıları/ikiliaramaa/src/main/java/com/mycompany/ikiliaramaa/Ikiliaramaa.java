package com.mycompany.ikiliaramaa;

public class Ikiliaramaa {

    Node root;
     static int dal = 0;

    public Ikiliaramaa() {
        root = null;
    }

    public void insert(int a) {
        insertr(root, a);
    }

    public static Node insertr(Node current, int a) {
        if (current == null) {
            current = new Node(a);
            return current;
        }
        if (current.data > a) {
            current.left = insertr(current.left, a);
        }
        if (current.data <= a) {
            current.right = insertr(current.right, a);
        }

        return current;
    }

    public static Node arama(Node current, int a) {
        if (current == null || current.data == a) {
            return current;
        }
        if (current.data > a) {
            dal++;
            return arama(current.left, a);
        } else {
            dal++;
            return arama(current.right, a);
        }
    }

    public void inOrder(Node current) {
        if (current != null) {
            inOrder(current.left);
            System.out.print(current.data + " ");
            inOrder(current.right);
        }
    }

    public void preOrder(Node current) {
        if (current != null) {
            System.out.print(current.data + " ");
            preOrder(current.left);
            preOrder(current.right);
        }
    }

    public void postOrder(Node current) {
        if (current != null) {
            postOrder(current.left);
            postOrder(current.right);
            System.out.print(current.data + " ");
        }
    }

    public static void main(String[] args) {
        Ikiliaramaa agac = new Ikiliaramaa();

        agac.insert(50);
        agac.insert(30);
        agac.insert(70);
        agac.insert(20);
        agac.insert(40);
        agac.insert(60);
        agac.insert(80);
        agac.inOrder(2);
    }
}
