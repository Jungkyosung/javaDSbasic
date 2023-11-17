package practice;

public class QueList <E> {

    //요구사항(리스트기 때문에 크기 제한 없음)
    //1. 선입선출
    //2. 데이터추가(push)
    //3. 데이터제거(pop)
    //4. 데이터유무확인(isEmpty)
    //5. 데이터포화상태확인(isFull)
    //6. 큐 내의 모든 데이터 출력(printAll)

    private Node<E> firstPointer;
    private Node<E> lastPointer;

    public QueList(){
        this.firstPointer = null;
        this.lastPointer = null;
    }

    public void push(E element) {
        //첫 데이터 입력시(큐가 비었을 경우)
        if(firstPointer == null){
            Node<E> node = new Node<>(element, null);
            System.out.println(node.getValue() + " 을(를) 추가했습니다.");
            firstPointer = node;
            lastPointer = node;
        } else {
            Node<E> node = new Node<>(element, lastPointer);
            System.out.println(node.getValue() + " 을(를) 추가했습니다.");
            lastPointer.setAfterNode(node);
            lastPointer = node;
        }
    }

    public void pop(){
        //비었다면 에러
        if(firstPointer == null){
            emptyQueError();
        } else{
            Node<E> node = firstPointer.getAfterNode();
            System.out.println(firstPointer.getValue() + " 을(를) 삭제했습니다.");
            firstPointer = null;
            firstPointer = node;
        }

    }

    public void isEmpty(){
        if(firstPointer == null && lastPointer == null){
            emptyQueError();
        }
    }

    public void printAll(){
        Node<E> temp = firstPointer;
        while(temp != null){
            System.out.print(temp.getValue() + " ");
            temp = temp.getAfterNode();
        }
        System.out.println();
    }

//  크기 제한 없음
//  public void isFull() { }

//    private void fullQueError(){
//        System.out.println("큐가 다 찼습니다.");
//    }

    private void emptyQueError(){
        System.out.println("큐가 비었습니다.");
    }
}
