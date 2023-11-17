package practice;

public class TreeMap<K, V> {

    /**
     * 트리맵은 키(index)와 값(value)를 각 Entry에 기록하는 트리형태의 자료구조
     * 트리맵은 가장 상단에 root라는 노드(Entry)가 위치하고
     * root의 키를 기준으로 작으면 왼쪽 노드, 크면 오른쪽 노드에 위치함.(이진트리구조: 자식 노드가 2개 이하)
     */

    // 요구사항(Tree)
    //1. 트리 생성
    //2. root
    //3. 자료 추가(put(K, V))
    //4. 자료 제거(remove())
    //5. 첫노드 조회(getFirstEntry())
    //6. 마지막노드 조회(getLastEntry())
    //7. 특정노드의 앞노드 조회(getSuccessor())
    //8. 특정노드의 뒷노드 조회(getPredecessor())
    //9. 특정노드의 왼쪽 노드 조회(leftOf(Entry))
    //10. 특정노드의 오른쪽 노드 조회(rightOf(Entry))
    //11. 특정 노드 삽입 후 조정(fixAfterInsertion(Entry))
    //12. 특정 노드 삭제 후 조정(fixAfterDeletion(Entry))
    //13. 특정 노드 삭제(deleteEntry(Entry))

    //< 궁금증 >
    //만약 아래와 같이 순서대로 값을 저장한다면 첫번째값이 root가 되고 그러다 보면 한쪽으로 편향된 트리가 만들어질 수 있음.
    //그렇다면, 이걸 어떻게 해결할 수 있을까?
    // [5, 4, 3, 2, 1]
    //         5 - root
    //       4
    //     3
    //   2
    // 1 - leaf

    // [위와 달리 이상적인 트리]
    //      3 - root
    //    2    4
    //  1        5 - leaf
    //
    //

    //이 문제를 해결하기 위해서 계층(layer)의 깊이를 기준으로 깊이가 개수에 비해 너무 깊어진다면, 트리구조를 회전(rotate)시켜줌.
    //위 첫째 트리를 두 번 오른쪽 회전하면 둘째 트리구조가 됨.
    //회전이란 결국 root를 바꿔주는 것.
    //일단 회전 구현은 나중에 생각하고 (잘 모르겠음)
    //기본적인 구현부터 해보자

    private Entry<K, V> root;

    private int size;

    public TreeMap(){
        this.root = null;
        this.size = 0;
    }

    public TreeMap(K key, V value){
        Entry<K, V> node = new Entry(key, value);
        this.root = node;
        this.size = 1;
    }


    public void put(K key, V value){
        Entry<K, V> node = new Entry(key, value);
        if(root == null){
            root = node;
            this.size++;
            return;
        }

        Entry<K, V> tempNode = root;
        Entry<K, V> parentNode = null;
        //비교해서 노드 계층을 내려가는데 더이상 내려갈 수 없으면 거기에 저장
        while(tempNode != null){
            //임시 노드키가 더 크면 왼쪽으로 보냄.
            if(tempNode.getKey().hashCode() > node.getKey().hashCode()){
                parentNode = tempNode;
                tempNode = tempNode.getLeft();
                if(tempNode == null){
                    parentNode.setLeft(node);
                    this.size++;
                } else {
                    tempNode.setParent(parentNode);
                    parentNode.setLeft(tempNode);
                }
            //임시 노드키가 더 작으면 오른쪽으로 보냄.
            } else if(tempNode.getKey().hashCode() < node.getKey().hashCode()){
                parentNode = tempNode;
                tempNode = tempNode.getRight();
                if(tempNode == null){
                    parentNode.setRight(node);
                    this.size++;
                } else {
                    tempNode.setParent(parentNode);
                    parentNode.setRight(tempNode);
                }
            } else if(tempNode.getKey().hashCode() == node.getKey().hashCode()){
                tempNode.setValue(node.value);
                break;
            }
        }

        //값을 엎어씌워서 while을 빠져나온 케이스(tempNode != null)
        //최종까지 내려온 케이스(tempNode == null)

    }

    public Entry<K, V> getFirstEntry(){
        System.out.println("루트의 키는 " + root.getKey() + ", 루트의 값은 " + root.getValue());
        return root;
    }

    public void printAll(){
        print(root);
    }

    private Entry<K, V> print(Entry<K, V> node){
        if(node != null){
            System.out.println("(키) " + node.getKey() + "(값) " + node.getValue());
            if(node.getLeft() != null){
                print(node.getLeft());
            }
            if(node.getRight() != null){
                print(node.getRight());
            }
        }
        return null;
    }


    static class Entry <K, V>{

        //요구사항(Entry)
        //1. 키, 값, 왼쪽노드, 오른쪽노드, 부모노드 관리

        private K key;
        private V value;

        Entry<K, V> left;
        Entry<K, V> right;
        Entry<K, V> parent;

        Entry(K key, V value){
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
            this.parent = null;
        }

        K getKey(){
            return this.key;
        }

        V getValue() {
            return this.value;
        }

        void setValue(V value){
            this.value = value;
        }

        Entry<K, V> getLeft(){
            return this.left;
        }

        void setLeft(Entry<K, V> node){
            this.left = node;
        }

        Entry<K, V> getRight(){
            return this.right;
        }

        void setRight(Entry<K, V> node){
            this.right = node;
        }

        void setParent(Entry<K, V> node){
            this.parent = node;
        }
    }

}

