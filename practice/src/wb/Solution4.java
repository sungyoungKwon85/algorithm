package wb;


public class Solution4 {
    int solution(int[] A, int X) {
        int N = A.length;
        if (N == 0) {
            return -1;
        }
        int l = 0;
        int r = N - 1;
        while (l < r) {
            int m = (l + r) / 2 + 1;
            System.out.println("m: " + m);
            if (A[m] > X) {
                r = m - 1;
                System.out.println("r: " + r);
            } else {
                l = m;
                System.out.println("l: " + l);
            }
        }
        if (A[l] == X) {
            return l;
        }
        return -1;
    }

    public static void main(String[] args) {
        if (2 == new Solution4().solution(
            new int[]{1, 2, 5, 9, 9}, 5)) {
            System.out.println("1 succeeded");
        }

        int result2 = new Solution4().solution(
            new int[]{1, 2, 5, 9, 9}, 9);
        if (3 == result2 || 4 == result2) {
            System.out.println("2 succeeded");
        }
    }

}
/*
non decreasing order? 감소안하는 순서????
정렬안된 Array A 인듯


Array A에서 X를 찾는다
A가 있으면 그 index
없으면 -1

A = 1,2,5,9,9
X = 5
return 2


 */