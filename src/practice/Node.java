package practice;

public class Node <E>{
    private Node<E> beforeNode;
    private Node<E> afterNode;
    private E value;

    public Node(E value, Node<E> beforeNode){
        this.value = value;
        this.beforeNode = beforeNode;
    }

    public void setBeforeNode(Node<E> beforeNode) {
        this.beforeNode = beforeNode;
    }

    public Node<E> getBeforeNode(){
        return this.beforeNode;
    }

    public void setAfterNode(Node<E> afterNode) {
        this.afterNode = afterNode;
    }

    public Node<E> getAfterNode(){
        return this.afterNode;
    }

    public void setValue(E value){
        this.value = value;
    }

    public E getValue(){
        return this.value;
    }

}
