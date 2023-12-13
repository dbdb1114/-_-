package BinarySearchTree;

import java.util.LinkedList;
import java.util.Optional;
import org.w3c.dom.Node;

public class BinarySearchTree<E>{

    Node<E> topNode;
    BinarySearch<E> binarySearch;

    public BinarySearchTree(BinarySearch<E> binarySearch) {
        this.binarySearch = binarySearch;
    }

    int size;

    public void add(E data) {
        if (topNode == null) {
            topNode = new Node<E>(data);
            return;
        }
    }

    public class Node<E> {
        public Node(E data) {
            this.data = data;
        }

        E data;
        Node<E> prev;
        Node<E> next;
    }

}
