package practice;

import java.util.Scanner;

public class CalculatingNplus {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int sum = 0;
		String nSum="";
		int n = scan.nextInt();
		
		for (int i=1; i < n+1; i++) {
			
			sum += i;
			if(i == n) {
				nSum = ""+ nSum + "+" + i + "=" + sum;
			} else if(i==1) {
				nSum = i + "";
			} else {
				nSum = nSum + "+" + i;
			}
		}
		
		System.out.println(nSum);
	}

}
