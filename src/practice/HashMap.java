package practice;

import java.util.Objects;

public class HashMap<K, V> {

    /**
    * 해쉬코드를 사용한 해쉬맵 구조는 키와 값을 노드에 저장하는 방식으로 초기에 배열에 크기값을 받음.
    * 해당 배열의 크기를 가지고 입력한 키를 기준으로 해쉬함수를 수행하면 동일한 길이의 특정한 값이 도출되고,
    * 해당 값을 배열의 인덱스로 사용하는 구조다.
    * 만약 해쉬함수의 결과값이 서로 다른 키값을 통해 반환될 경우엔 값들을 연결 리스트로서 연결하여 해당 배열에 저장한다.
    */

    /**
     * 자료 저장 : 해쉬함수(키) -> 인덱스활용 -> 해당 인덱스에 값이 없다면 바로 저장, 값이 있다면 노드 연결하여 저장
     * 자료 조회 : 해쉬함수(키) -> 인덱스조회 -> 조회 노드와 키 비교 -> 일치하면 조회, 불일치하면 일치할 때까지 다음 노드 조회
     * 자료 삭제 : 해쉬함수(키) -> 인덱스조회 -> 조회 노드와 키 비교 -> 일치하면 뒤에 노드가 있는지 확인하고 삭제, 불일치하면 일치할 때까지 확인하고 삭제
     *            (삭제하면서 노드연결 재설정)
     * 자료 출력 : 배열 돌면서 저장값이 있는 인덱스들 출력, 인덱스에 연결된 노드들이 있는 경우 연결 노드까지 출력
     */

    /**
     * 맵을 위한 적당한 크기의 배열은? 모르겠고 난 100으로 하겠음.
     *
     */

    //요구사항
    //1. 자료저장(put(K,V))
    //2. 자료조회(get(K))
    //3. 자료삭제(remove(K))
    //4. 전체출력(printAll())
    //5. 자료크기(size())
    //6. 데이터유무 확인(isEmpty())

    private int size = 0;

    //기본 배열
    private final MapNode<K, V>[] elementArray = new MapNode[100];

    public void put(K key, V value){
        int index = hash(key);

        if(elementArray[index] == null){
            //인덱스에 노드 확인하고 없으면 이전연결노드 null로 반영
            MapNode<K, V> node = new MapNode<>(key, value, null);
            elementArray[index] = node;
            System.out.printf("[첫등록]키=(%s) 값=(%s) 저장, 인덱스[%d]\n", key, value, index);
            this.size++;

        } else {
            //해당 인덱스에 노드가 있다면, afterNode가 없는 노드까지 가서 등록
            MapNode<K, V> tempNode = elementArray[index];
            //첫 노드 비교
            if(tempNode != null && tempNode.getKey().equals(key)) {
                tempNode.setValue(value);
                System.out.printf("[엎어쓰기]키=(%s) 값=(%s) 저장, 인덱스[%d]\n", key, value, index);
                return;
            }
            //이후 노드 비교
            while ( tempNode.getAfterNode() != null) {
                //키값이 같다면, 엎어쓰고, 다르면 이어쓰기
                if(tempNode.getKey().equals(key)){
                    tempNode.setValue(value);
                    System.out.printf("[엎어쓰기]키=(%s) 값=(%s) 저장, 인덱스[%d]\n", key, value, index);
                    return;
                } else {
                    tempNode = tempNode.getAfterNode();
                }
            }
            //tempNode가 마지막 node의 beforeNode가 되고, tempNode의 afterNode가 마지막 node가 됨.
            MapNode<K, V> node = new MapNode<K, V>(key, value, (MapNode<K, V>) tempNode);
            tempNode.setAfterNode(node);
            System.out.printf("[추가]키=(%s) 값=(%s) 저장, 인덱스[%d]\n", key, value, index);
            this.size++;
        }
    }

