package practice;

public class SearchOfArray {

	public static int searchOfArray(int[] a, int n, int key) {
		//자 배열이 들어오고 배열이 몇개인지 안다면?
		//정렬이 안된 배열이니까 배열의 0부터 n-1까지 돌면서 확인 필요
		//만약 찾았으면, 찾은 순서의 값을 반환하고 아니면 -1을 반환해서
		//-1이면 실패
		int i = 0;
		int search = -1;
		
		for ( i = 0; i < n-1; i++ ) {
			if( a[i] == key ) {
				//a[i]가 key값과 같다면 반복을 끝냄
				//그 값은 search에 저장
				search = i;
				break;
			}
		}
		
		//만약 search가 -1이 아니면 찾은 거기 때문에 a[찾은 인덱스]를 search로 반환
		if( search != -1 ) {
			search = a[search];
		}
		//그게 아니라면 -1로 반환
		
		return search;
	}
	
	public static void main(String[] arg) {
		
		//int a[] = { 1, 2, 3, 4, 5, 6, 7, 8 }; //순서 있는 배열
		int a[] = { 8, 7, 5, 4, 10, 11, 12, 13 };
		int n = a.length;
		int key = 4; // 배열에 있는 값
		//int key = 9; // 배열에 없는 양수값
		//int key = -1;  // 배열에 없는 음수값
		
		int searchResult = SearchOfArray.searchOfArray(a,n,key);
		
		if( searchResult == -1 ) {
			System.out.println("검색 실패, 찾는 값이 없습니다.");
		} else {
			System.out.println("검색 성공, " + searchResult + "가(이) 있습니다." );
		}	
	}
}
