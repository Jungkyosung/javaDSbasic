package practice;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ArrayUsing {

	//배열 만들기
	public int[] getArray() {
		
		Random r = new Random();
		int number = r.nextInt(10)+1;//1~10 안에서 개수 생성.
		//랜덤 개수대로 배열생성
		int[] a = new int[number];
		//랜덤으로 배열에 값 입력
		for (int i=0;i<a.length; i++) {
			a[i] = r.nextInt(100);
			System.out.printf("height[%d]=%d%n",i ,a[i]);
		}
		
		return a;
	}
	
	//배열 역순으로 정렬하기
	public int[] ArrayReverse(int a[]) {
		int t=0;//임시 저장 변수
		int count= a.length / 2; //배열 크기의 절반 만큼 반복문 수행.
		int n = a.length-1;
		//역순으로 정렬(가운데 값을 기준으로 앞 뒤 값들을 교환)
		for (int i=0;i<count;i++) {
			t= a[i];
			a[i] = a[n-i];
			a[n-i] = t;
		}
		
		return a;
	}
	
	//배열 역순 정렬 순차대로 보여주기
	public void ArrayReverseProcess(int a[]) {
		int t=0;
		int count = a.length / 2 ;
		int n = a.length;
		//바꾸기 전에 출력하기
		for(int i=0; i<n ; i++) {
			System.out.print(a[i] + " ");
			
		}
		System.out.println();
			
		//순서 바꾸기
		for (int i=0; i<count;i++) {
			t=a[i];
			a[i] = a[n-i-1];
			a[n-i-1] = t;
			
			System.out.printf("a[%d]과(와) a[%d]을(를) 교환합니다.\n", i, n-i-1);
			for(int j=0; j<n ; j++) {
				System.out.print(a[j] + " ");
			}
			System.out.println();
		}
		System.out.println("역순 정렬을 마쳤습니다.");
	}
	
	public int sumOf(int a[]) {
		int sum=0;
		for (int i=0; i<a.length;i++) {
			sum += a[i];
		}
		return sum;
	}
	
	public boolean compareWithTwoArrays(int a[], int b[]) {
		
		if (a.length != b.length) return false;
		
		for(int i=0; i < a.length; i++) {
			if(a[i] != b[i]) return false;
		}
		return true;
	}
	
	public int[] makingArrayA() {
		Scanner scan = new Scanner(System.in);
		
		//배열 요솟수 입력
		int na = 0;
		System.out.print("배열의 요솟수:");
		na = scan.nextInt(); //요소 개수 입력받기
		int a[] = new int[na];
		
		//배열의 각 요소 입력하기
		for (int i=0; i < na; i++) {
			System.out.print("a["+i+"]:"); 
			a[i] = scan.nextInt();
		}
		return a;
	}
	
	//배열a를 배열b에 복사하기
	public void copy(int[] a, int[] b) {
		int na = a.length;
		b = new int[na];
		//a의 배열 값들을 b에 복붙하기
		for(int i=0;i<na;i++) {
			b[i] = a[i];
		}
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(b));
	}
	
	//배열a를 배열b에 역순으로 복사하기
	public void rCopy(int[] a, int[] b) {
		int na = a.length;
		b = new int[na];
		for(int i=0; i < na; i++) {
			b[i] = a[na-i-1];
		}
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(b));
	}
	
	
	
	
	public static void main(String[] args) {
		ArrayUsing a = new ArrayUsing();
		int[] array1 = a.getArray();
		System.out.println(Arrays.toString(array1));
		int[] arrayOfReverse1 = a.ArrayReverse(array1);
		System.out.println(Arrays.toString(arrayOfReverse1));
		a.ArrayReverseProcess(array1);
		System.out.println("배열의 총 합: " + a.sumOf(array1));
		int arrayA[] = a.makingArrayA();
		int arrayB[] = a.makingArrayA();
		boolean result= a.compareWithTwoArrays(arrayA, arrayB);
		System.out.println(result ? "배열 a와 b는 같습니다." : "배열 a와 b는 다릅니다.");
				
//		int arrayA[] = { 1, 2, 3, 4 };
//		int arrayB[] = {  };
//		
//		a.copy(arrayA, arrayB);
//		a.rCopy(arrayA, arrayB);
		
	}

}
