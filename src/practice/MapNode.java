package practice;

public class MapNode <K, V>{

    private K key;
    private V value;

    private MapNode<K,V> beforeNode = null;
    private MapNode<K,V> afterNode = null;

    public MapNode(K key, V value, MapNode<K, V> beforeNode){
        this.key = key;
        this.value = value;
        this.beforeNode = beforeNode;
    }

    public K getKey(){
        return this.key;
    }

    public V getValue(){
        return this.value;
    }

    public void setValue(V value){
        this.value = value;
    }

    public MapNode<K, V> getBeforeNode(){
        return this.beforeNode;
    }

    public void setBeforeNode(MapNode<K, V> beforeNode) {
        this.beforeNode = beforeNode;
    }

    public MapNode<K, V> getAfterNode(){
        return this.afterNode;
    }

    public void setAfterNode(MapNode<K, V> afterNode) {
        this.afterNode = afterNode;
    }
}
