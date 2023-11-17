package practice;

import java.util.Scanner;

public class CalculatingNplusWithGaus {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=0;
		int sum = 0;
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		
		if(n%2 == 1) { 
			sum = (1 + n) * (n/2) + (int)(n/2) + 1;
		
		} else if(n%2 == 0) {
			sum = (1 + n) * (n/2);
		}
		
		System.out.println(sum);
	}

}
