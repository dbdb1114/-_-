package BinarySearchTree;

import java.util.LinkedList;
import java.util.Optional;
import org.w3c.dom.Node;

public class BinarySearchTree<E> {

    int size;
    Node<E> topNode;
    BinarySearch<E> binarySearch;

    public BinarySearchTree(BinarySearch<E> binarySearch) {
        this.binarySearch = binarySearch;
    }

    public int size() {
        return size;
    }

    public E getTop() {
        return topNode.data;
    }


    public Node<E> findNode(Node<E> node, E data) {
        if (node == null) {
            return null;
        }
        if (node.data == data) {
            return node;
        }

        if (binarySearch.condition(node.data, data)) {
            return findNode(node.next, data);
        } else {
            return findNode(node.prev, data);
        }
    }


    public void add(E data) {
        insertRecursive(topNode, data);
    }

    /**
     * 재귀적 작성
     */
    private Node<E> insertRecursive(final Node<E> node, E data) {
        if (node == null) {
            return new Node(data);
        }

        if (binarySearch.condition(node.data, data)) {
            node.prev = insertRecursive(node.prev, data);
        } else {
            node.next = insertRecursive(node.next, data);
        }

        return node;
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
