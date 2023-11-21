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
    //7. 특정노드의 앞노드 조회(getSuccessor())   -> parent와 동일?? 회전할 노드를 조회하는 건가?
    //8. 특정노드의 뒷노드 조회(getPredecessor()) ->
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
        Entry<K, V> inputNode = new Entry(key, value);
        if(root == null){
            root = inputNode;
            this.size++;
            return;
        }

        Entry<K, V> tempNode = root;    //루트부터 임시노드 시작
        Entry<K, V> parentNode = null;
        //비교해서 노드 계층을 내려가는데 더이상 내려갈 수 없으면 거기에 저장
        while(tempNode != null){

            //입력노드키 보다 현재 임시노드키가 더 크면 왼쪽으로 노드이동.
            if(tempNode.getKey().hashCode() > inputNode.getKey().hashCode()){
                parentNode = tempNode;
                tempNode = tempNode.getLeft();
                if(tempNode == null){
                    inputNode.setParent(parentNode);
                    parentNode.setLeft(inputNode);
                    this.size++;
                } else {
                    tempNode.setParent(parentNode);
                    parentNode.setLeft(tempNode);
                }

            //입력노드키 보다 현재 임시노드키가 더 작으면 오른쪽으로 노드이동.
            } else if(tempNode.getKey().hashCode() < inputNode.getKey().hashCode()){
                parentNode = tempNode;
                tempNode = tempNode.getRight();
                if(tempNode == null){
                    inputNode.setParent(parentNode);
                    parentNode.setRight(inputNode);
                    this.size++;
                } else {
                    tempNode.setParent(parentNode);
                    parentNode.setRight(tempNode);
                }

            //키가 같다면 값을 엎어씌움.
            } else if(tempNode.getKey().hashCode() == inputNode.getKey().hashCode()){
                tempNode.setValue(inputNode.value);
                break;
            }
        }
    }

    public void remove(K removingKey){

        //root가 삭제할 키라면, 바로 앞값이나 뒤값을 찾아서 root로 바꿔줌
        Entry<K, V> tempNode = root;

        //키가 같다면 삭제(while문이 너무 길다 함수로 중간 내용 빼야 함.)
        while(tempNode!= null){

            if(tempNode.getKey().hashCode() == removingKey.hashCode()){
                //키가 갇다면 해당 노드 삭제 후 트리의 구조 조정
                Entry.removeNodeAndFixTree(tempNode);
                return; //여기로 왔다면 삭제처리 완료

                //현재 노드키가 더 크면 왼쪽 노드를 비교
            } else if(tempNode.getKey().hashCode() > removingKey.hashCode()){
                //System.out.println(tempNode.getKey() + "보다 작습니다.");
                tempNode = tempNode.getLeft();
                //현재 노드키가 더 작다면 오른쪽 노드를 비교
            } else if(tempNode.getKey().hashCode() < removingKey.hashCode()){
                //System.out.println(tempNode.getKey() + "보다 큽니다.");
                tempNode = tempNode.getRight();
            }
        }
        //노드 삭제, 트리 조정을 하지 않았다면 삭제 노드 없음.
        System.out.println("삭제할 노드가 없습니다.");
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
            //재귀 순서에 따라 노드 출력 순서 다름
            //Left, print, Right 순서면 키가 작은 거 부터 출력됨
            if(node.getLeft() != null){
                print(node.getLeft());
            }
            System.out.println("(키) " + node.getKey() + "(값) " + node.getValue());
            if(node.getRight() != null){
                print(node.getRight());
            }
        }
        return null;
    }


    static final class Entry <K, V>{

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

        private static <K, V> Entry<K, V> lefOf(Entry<K, V> e) {
            return (e == null) ? null : e.left;
        }

        void setLeft(Entry<K, V> node){
            this.left = node;
        }

        Entry<K, V> getRight(){
            return this.right;
        }

        private static <K, V> Entry<K, V> rightOf(Entry<K, V> e){
            return (e == null) ? null : e.right;
        }

        void setRight(Entry<K, V> node){
            this.right = node;
        }

        Entry<K, V> getParent(){
            return this.parent;
        }

        private static <K, V> Entry<K, V> parentOf(Entry<K, V> e){
            return (e == null) ? null : e.parent;
        }

        void setParent(Entry<K, V> node){
            this.parent = node;
        }

        private static <K, V> void  removeNodeAndFixTree(Entry<K, V> tempNode) {
            System.out.println("같은 키값이 있습니다.");

            Entry<K, V> deletingNode = tempNode;    //삭제할 노드
            Entry<K, V> priorNode = null;           //삭제노드의 부모
            Entry<K, V> alterNode = null;           //대체할 노드
            Entry<K, V> parentOfDeletingNode = deletingNode.getParent();//삭제노드의 부모

            //현재 노드를 왼쪽 자식 노드의 가장 오른쪽 노드 또는 오른쪽 자식 노드의 가장 왼쪽 노드로 갈아끼움
            if(lefOf(tempNode) != null){
                //삭제노드의 왼쪽 노드에서 가장 오른쪽 노드 찾기(대체할 노드)
                alterNode = findAlterNodeToLeft(tempNode);

                //자식들의 부모도 대체할 노드로 바꿔줘야 됨.


                if(lefOf(deletingNode) == alterNode){    //삭제노드와 대체노드가 연결되어 있다면?
                    if(parentOfDeletingNode != null){   //삭제노드의 부모가 있다면,
                        if(lefOf(parentOfDeletingNode) == deletingNode){
                            parentOfDeletingNode.setLeft(alterNode);    //부모의 자식으로 대체노드 지정
                        } else {
                            parentOfDeletingNode.setRight(alterNode);    //부모의 자식으로 대체노드 지정
                        }
                    }
                    alterNode.setRight(rightOf(deletingNode));    //삭제노드의 자식을 연결
                } else {
                    Entry<K, V> parentOfAlterNode = parentOf(alterNode);  //
                    parentOfAlterNode.setRight(Entry.lefOf(alterNode));    //대체노드가 사라지는 자리에 대체노드 자식을 대체노드의 부모랑 연결
                    parentOfDeletingNode.setLeft(alterNode);        //삭제노드의 부모의 자식으로 대체노드 지정
                    alterNode.setParent(parentOf(deletingNode));  //삭제노드의 부모를 대체노드의 부모로 지정
                    alterNode.setLeft(lefOf(deletingNode));      //삭제노드의 자식을 대체노드의 자식으로 지정
                    alterNode.setRight(Entry.rightOf(deletingNode));
                    if(lefOf(deletingNode) != null) lefOf(deletingNode).setParent(alterNode);
                    if(rightOf(deletingNode) != null) rightOf(deletingNode).setParent(alterNode);
                }
                System.out.println(deletingNode.getKey() + "키 를 삭제했습니다.");
                deletingNode = null;   // 삭제노드 삭제
            } else if(rightOf(tempNode) != null){
                //삭제노드의 오른쪽 가지에서 가장 왼쪽 노드 찾기(대체할 노드)
                alterNode = findAlterNodeToRight(tempNode);
                if(rightOf(deletingNode) == alterNode){    //삭제노드와 대체노드가 연결되어 있다면?
                    if(parentOfDeletingNode != null){   //삭제노드의 부모가 있다면,
                        if(lefOf(parentOfDeletingNode) == deletingNode){
                            parentOfDeletingNode.setLeft(alterNode);    //부모의 자식으로 대체노드 지정
                        } else {
                            parentOfDeletingNode.setRight(alterNode);    //부모의 자식으로 대체노드 지정
                        }
                    }
                    alterNode.setLeft(lefOf(deletingNode));    //삭제노드의 자식을 연결
                } else {
                    Entry<K, V> parentOfAlterNode = parentOf(alterNode);
                    parentOfAlterNode.setLeft(rightOf(alterNode));    //대체노드가 사라지는 자리에 대체노드 자식을 대체노드의 부모랑 연결
                    parentOfDeletingNode.setRight(alterNode);        //삭제노드의 부모의 자식으로 대체노드 지정
                    alterNode.setParent(parentOf(deletingNode));  //삭제노드의 부모를 대체노드의 부모로 지정
                    alterNode.setLeft(lefOf(deletingNode));      //삭제노드의 자식을 대체노드의 자식으로 지정
                    alterNode.setRight(rightOf(deletingNode));
                    if(lefOf(deletingNode) != null) lefOf(deletingNode).setParent(alterNode);
                    if(rightOf(deletingNode) != null) rightOf(deletingNode).setParent(alterNode);
                }
                System.out.println(deletingNode.getKey()+"키 를 삭제했습니다.");
                deletingNode = null; // / 삭제노드 삭제
            } else {
                //현재 노드에 왼쪽 오른쪽도 없다면 그냥 null로 지워줌
                //연결 끊어야 함.
                if(parentOf(tempNode).getLeft() == tempNode){
                    parentOf(tempNode).setLeft(null);
                } else if(parentOf(tempNode).getRight() == tempNode){
                    parentOf(tempNode).setRight(null);
                }
                System.out.println(tempNode.getKey() + " 키를 삭제했습니다.");
                tempNode = null;
            }
        }

        private static <K, V> Entry<K, V> findAlterNodeToLeft(Entry<K, V> tempNode){

            Entry<K, V> priorNode = null;
            tempNode = tempNode.getLeft();  //왼쪽으로 한 번 이동 -> 오른쪽 노드 확인
            while(tempNode!= null) {
                priorNode = tempNode;
                if (tempNode.getRight() != null) {
                    tempNode = tempNode.getRight(); //이후 오른쪽 노드가 있다면 오른쪽 노드로 이동 -> 없을 때까지 이동
                } else {
                    tempNode = null;
                }
            }

            //priorNode는 널일 수 가 없음. tempNode.getLeft가 널이 아닌 걸 확인하기 때문에
            if(priorNode == null){
                return null;
            } else {
                return priorNode;
            }
        }

        private static <K, V> Entry<K, V> findAlterNodeToRight(Entry<K, V> tempNode){

            Entry<K, V> priorNode = null;
            tempNode = tempNode.getRight();  //오른쪽으로 한 번 이동 -> 왼쪽 노드 확인
            while(tempNode!= null){
                priorNode = tempNode;
                if(tempNode.getLeft() != null){
                    tempNode = tempNode.getLeft(); //이후 왼쪽 노드가 있다면 왼쪽 노드로 이동 -> 없을 때까지 이동
                } else {

                    tempNode = null;
                }
            }
            //priorNode는 널일 수 가 없음. tempNode.getLeft가 널이 아닌 걸 확인하기 때문에
            if(priorNode == null){
                return null;
            } else {
                return priorNode;
            }
        }
    }
}

