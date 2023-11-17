package practice;

import java.util.Arrays;
import java.util.Scanner;

public class TableOfMultiplication {

	public void multiplication() {
		//1 부터 9까지 구구단 곱셈 출력
		
		for (int i=1;i<10;i++) {
			for (int j=1;j<10;j++) {
				System.out.printf("%2d ",(j * i));
			}
			System.out.println();
		}
	}
	
	public void multiplication2() {
		System.out.println(" |  1  2  3  4  5  6  7  8  9");
		System.out.println("-+---------------------------");
		for (int i=1;i<10;i++) {
			System.out.print(i + "| ");
			for (int j=1;j<10;j++) {
				System.out.printf("%2d ",(j * i));
			}
			System.out.println();
		}	
	}
	//더하기 표
	public void multiplus() {
		System.out.println(" |  1  2  3  4  5  6  7  8  9");
		System.out.println("-+---------------------------");
		for (int i=1;i<10;i++) {
			System.out.print(i + "| ");
			for (int j=1;j<10;j++) {
				System.out.printf("%2d ",(j + i));
			}
			System.out.println();
		}	
	}
	//입력한 수를 한변으로 하는 정사각형을 * 모양으로 출력
	public void squareStar() {
		System.out.println("사각형을 출력합니다.");
		System.out.print("단 수:");
		Scanner scan = new Scanner(System.in);
		int starNumber=0;
		do {
		starNumber = scan.nextInt();
		System.out.println();
		} while (starNumber < 0);
		//만약 5라면 별을 5개 그리고 그걸 5번하면 되는 거 아닌감?
		for (int i=0;i<starNumber;i++) {
			for (int j=0;j<starNumber;j++) {
				System.out.print("*");
			}
			System.out.println();
		}	
	}
	
	//왼쪽아래가 직각인 이등변 삼각형
	public void halfTriangleStar() {
		System.out.println("왼쪽 아래가 직각인 이등변 삼각형을 출력합니다.");
		System.out.print("몇 단 삼각형입니까?");
		Scanner scan = new Scanner(System.in);
		int starNumber=0;
		
		//양수를 받음
		do {
		System.out.println("(양수를 입력해주세요.)");
		starNumber = scan.nextInt();
		System.out.println();
		} while (starNumber < 0);
		//만약 5라면 별을 5개 그리고 그걸 5번하면 되는 거 아닌감?
		for (int i=1;i<starNumber+1;i++) {
			for (int j=0;j<i;j++) {
				System.out.print("*");
			}
			System.out.println();
		}	
	}
	
	//왼쪽아래가 직각인 이등변 삼각형
	public void halfTriangleLB() {
		System.out.println("왼쪽 위가 직각인 이등변 삼각형을 출력합니다.");
		System.out.print("몇 단 삼각형입니까?");
		Scanner scan = new Scanner(System.in);
		int starNumber=0;
		
		//양수를 받음
		do {
		System.out.println("(양수를 입력해주세요.)");
		starNumber = scan.nextInt();
		System.out.println();
		} while (starNumber < 0);
		//만약 5라면 별을 5개 그리고 그걸 5번하면 되는 거 아닌감?
		for (int i=starNumber;i>0;i--) {
			for (int j=0;j<i;j++) {
				System.out.print("*");
			}
			System.out.println();
		}	
	}
	
	//오른쪽 위가 직각인 이등변 삼각형
	public void halfTriangleRU() {
		System.out.println("오른쪽 위가 직각인 이등변 삼각형을 출력합니다.");
		System.out.print("몇 단 삼각형입니까?");
		Scanner scan = new Scanner(System.in);
		int starNumber=0;
		String s = "";
		//양수를 받음
		do {
		System.out.println("(양수를 입력해주세요.)");
		starNumber = scan.nextInt();
		System.out.println();
		} while (starNumber < 0);
		//만약 5라면 별을 5개 그리고 그걸 5번하면 되는 거 아닌감?
		for (int i=starNumber;i>0;i--) {
			for (int j=0;j<i;j++) {
				s = "*" + s;
			}
			System.out.printf("%5s",s);
			s = "";
			System.out.println();
		}	
	}
		
	
//오른쪽 아래가 직각인 이등변 삼각형
	public void halfTriangleRB() {
		System.out.println("오른쪽 아래가 직각인 이등변 삼각형을 출력합니다.");
		System.out.print("몇 단 삼각형입니까?");
		Scanner scan = new Scanner(System.in);
		int starNumber=0;
		String s = "";
		//양수를 받음
		do {
		System.out.println("(양수를 입력해주세요.)");
		starNumber = scan.nextInt();
		System.out.println();
		} while (starNumber < 0);
		//만약 5라면 별을 5개 그리고 그걸 5번하면 되는 거 아닌감?
		for (int i=1;i<=starNumber;i++) {
			for (int j=0;j<i;j++) {
				s = "*" + s;
			}
			System.out.printf("%5s",s);
			s = "";
			System.out.println();
		}	
	}
	
//오른쪽 아래가 직각인 이등변 삼각형
	public void spira() {
		System.out.println("n단의 피라미드를 출력합니다.");
		System.out.print("몇 단입니까?");
		Scanner scan = new Scanner(System.in);
		int starNumber=0;
		String s = "";
		int blank=0;
		//양수를 받음
		do {
		System.out.println("(양수를 입력해주세요.)");
		starNumber = scan.nextInt();
		System.out.println();
		} while (starNumber < 0);
		scan.close();
		//만약 5라면 별을 5개 그리고 그걸 5번하면 되는 거 아닌감?
		for (int i=1;i<=starNumber+1;i++) {
			blank = starNumber-i+1;
			for (int j=0;j<((i-1)*2-1);j++) {
				s = "*" + s;
			}
			String bb = new String(new char[blank]).replace("\0"," ");
			
			System.out.printf("%s%s",bb, s);
			
			s = "";
			System.out.println();
		}	
		
		
	}
	public static void main(String[] args) {
		//곱셈표 출력
		TableOfMultiplication t = new TableOfMultiplication();

//		t.multiplication();
//		t.multiplication2();
//		t.multiplus();
//		t.squareStar();
//		t.halfTriangleStar();
//		t.halfTriangleLB();
//		t.halfTriangleRU();
//		t.halfTriangleRB();
//		t.spira();
		
		char[] n = new char[3];
		String nn = new String(new char[3]);
		System.out.println(Arrays.toString(n));
		System.out.println(nn);
		char[] cc = new char[] {0x41,0xAC00,0x91D1,0};
		String a = new String(cc); 
		System.out.println(a);
		
		
		
	}

}
