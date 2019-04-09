package search;

/**
 * Description :
*/
public class Exhaustive {
/*
수포자는 수학을 포기한 사람의 준말입니다.
수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다.
수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.

1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...

1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때,
가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.

제한 조건
시험은 최대 10,000 문제로 구성되어있습니다.
문제의 정답은 1, 2, 3, 4, 5중 하나입니다.
가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요.


입출력 예
answers	return
[1,2,3,4,5]	[1]
[1,3,2,4,2]	[1,2,3]


입출력 예 설명
입출력 예 #1
수포자 1은 모든 문제를 맞혔습니다.
수포자 2는 모든 문제를 틀렸습니다.
수포자 3은 모든 문제를 틀렸습니다.
따라서 가장 문제를 많이 맞힌 사람은 수포자 1입니다.

입출력 예 #2
모든 사람이 2문제씩을 맞췄습니다.
 */
    public int[] solution(int[] answers) {
        int[] one = {1, 2, 3, 4, 5};
        int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int cnt1 = 0;
        int cnt2 = 0;
        int cnt3 = 0;

        for (int i=0; i<answers.length; i++) {
            int i1 = i;
            int i2 = i;
            int i3 = i;
            if (i1 > one.length-1) i1 = i%one.length;
            if (i2 > two.length-1) i2 = i%two.length;
            if (i3 > three.length-1) i3 = i%three.length;

            if (answers[i] == one[i1]) cnt1++;
            if (answers[i] == two[i2]) cnt2++;
            if (answers[i] == three[i3]) cnt3++;
        }

        if (cnt1 > cnt2 && cnt1 > cnt3) return new int[]{1};
        else if (cnt2 > cnt1 && cnt2 > cnt3) return new int[]{2};
        else if (cnt3 > cnt1 && cnt3 > cnt2) return new int[]{3};

        else if (cnt1 > cnt3 && cnt1 == cnt2) return new int[]{1,2};
        else if (cnt1 > cnt2 && cnt1 == cnt3) return new int[]{1,3};
        else if (cnt2 > cnt1 && cnt2 == cnt3) return new int[]{2,3};

        else return new int[]{1,2,3};
    }

    public static void main(String[] args) {
//        int[] results1 = new Exhaustive().solution(new int[]{1,2,3,4,5});
//        if (results1[0] == 1) {
//            System.out.println("1 succeeded");
//        }
//
//        int[] results2 = new Exhaustive().solution(new int[]{1,3,2,4,2});
//        if (results2[0] == 1 && results2[1] == 2 && results2[2] == 3) {
//            System.out.println("2 succeeded");
//        }
//
//        int[] results3 = new Exhaustive().solution(new int[]{1,1,1});
//        if (results3[0] == 1 && results3[1] == 2 && results3[2] == 3) {
//            System.out.println("3 succeeded");
//        }
//
//        int[] results4 = new Exhaustive().solution(new int[]{5});
//        if (results4[0] == 1 && results4[1] == 2 && results4[2] == 3) {
//            System.out.println("4 succeeded");
//        }

        int[] results5 = new Exhaustive().solution(new int[]{1,1,1,2,2,2,3,3,3,4,4,4});
        if (results5[0] == 1 && results5[1] == 2 && results5[2] == 3) {
            System.out.println("5 succeeded");
        }

    }
}