    public V get(K key){
        int index = hash(key);
        MapNode<K, V> tempNode = elementArray[index];

        //키가 같다면 값을 반환
        if(tempNode == null) {
            System.out.println("node null 해당 키의 값이 없습니다.");
            return null;
        }

        //첫 노드 비교
        if(tempNode.getKey().equals(key)){
            System.out.println("[첫노드]해당 키의 값은 " + tempNode.getValue() + "입니다.");
            return tempNode.getValue();
        }
        //이후 노드 비교
        while (tempNode.getAfterNode() != null) {
            //키값이 같다면 조회
            if(tempNode.getKey().equals(key)){
                System.out.println("[추가노드]해당 키의 값은 " + tempNode.getValue() + "입니다.");
                return tempNode.getValue();
            }
            tempNode = tempNode.getAfterNode();
        }

        //마지막 노드 검토
        if(tempNode.getKey().equals(key)){
            System.out.println("[마지막노드]해당 키의 값은 " + tempNode.getValue() + "입니다.");
            return tempNode.getValue();
        } else {
            System.out.println("[최종]해당 키의 값이 없습니다.");
        }

        return null;
    }

    public void remove(K key){
        //해쉬키 값으로 인덱스에 값이 있는지 확인 없으면 암것도 안함.
        int index = hash(key);
        MapNode<K, V> tempNode = elementArray[index];

        if(tempNode == null) {
            System.out.println("해당 키의 데이터가 없습니다.");
            return;
        }
        //(101, 값), (1, 값)

        //해쉬키 값으로 인덱스를 찾아서 키가 동일하면 해당 노드 삭제
        //인덱스 첫 노드
        if(tempNode.getKey().equals(key)){
            //키가 같다면 노드를 지우고 연결된 노드가 있다면 걔를 index에 입력해 줌.
            System.out.println(key + "키의 데이터 " + tempNode.getValue() + "를 삭제했습니다.[첫노드삭제]");
            elementArray[index] = null;
            this.size--;
            if(tempNode.getAfterNode() != null){
                elementArray[index] = tempNode.getAfterNode();
            }
            return;
        }

        //이후 노드들
        while(tempNode.getAfterNode() != null){
            if(tempNode.getKey().equals(key)){
                //앞, 뒤 노드가 무조건 있음
                System.out.println(key + "키의 데이터 " + tempNode.getValue() + "를 삭제했습니다.[중간노드 삭제]");
                MapNode<K, V> bfNode = tempNode.getBeforeNode();
                MapNode<K, V> aftNode = tempNode.getAfterNode();
                bfNode.setAfterNode(aftNode);
                aftNode.setBeforeNode(bfNode);
                tempNode = null;
                this.size--;
                return;
            }
            tempNode = tempNode.getAfterNode();
        }

        //마지막 노드
        if(tempNode.getAfterNode() == null){
            if(tempNode.getKey().equals(key)){
                System.out.println(key + "키의 데이터 " + tempNode.getValue() + "를 삭제했습니다.[막노드 삭제]");
                MapNode<K, V> bfNode = tempNode.getBeforeNode();
                bfNode.setAfterNode(null);
                tempNode = null;
                this.size--;
            } else {
                System.out.println("해당 키의 데이터가 없습니다.");
            }
        }
    }

    public boolean isEmpty(){
        if (this.size() == 0) {
            System.out.println("현재 값이 없습니다.");
        } else {
            System.out.println("현재 값이 " + this.size + "개 있습니다.");
        }
        return this.size() == 0;
    }

    //인덱스 반환(해쉬)
    private int hash(Object key){
        return Math.abs(Objects.hashCode(key) % 100);
    }

    public int size(){
        System.out.println("총 데이터 개수는 " + this.size + "개 입니다.");
        return this.size;
    }

    public void printAll(){
        for(int i = 0; i < elementArray.length ; i++){
            if(elementArray[i] != null){
                System.out.print("(" + elementArray[i].getKey() + "," +elementArray[i].getValue() + "), ");
                MapNode<K, V> tempNode = elementArray[i];
                tempNode = tempNode.getAfterNode();

                while(tempNode != null && tempNode.getAfterNode() != null){
                    System.out.print("(" + tempNode.getKey() + "," + tempNode.getValue() + "), ");
                    tempNode = tempNode.getAfterNode();
                }
                if(tempNode != null && tempNode.getAfterNode() == null){
                    System.out.print("(" + tempNode.getKey() + "," + tempNode.getValue() + "), ");
                }

            }
        }
        System.out.println();
    }
}
