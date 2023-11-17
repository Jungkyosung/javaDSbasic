package practice;

import java.util.Scanner;

public class TransferDigits {
	//기수변환 로직
	public int cardConvR(int x, int r, char[] d) {
		int digits = 0;
		String dChar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
		do {
			//정수x를 r진수로 나누고 남은 나머지 수를
			//dChar의 문자열에서 나머지 수의 위치에 있는 문자 하나를 가져온다. 
			d[digits] = dChar.charAt(x%r);//d[0]... (기수변환된) 문자가 입력된다.
			System.out.print(d[digits]);
			digits++;
			x = x/r; //나눈 몫은 x에 다시 저장한다.
		} while(x != 0);//0이 될 때까지 반복한다.
		
		//역순으로 입력된 값을 변환해서 r진수로 기수변환 완료
		System.out.println();
		char[] c = new char[32];
		
		for (int i=0; i <= digits-1; i++) {
			c[i] = (d[digits-i-1]);
			System.out.print(c[i]);
		}

		
		
		return digits;
	}
	
	public void transferDigitsForDetail() {
		Scanner scan = new Scanner(System.in);
		TransferDigits t = new TransferDigits();
		
		int n = 0;   //정수값
		int r = 0;   //진수값
		
		//[[ 기수변환에 사용할 정수값(n)과 진수값(r) 입력받기 ]]
		System.out.println("10진수를 기수 변환합니다.");
		
		do {
			System.out.print("변환하는 음이 아닌 정수:");
			n = scan.nextInt();
		} while(n<=0);   
		
		do {
			System.out.print("어떤 진수로 변환할까요? (2-36) :");
			r = scan.nextInt();
		} while(r < 2 || r > 36);   
		
		//[[ 입력 받은 값을 이용한 기수변환 진행식 표출하기 ]]
		char[] d = new char[32];             //자리수 변환함수에 사용할 빈 char배열 변수
		int digits = t.cardConvR(n, r, d);   //10진수를 진수로 기수변환할 때의 자리수를 구한다.
		int modValue = 0;                    //아래 순환문에서 나머지값 저장해 둘 변수
		
		System.out.println();
		System.out.println();
		
		//자리수는 나눈 횟수랑 마찬가지니까 산출된 자리수만큼 n에서 나눔 반복.
		for (int i=0; i<digits ; i++) {
			
			System.out.printf("%2d | %10d", r, n);         //진수와 정수 표출
			if (i == 0) {							       //첫 i에는 나머지값 표출안함
				System.out.println();						
			} else {
				System.out.println(" ... " + modValue);    //두번째 i부터는 나머지값 표출
			}
			System.out.println("   +-----------");         
			modValue = n % r; 							   //나머지값을 먼저 저장하고 
			n = n / r;									   //정수를 진수로 나눠서 몫을 저장함.
		}
		
		//다 나누고 남은 마지막 나머지 값을 한번 출력해주면 마무리.
		System.out.println("              0" + " ... " + modValue);	
		
	}
	
	
	public static void main(String[] args) {
		TransferDigits t = new TransferDigits();
		char[] d = new char[32];
		int resultR = t.cardConvR(100, 16, d);
		System.out.println();
		System.out.println(resultR);
		t.transferDigitsForDetail();
		
	}

}
