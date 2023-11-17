package practice;

import java.util.Arrays;

public class Que<E> {

    //요구사항(배열이기 때문에 크기 초기값 고정)
    //1. 선입선출
    //2. 데이터추가(push)
    //3. 데이터제거(pop)
    //4. 데이터유무확인(isEmpty)
    //5. 데이터포화상태확인(isFull)
    //6. 큐 내의 모든 데이터 출력(printAll)

    private int size;
    private int firstPointer;
    private int lastPointer;

    private Object[] elementData;
    public Que(int size){
        elementData = new Object[size];
        this.size = size;
        this.firstPointer = 0;
        this.lastPointer = 0;
    }

    public void push(E element){
        if(elementData[firstPointer] != null && firstPointer == lastPointer){
            fullQueError();
            return;
        }
        elementData[lastPointer] = element;
        System.out.println(element + "을(를) 큐에 추가했습니다.");
        if(lastPointer + 1 >= size){
            lastPointer = 0;
        } else {
            lastPointer++;
        }
    }

    public void pop(){
        if(elementData[firstPointer] == null){
            emptyQueError();
            return;
        }
        System.out.println(elementData[firstPointer] + "을(를) 큐에서 추출했습니다.");
        elementData[firstPointer] = null;
        if(firstPointer + 1 >= size){
            firstPointer = 0;
        } else {
            firstPointer++;
        }
    }

    public boolean isEmpty(){
        if(elementData[firstPointer] == null){
            System.out.println("큐가 비었습니다.");
            return true;
        } else {
            System.out.println("큐가 비어있지 않습니다.");
            return false;
        }
    }

    public boolean isFull(){
        if(firstPointer == lastPointer && elementData[lastPointer-1] != null){
            System.out.println("큐가 다 차있습니다.");
            return true;
        } else {
            System.out.println("큐가 다 차지 않았습니다.");
            return false;
        }
    }

    public void printAllArray(){
        System.out.println(Arrays.toString(elementData));
    }

    public void printQueData(){
        if(firstPointer == lastPointer && elementData[firstPointer] == null){
            System.out.println("큐가 비어있습니다.");
        } else if (firstPointer == lastPointer && elementData[firstPointer] != null) {
                System.out.print(elementData[firstPointer]);
            System.out.println();
        } else {
            for (int i = firstPointer; i != lastPointer; i++){
                if(i == size){
                    i = 0;
                }
                System.out.print(elementData[i] + " ");
            }
            System.out.println("");
        }
    }
    
    private void fullQueError(){
        System.out.println("큐가 다 찼습니다.");
    }

    private void emptyQueError(){
        System.out.println("큐가 비었습니다.");
    }
}
