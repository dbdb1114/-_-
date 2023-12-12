package BinarySearchTree;

import java.util.LinkedList;
import org.w3c.dom.Node;

public class BinarySearchTree<E>{

    Node<E> topNode;
    BinarySearch binarySearch;

    public E getTopNode() {
        return topNode.getData();
    }
    public BinarySearchTree(BinarySearch<E> binarySearch){
        this.binarySearch = binarySearch;
    }

    /**
     *      1. 탐색을 한다. ( -1, 0 , 1 )
     *         1) 검사하는 노드의 데이터 보다 클때 오른쪽, 작을 때 왼쪽
     *         2) 작고, 왼쪽이 비었다면 왼쪽에 추가
     *         3) 크고, 오른쪽이 비었다면 오른쪽에 추가
     *      2. 조건에 맞는 위치가 있다.
     *      3. 해당 위치에 추가한다.
     * */
    public Node findNode(Object data){
        if ( topNode == null ){
            return topNode;
        }
        if( data.equals(topNode.data) ){ // 존재함
            return topNode;
        } else if(binarySearch.condition(data, topNode.data)){ // 오른쪽
            return findNode(data, topNode.right);
        } else { // 왼쪽
            return findNode(data, topNode.left);
        }
    }
    public Node findNode(Object data, Node node ){
        if ( node == null ){
            return node;
        }
        if( data.equals(node.data) ){ // 존재함
            return node;
        } else if (binarySearch.condition(data, topNode.data)) { // 오른쪽
            return findNode(data, node.right);
        } else { // 왼쪽
            return findNode(data, node.left);
        }
    }
    public void add( E data ) {
        if(topNode == null ){
            topNode = new Node(data);
        }
        Node emptyNode = findNode(data);
        if(emptyNode == null){
            emptyNode = new Node(data);
        }
    }

    public void remove( E data ) {
        Node<E> node = findNode(data);
        node.data = null;
        sort(node);
    }

    public void sort( Node<E> node ){

        if( node == null ) {
            return;
        }

        if( node.right != null) {
            node.data = node.right.data;
            sort(node.right);
        } else if ( node.left != null) {
            node.data = node.left.data;
            sort(node.left);
        }
    }

    public boolean isExist(Object data){
        if( findNode(data) == null) {
            return false;
        } else {
            return true;
        }
    }

    public class Node<E> {
        public Node(E data) {
            this.data = data;
        }

        public E getData() {
            return data;
        }

        E data;
        Node<E> left;
        Node<E> right;
    }

}
