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
