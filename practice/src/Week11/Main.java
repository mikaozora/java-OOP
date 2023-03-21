package Week11;

import java.util.prefs.NodeChangeEvent;

public class Main {
    static void cetak() {
        int id = (int) (Math.random() * 100);
        int a = 0;
        while (a < 10) {
            System.out.println(id + " thread " + a++);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
//        BST<String> bst = new BST<>();
//        bst.push("Kevin");
//        bst.push("harvi");
//        bst.push("ryan");
//        bst.push("bijox");
//        bst.push("jekis");
//        bst.viewTree();
//
//        BST<Integer> angka = new BST<>();
//        for (int i = 0; i < 100; i++) {
//            angka.push((int)(Math.random() * 1000));
//        }
//        angka.viewTree();

//        Thread th = new Thread(Main::cetak); //atau
        Thread th = new Thread(new Runnable() {
            @Override
            public void run() {
                cetak();
            }
        });
        th.start();
        Thread th1 = new Thread(Main::cetak);
        th1.start();
        for (int i = 0; i < 10; i++) {
            System.out.println("test");
        }
    }
}

class Node<T> {
    T data;
    Node<T> left = null;
    Node<T> right = null;
    int key;

    public Node(T data, int key) {
        this.data = data;
        this.key = key;
    }
}

class BST<T> {
    Node<T> root;

    public BST() {
        root = null;

    }

    private Node<T> push(Node<T> curr, int key, T data) {
        if (curr == null) {
            return new Node(data, key);
        } else {
            if (key < curr.key) {
                curr.left = push(curr.left, key, data);
            } else {
                curr.right = push(curr.right, key, data);
            }
            return curr;
        }
    }

    public void push(T data) {
        root = push(root, (int) (Math.random() * 1000), data);
    }

    private void viewTree(Node<T> curr, int level) {
        if (curr != null) {
            viewTree(curr.right, level + 1);
            for (int i = 0; i < level; i++) {
                System.out.print("    ");
            }
            System.out.println(curr.key + " " + curr.data);
            viewTree(curr.left, level + 1);
        }
    }

    public void viewTree() {
        viewTree(root, 0);
    }
}
