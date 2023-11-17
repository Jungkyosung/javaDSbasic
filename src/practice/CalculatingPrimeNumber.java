package practice;

public class CalculatingPrimeNumber {

	//[[ 1,000 이하의 정수 소수 열거하기 ]]
	public void calculatingPrimeNumber() {
		int counter = 0;	//나눗셈의 횟수
		
		for(int n = 2; n <= 1000 ; n ++) {
			int i;
			
			for(i = 2; i < n; i++ ) {
				counter++;
				if( n % i == 0) break;
			}
			
			if(n == i)
				System.out.println(n);
			
		}
		
		System.out.println("지금까지 나눈 횟수는 : "+ counter);
	}
	
	public static void main(String[] args) {
		CalculatingPrimeNumber cPN = new CalculatingPrimeNumber();
		
		cPN.calculatingPrimeNumber();

	}

}
