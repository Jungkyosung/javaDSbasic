package practice;

public class StackList<E> {

    //요구사항(연결 리스트, 스택에 값을 계속 추가할 수 있음.)
    //1. 후입 선출
    //2. push() 입력
    //3. pop() 출력
    //4. peek() 조회
    //5. clear() 비우기
    //6. size() 현재까지의 데이터 수
    //7. isEmpty() 스택이 비었는지 확인
    //8. dump() 스택 데이터 전체 확인하기

    private Node<E> nodePointer = null;

    private int numberPointer = 0;

    public void push(E element){
        //첫 등록이면 beforeNode, afterNode 없음.
        if(numberPointer == 0) {
            Node<E> node = new Node<>(element, nodePointer);
            System.out.println(node.getValue() + "을(를) 추가했습니다.");
            nodePointer = node;
            numberPointer++;
        } else {
            //첫 등록이 아니라면 원래 노느가 추가 노드의 beforeNode가 되고 추가 노드가 원래 노드의 afterNode가 됨.
            Node<E> node = new Node<>(element, nodePointer);
            nodePointer.setAfterNode(node); //기존 노드에 추가 노드 연결저장
            System.out.println(node.getValue() + "을(를) 추가했습니다.");
            nodePointer = node;
            numberPointer++;
        }
    }

    public void pop(){
        //만약 비었다면
        if(numberPointer == 0){
            emptyStackError();
            return;
        }
        E value = nodePointer.getValue();
        nodePointer = nodePointer.getBeforeNode();
        System.out.println(value + "을(를) 꺼냈습니다.");
        numberPointer--;
    }

    public E peek(){
        if(numberPointer == 0) {
            emptyStackError();
            return null;
        }
        System.out.println(nodePointer.getValue() + "이(가) 가장 최신값입니다.");
        return nodePointer.getValue();
    }

    public void clear(){
        numberPointer = 0;
        nodePointer = null;
        System.out.println("데이터를 전부 삭제했습니다.");
    }

    public void size(){
        System.out.println("현재 사이즈는 " + numberPointer + "입니다.");
    }

    public boolean isEmpty(){
        if(numberPointer == 0 ){
            emptyStackError();
            return true;
        } else {
            System.out.println("not empty");
            return false;
        }
    }

    public void dump(){
        Node<E> tempNode = nodePointer;
        for(int i = numberPointer ; i >= 1; i--){
            System.out.print(tempNode.getValue() + " ");
            tempNode = tempNode.getBeforeNode();
        }
        System.out.println();
    }

//    리스트라 최대치가 없음.
//    private void fullStackError(){
//        System.out.println("스택이 다 찼습니다.");
//    }

    private void emptyStackError(){
        System.out.println("스택이 비었습니다.");
    }

}
