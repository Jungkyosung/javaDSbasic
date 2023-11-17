package practice;

public class Stack<E> {

    private int pointer = 0;
    private int maxSize;
    private Object[] elementData;

    public Stack(int capacity){
        this.maxSize = capacity;
        elementData = new Object[maxSize];
    }

    public void push(E element) {
        if(pointer == (maxSize - 1)) {
            fullStackError() ;
            return;
        }
        if (elementData[pointer] == null) {
            elementData[pointer] = element;
            System.out.println(element + "을(를) 추가했습니다.");
        } else {
            pointer++;
            elementData[pointer] = element;
            System.out.println(element + "을(를) 추가했습니다.");
        }
    }

    public void pop(){
        if (pointer <= 0 && elementData[0] == null) {
            emptyStackError();
        } else {
            System.out.println(elementData[pointer] + "을(를) 꺼냈습니다.");
            elementData[pointer] = null;
            if(pointer != 0){
                pointer--;
            }
        }
    }

    public int indexOf(E element){

        for (int i = pointer ; i >= 0; i--){
            if(elementData[i] == element){
                return i;
            }
        }
        return -1;
    }

    public Object[] getList() {
        return this.elementData;
    }
    //리사이즈 하면서 데이터를 옮겨야 하지 않을까?
    public void resize(int capacity) {
        elementData = new Object[capacity];
        this.maxSize = capacity;
        pointer = 0;
    }

    public void clear() {
        pointer = 0;
        elementData = new Object[maxSize];
        System.out.println("스택을 모두 비웠습니다.");
    }

    public int getSize() {
        if(elementData[pointer] == null){
            System.out.printf("현재 사용량 %d / %d \n", 0, this.maxSize);
            return 0;
        } else {
            System.out.printf("현재 사용량 %d / %d \n", this.pointer + 1, this.maxSize);
            return this.pointer;
        }
    }

    public int getCapacity() {
        return this.maxSize;
    }
    private void fullStackError(){
        System.out.println("스택이 다 찼습니다.");
    }

    private void emptyStackError(){
        System.out.println("스택이 비었습니다.");
    }
}
