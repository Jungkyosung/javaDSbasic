package practice;

public class CountingSort {

    //개수를 통한 정렬
    //{ 2, 1, 4, 4, 4 }
    //{ 0, 1, 1, 0, 3, 0, 0, 0, 0, 0 }
    //{ 0, 1, 2, 2, 5, 5, 5, 5, 5, 5 }
    //{ 1, 2, 4, 4, 4 }
    //{ 1, 2, 4, 4, 4 }

    //수의 범위를 알고 입출력만 한다면,
    //수의 범위

    //수열의 크기 10개
    public int[] sortArray(int[] array, int range) {
        int[] rangeArr = new int[range];
        for(int i = 0; i < array.length ; i ++ ){
            if(array[i] > range - 1){
                System.out.println("숫자 범위를 다시 설정해주세요.");
                return null;
            }
            rangeArr[array[i]]++;
        }

        int[] newArray = new int[array.length];
        int count = 0;
        for(int i = 0; i < rangeArr.length; i++){
            for(int j = 0; j < rangeArr[i] ; j++){
                newArray[count] = i;
                count++;
            }
        }
        return newArray;
    }
}
