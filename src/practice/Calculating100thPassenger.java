public static void main(String[] args) {

        long beforeTime = System.currentTimeMillis();

        final int N = 100;
        final int TIMES = 1000;
        int[] seats;
        int[] numArrOf100th = new int[TIMES];

        for (int i = 0; i < TIMES; i++) {
            seats = Main.assignSeats(N);
            numArrOf100th[i] = seats[N - 1];
        }

        System.out.println("100번째 자리에 앉은 승객 번호 : " + Arrays.toString(numArrOf100th));

        int cnt100thPassenger = (int) Arrays.stream(numArrOf100th)
                                                                .filter(x -> x == N)
                                                                .count();

        System.out.println((double) cnt100thPassenger/TIMES);

        long afterTime = System.currentTimeMillis();
        System.out.println("소요 시간 : " + ((afterTime - beforeTime)) + "ms");
    }

    public static int[] assignSeats(int totalSeatCnt) {
        int[] seatArr = new int[totalSeatCnt];

        //첫 좌석 승객(음주) 랜덤 착석
        int firstSeatNum = (int)(Math.random() * totalSeatCnt);
        seatArr[firstSeatNum] = 1;

        //2번째 부터 마지막 좌석까지 착석
        for (int i = 1; i < totalSeatCnt; i++) {
            int numOfPassenger = i + 1;
            if(seatArr[i] == 0) {
                seatArr[i] = numOfPassenger;
            } else {
                int num;
                while(seatArr[num = (int)(Math.random() * totalSeatCnt)] != 0) {}  //0이 아닐 때까지 반복
                seatArr[num] = numOfPassenger;
            }
        }
        return seatArr;
    }

    public static int[] assignSeatsWithList(int totalSeatCnt) {
        int[] seatArr = new int[totalSeatCnt];
        //빈자리 인덱스 리스트
        List<Integer> emptyIndexList = new LinkedList<>();
        for (int i = 0; i < totalSeatCnt; i++) {
            emptyIndexList.add(i);
        }

        //첫 좌석 승객(음주) 랜덤 착석
        int firstSeatNum = (int)(Math.random() * totalSeatCnt);
        seatArr[firstSeatNum] = 1;
        emptyIndexList.remove(firstSeatNum);
        //2번째 부터 마지막 좌석까지 착석
        for (int i = 1; i < totalSeatCnt; i++) {
            int numOfPassenger = i + 1;
            if(seatArr[i] == 0) {
                seatArr[i] = numOfPassenger;
                emptyIndexList.removeIf(Predicate.isEqual(i));
            } else {
                int num;
                int randomNum = (int)(Math.random() * emptyIndexList.size());
                num = emptyIndexList.get(randomNum);
                seatArr[num] = numOfPassenger;
                emptyIndexList.remove(randomNum);

            }
        }
        return seatArr;
    }
