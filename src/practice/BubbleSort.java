package practice;

public class BubbleSort {

    //버블정렬
    //배열의 앞부분 부터 차례로 앞 뒤 크기를 비교한 후 위치를 바꿔주는 정렬
    //모든 위치가 바뀌면 종료
    //시간복잡도 = O(n^2) 공간복잡도 = N
    //
    //1. 배열의 맨 앞과 뒤를 비교 그다음 비교... 만약 앞이 뒤보다 크면 위치교체
    // 예를 들어 { 3, 2, 1 }을 오름차순 정렬하면,
    // 3과 2를 비교 -> 2가 작기 때문에 위치교체, { 2, 3, 1 }
    // 3과 1을 비교 -> 1이 작기 때문에 위치교체, { 2, 1, 3 }
    // 2와 1을 비교 -> 1이 작기 때문에 위치교체, { 1, 2, 3 }
    // 2와 3을 비교 -> 3이 크기 때문에 교체안함.

    public void sort(int[] array){
        //횟수
        for(int i = 0; i < array.length - 1 ; i ++){
            //배열 인덱스
            for(int j = 0; j < array.length - 1 ; j++){
                if(array[j] > array[j + 1]){
                    swap(array, j);
                }
            }
        }
    }


    private void swap(int[] array, int x){
        int temp = array[x];
        array[x] = array[x+1];
        array[x+1] = temp;
    }
}
