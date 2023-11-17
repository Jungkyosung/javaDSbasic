package practice;

import java.util.Arrays;
import java.util.Random;

public class RandomUsing {

	//사람 수 임의로 지정
	public int getPeopleNumber() {
		Random rand = new Random();
		int peopleNumber = rand.nextInt(100);
		return peopleNumber;
	}
	
	//사람 수 대로 배열 생성 및 값 넣기
	public int[] arrayOfPeople(int peopleNumber) {
		peopleNumber = getPeopleNumber();
		Random rand = new Random();
		
		//사람 수 대로 배열 생성
		int[] a = new int[peopleNumber];
				
		//배열에 임의 height 값 넣기
		for (int i=0;i<a.length; i++) {
			a[i] = 100 + rand.nextInt(90);
			System.out.printf("height[%d]=%d%n",i ,a[i]);
		}
		
		return a;
	}
	
	//사람들의 수와 키 배열 값 출력
	public void printArrayPeople(int[] a) {
		System.out.println("people Number = " + a.length);
		System.out.println(Arrays.toString(a));
	}
	
	//사람 배열에서 최대값 찾기
	public int maxOf(int[] a) {
		
		int max = 0;
		max = a[0];
		for (int i = 1; i < a.length;i++) {
			if(max < a[i]) {
				max = a[i];
			}
		}
		
		return max;
	}
	
	
	
	public static void main(String[] args) {
		//랜덤으로 사람 수를 정한다.(사람 수 결정)
		//랜덤으로 정해진 배열을 만든다(배열 생성 및 배열에 값 넣기)
		//배열에 랜덤으로 값을 넣는다(키: 100~190)
		
		
		RandomUsing r = new RandomUsing();
		int peopleNumber = r.getPeopleNumber();
		int[] a = r.arrayOfPeople(peopleNumber);
		r.printArrayPeople(a);
		System.out.println(r.maxOf(a));
		
		
		
	}

}
