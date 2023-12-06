public class Fibonaci{

  public void fibonaciTest(){
    int num = 1000;
    double[] a = new double[num];
    long sTime = System.currentTimeMillis();
    System.out.println(Main.피보나치(num, a));
    long eTime = System.currentTimeMillis();
    System.out.println("피보나치 재귀 소요시간= " + (eTime - sTime));

    sTime = System.currentTimeMillis();
    System.out.println(Main.피보나치반복문(num));
    eTime = System.currentTimeMillis();

    System.out.println("피보나치 반복문 소요시간= " + (eTime - sTime));

    //스트림 활용한 피보나치
    Stream.iterate(new int[]{0,1}, n -> new int[]{n[1], n[0] + n[1]}
    //                        {
    //                            int c = n[0];
    //                            n[0] = n[1];
    //                            n[1] = c + n[1];
    //                            return n;
    //                        }
            )
            .limit(20)
            .forEach(t -> System.out.println("(" + t[0] + "," + t[1] + ")"));

    
  }
  double 피보나치(int num, double[] memo){
        if(num == 1){
            return 1;
        }
        if(num <= 0){
            return 0;
        }
        if(memo[num - 2] == 0) {
            memo[num - 2] = 피보나치(num-2, memo);
        }
        if(memo[num - 1] == 0){
            memo[num - 1] = 피보나치(num - 1, memo);
        }
        return (memo[num - 2] != 0 ? memo[num - 2] : 0) + (memo[num - 1] != 0 ? memo[num - 1] : 0);
    }

    double 피보나치반복문(int num){
        double a = 0;
        double b = 1;
        double c;
        for(int i = 0; i < num; i++){
            c = b;
            b = a + b;
            a = c;
        }
        return a;
    }
}
