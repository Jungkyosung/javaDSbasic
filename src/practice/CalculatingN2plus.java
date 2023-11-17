package practice;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CalculatingN2plus {
	
	static int a = 0;
	static int b = 0;
	static int n2Sum = 0;
	
	public static int N2plus(int a,int b) {
		int A = 0;
		int B = 0;
		int m = 0;
		int count = 0;
		Scanner scan = new Scanner(System.in);
		
		//계산할 범위의 두 정수를 입력 받는다
		System.out.println("두 개의 정수를 입력해주세요");
		try {
		
		a = scan.nextInt();
		b = scan.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("숫자를 제대로 입력해주세요");
			
		}
		//a가 더 크면 시작 수는 A로 끝 수는 B로 정의, 아니면 반대로
		if(a<b) {
			A = a;
			B = b;
		} else if(a>b) {
			A = b;
			B = a;
		} 
		//첫수와 끝수의 합이 짝수라면 가우스식으로 계산시 중간값을 더해줘야 함
		//첫수,끝수 합에서 2를 나눈 수가 중간값임.
		//끝수에서 중간값을 뺀 수 만큼을 첫수, 끝수 합에 곱해줌.
		//합에 곱한 값과 중간값을 더하면 계산 완료
		if ((A+B)%2 == 0) {
			m = (int)(A+B)/2;
			count = B - m;
			n2Sum = (A+B) * count + m;
		} else {
		//첫수와 끝수의 합이 홀수라면 가우스식 계산시 중간값을 더해줄 필요가 없음
		//따라서 몇번을 더해줄것이냐가 핵심임
		//A+B의 합에서 2를 나눈 수(x.5)와 B빼기 그 수에서 나온 절사값이 곱할 횟수임
			m = (A+B)/2;
			count = B - m;
			n2Sum = (A+B) * count;
		}
				
		return n2Sum;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		System.out.println(N2plus(a,b));
		
		
		
		
		
		
	}

}
