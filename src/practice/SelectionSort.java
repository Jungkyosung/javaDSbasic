package practice;

import java.util.Arrays;

public class SelectionSort {

    //선택정렬(비교정렬, 제자리 정렬, 불안정 정렬)
    //1. 리스트에서 최솟값 확인
    //2. 최솟값을 맨 앞으로 이동
    //3. 맨 앞을 제외한 나머지 중 최솟값을 앞쪽으로 이동
    //O(n^2)

    //https://balmostory.tistory.com/368 (배열 관련 참조) *swap은 어떻게 작동하는지(배열 힙 영역에 선언)
    public int[] selectionSort(int[] intArray){

        int min = intArray[0];
        int index = 0;
        int count = 0;

        while(count < intArray.length - 1) {

            //최솟값 확인
            for (int i = count; i < intArray.length; i++) {
                if (intArray[i] < min) {
                    min = intArray[i];
                    index = i;
                }
            }

            //최솟값과 현재 인덱스 위치를 바꿈.
            swap(intArray, index, count);
            count++;
            min = intArray[count];

        }

        return intArray;
    }

    private void swap(int[] array, int x, int y){
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }
}
