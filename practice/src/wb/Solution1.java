package wb;


public class Solution1 {

    private int count;

    public Solution1() {
        this.count = 0;
    }

    public int solution(String S) {
        Integer decimal = Integer.parseInt(S, 2);

        if (decimal == 0) {
            return count;
        }

        count++;
        if (decimal % 2 == 0) {
            decimal = decimal/2;
        } else {
            decimal -= 1;
        }

        return solution(Integer.toBinaryString(decimal));
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().solution("011100"));
        System.out.println(new Solution1().solution("100100"));
        System.out.println(new Solution1().solution("0"));
        System.out.println(new Solution1().solution("1"));
        System.out.println(new Solution1().solution("10"));
    }

}
/*
음수가 아닌 Integer 변수 V
변수를 수정하는 두가지 액션이 있음

홀수면 1을 뺸다
짝수면 2로 나눈다

0이 될때까지 진행한다.


v가 28이면
28/2 = 14
14/2 = 7
7 - 1 = 6
6/2 = 3
3-1 = 2
2/2 = 1
1-1 = 0

7번 했음

일단 v는 string으로 받을거임
011100 
16+8+4 = 28
*/
