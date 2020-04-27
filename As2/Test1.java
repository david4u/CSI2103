package As2;

/* As21 test 간단하게 메소드들 테스트만 하는거임
오류가 생길 수 있는 모든 상황을 고려한 거 아님
점수는 시간이 얼마나 걸리나에 따라 나뉜다고 했으니 별 큰 의미는없음
잘 되나만 테스트 가능
*/
public class Test1 {
    
    public static void main(String[] args) {
        CList myList = new CList();
        for (int i = 0; i < 10; i++) {
            myList.append(i*i + 1);
        }
        for (int i = 0; i < 20; i++) {
            System.out.println(myList.first.data);
            myList.first = myList.first.next;
        }
        CIter myIter = myList.getIter();
        System.out.println(myIter.cur.data);
        System.out.println(myIter.prev.data);
        myIter.next();
        myIter.next();
        myIter.next();
        System.out.println(myIter.getValue()); // 10이 나와야 함.
        System.out.println(myIter.setValue(-10)); // true가 놔아야 함.
        System.out.println(myIter.getValue()); // -10이 나와야 함.
        myIter.next();
        System.out.println(myIter.delete()); // 17 나와야 함.
        myIter.insertAfter(1000000);
        System.out.println(myIter.getValue());
        myIter.next();
        System.out.println(myIter.getValue()); // 현재 iter는 1000000에 있음
        CIter scIter = myList.getIter();
        for (int i = 0; i < 5 ; i++) {
            scIter.next();
        }
        System.out.println("temp");
        System.out.println(scIter.getValue());
        scIter.insertAfter(20202020);
        myIter.next();
        System.out.println(myIter.getValue());
        CIter alIter = myList.getIter();
        for (int i = 0; i < 11; i++) {
            System.out.println(alIter.getValue());
            alIter.next();
        }
        System.out.println(myList.first.next.next.next.next.next.data);
        CList secondList = new CList();
        secondList.append(3);
        CIter mynewIter = secondList.getIter();
        System.out.println(mynewIter.delete());
        CIter lastcheck = myList.getIter();
        for (int i = 0; i < 10; i++) {
            lastcheck.next();
        }
        System.out.println(lastcheck.getValue());
        lastcheck.insertAfter(777);
        System.out.println(myList.last.data);
        System.out.println(lastcheck.caller.last.data);
        CNode a = new CNode();
        CNode b = new CNode();
        CNode c = new CNode();
        c.data = 4;
        a.data = 3;
        a.next = c;
        b.data = 3;
        b.next = c;
        System.out.println(b == a);
        System.out.println(b.equals(a));
        b = a;
        System.out.println(b == a);
        System.out.println(b.equals(a));

    }
}
/*
    맞는 출력
    1
    2
    5
    10
    17
    26
    37
    50
    65
    82
    1
    2
    5
    10
    17
    26
    37
    50
    65
    82
    1
    82
    10
    true
    -10
    17
    26
    1000000
    temp
    1000000
    20202020
    1
    2
    5
    -10
    26
    1000000
    20202020
    37
    50
    65
    82
*/