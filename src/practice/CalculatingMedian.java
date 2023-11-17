package practice;

import java.util.Arrays;
import java.util.Scanner;

public class CalculatingMedian {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		int n=0;
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		
		
//정렬
//정렬은 하나씩 배열에서 n1 n2비교해서 n1이 더 크면 순서를 바꿈
		int[] a = new int[n];
		
		for (int i=0; i <n;i++) {
			a[i]=(int)(Math.random()*10)+1;
		}
		System.out.println("a="+Arrays.toString(a));
		
		int tempA;
		int tempB;
		boolean check=true;
		
//		while(check) {
			for (int i=0; i < a.length-1;i++) {
				if(a[i] > a[i+1]) {
					tempA = a[i];
					tempB = a[i+1];
					a[i] = tempB;
					a[i+1] = tempA;
					i=-1;
					System.out.println(Arrays.toString(a));
				}	
			}
//		}
		System.out.println(Arrays.toString(a));
		


//길이계산
		int median;
		int even1;
		int even2;
		double evenMedian;
		if(a.length%2 == 1) {
			median = (int)Math.ceil(a.length/2);
			System.out.println(a[median]);
		} else {
			even1 = ((int)a.length/2)-1;
			even2 = even1+1;
			System.out.println(a[even1]);
			System.out.println(a[even2]);
			evenMedian = (double)(a[even1]+a[even2])/2;
			System.out.println(evenMedian);
		}
		
//홀수면 반으로 나누고 올림한 숫자
//짝수면 반으로 나누고 걔 +1인 숫자의 평균



	}

}
