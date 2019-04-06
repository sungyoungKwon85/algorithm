package sort;

import java.util.Arrays;

/**
 * Description :
 *
 */
public class Hindex {
/*
H-Index는 과학자의 생산성과 영향력을 나타내는 지표입니다.
어느 과학자의 H-Index를 나타내는 값인 h를 구하려고 합니다.
위키백과1에 따르면, H-Index는 다음과 같이 구합니다.

어떤 과학자가 발표한 논문 n편 중,
h번 이상 인용된 논문이 h편 이상이고 나머지 논문이 h번 이하 인용되었다면 h가 이 과학자의 H-Index입니다.

어떤 과학자가 발표한 논문의 인용 횟수를 담은 배열 citations가 매개변수로 주어질 때,
이 과학자의 H-Index를 return 하도록 solution 함수를 작성해주세요.

제한사항
과학자가 발표한 논문의 수는 1편 이상 1,000편 이하입니다.
논문별 인용 횟수는 0회 이상 10,000회 이하입니다.

입출력 예
citations	return
[3, 0, 6, 1, 5]	3

입출력 예 설명
이 과학자가 발표한 논문의 수는 5편이고, 그중 3편의 논문은 3회 이상 인용되었습니다.
그리고 나머지 2편의 논문은 3회 이하 인용되었기 때문에 이 과학자의 H-Index는 3입니다.
 */

    public int solution(int[] citations) {
        Arrays.sort(citations);

        int h = citations.length;
        int count = 0;

        while (h > 0) {
            for (int i = citations.length - 1; i >= 0; i--) {
                int citation = citations[i];
                if (citation >= h) {
                    count++;
                }
            }
            // !! 문제를 잘 이해하자 -_-
            if (h <= count) {
                return h;
            }
            count = 0;
            h--;
        }

        return 0;
    }

    // !! 다른 사람꺼!!!
    public int solution2(int[] citations) {
        Arrays.sort(citations);

        int max = 0;
        for(int i = citations.length-1; i > -1; i--){
            int min = (int)Math.min(citations[i], citations.length - i);
            if(max < min) max = min;
        }

        return max;
    }

    public static void main(String[] args) {

        if (2 == new Hindex().solution(new int[]{2, 2, 2})) {
            System.out.println("test 02 has been succeeded!");
        } else {
            System.out.println("test 02 has been failed!");
        }
//
        if (5 == new Hindex().solution(new int[]{1,2,3,4,5,6,7,8,9})) {
            System.out.println("test 01 has been succeeded!");
        } else {
            System.out.println("test 01 has been failed!");
        }

        if (1 == new Hindex().solution(new int[]{1})) {
            System.out.println("test 0 has been succeeded!");
        } else {
            System.out.println("test 0 has been failed!");
        }

        if (3 == new Hindex().solution(new int[]{3, 0, 6, 1, 5})) {
            System.out.println("test 1 has been succeeded!");
        } else {
            System.out.println("test 1 has been failed!");
        }

        if (2 == new Hindex().solution(new int[]{22, 42})) {
            System.out.println("test 2 has been succeeded!");
        } else {
            System.out.println("test 2 has been failed!");
        }

        if (0 == new Hindex().solution(new int[]{0, 0})) {
            System.out.println("test 3 has been succeeded!");
        } else {
            System.out.println("test 3 has been failed!");
        }

        if (1 == new Hindex().solution(new int[]{0, 1})) {
            System.out.println("test 4 has been succeeded!");
        } else {
            System.out.println("test 4 has been failed!");
        }

        if (2 == new Hindex().solution(new int[]{0, 1, 2, 3})) {
            System.out.println("test 6 has been succeeded!");
        } else {
            System.out.println("test 6 has been failed!");
        }

        if (2 == new Hindex().solution(new int[]{0, 1, 2, 4})) {
            System.out.println("test 7 has been succeeded!");
        } else {
            System.out.println("test 7 has been failed!");
        }

        if (2 == new Hindex().solution(new int[]{0, 1, 3, 4})) {
            System.out.println("test 8 has been succeeded!");
        } else {
            System.out.println("test 8 has been failed!");
        }

        if (3 == new Hindex().solution(new int[]{0, 5, 3, 4})) {
            System.out.println("test 9 has been succeeded!");
        } else {
            System.out.println("test 9 has been failed!");
        }
    }
}
