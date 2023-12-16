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

    public Node<E> findNode(E data) {
        return findNode(topNode, data);
    }

    private Node<E> findNode(Node<E> node, E data) {
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

    public void remove(E data) {
        Node<E> removeNode = findNode(data);
        /** 존재 여부 확인 */
        if (!isExist(removeNode)) {
            return;
        }

        /** 리프 노드인지 아닌지 확인*/
        if (isLeafNode(removeNode)) {
            removeNode = null;
            return;
        } else {

        }
        /** 리프 노드가 아니라면, inorderSuccessor or inOrderPordeSuccessor 둘 중 하나의 방식으로 리프노드와 위치 바꾸기 */
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

    public boolean isExist(Node<E> node) {
        if (node != null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isExist(E data) {
        if (findNode(data) == null) {
            return false;
        } else {
            return true;
        }
    }

    private boolean isLeafNode(Node<E> node) {
        if (node.prev == null && node.next == null) {
            return true;
        } else {
            return false;
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
