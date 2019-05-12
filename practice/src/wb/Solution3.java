package wb;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class Solution3 {

    public int solution(int[] A, int[] B, int M, int X, int Y) {
        int count = 0;
        Deque<Integer> weightQueue = new ArrayDeque();
        Deque<Integer> targetQueue = new ArrayDeque();
        Set<Integer> targetSet = new HashSet<>();

        for (int i = 0; i < A.length; i++) {
            weightQueue.offer(A[i]);
            targetQueue.offer(B[i]);
        }

        int totalPeople = 0;
        int totalWeight = 0;

        while (!weightQueue.isEmpty()) {
            int weight = weightQueue.pollFirst();
            int target = targetQueue.pollFirst();

            totalPeople++;
            totalWeight += weight;

            if (totalPeople > X || totalWeight > Y) {
                weightQueue.offerFirst(weight);
                targetQueue.offerFirst(target);

                count += (targetSet.size() + 1);

                targetSet.clear();
                totalPeople = 0;
                totalWeight = 0;
            } else {
                targetSet.add(target);
            }

            if (weightQueue.isEmpty()) {
                count += (targetSet.size() + 1);
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println("@@@@@@ 5 @@@@@ " + new Solution3().solution(
            new int[]{60,80,40},
            new int[]{2,3,5},
            5,
            2,
            200
        )); // 5
        System.out.println("@@@@@@ 4 @@@@@ " + new Solution3().solution(
            new int[]{60,80,40},
            new int[]{2,3,5},
            5,
            3,
            200
        )); // 4
        System.out.println("@@@@@@ 5 @@@@@ " + new Solution3().solution(
            new int[]{60,80,80},
            new int[]{2,3,5},
            5,
            3,
            200
        )); // 5
        System.out.println("@@@@@@ 2 @@@@@ " + new Solution3().solution(
            new int[]{60,80,40},
            new int[]{2,2,2},
            5,
            3,
            200
        )); // 2
        System.out.println("@@@@@@ 4 @@@@@ " + new Solution3().solution(
            new int[]{60,80,80},
            new int[]{2,2,2},
            5,
            3,
            200
        )); // 4
        System.out.println("@@@@@@ 6 @@@@@ " + new Solution3().solution(
            new int[]{40, 40, 100, 80, 20},
            new int[]{3, 3, 2, 2, 3},
            3,
            5,
            200
        )); // 6
    }

}
/*
호텔에서 엘베를 기다려
수용량이 있고, 나는 그 무브먼트를 분석하려함

호텔은 0층부터 M층까지 있음
weight limit: Y
사람 제한수: X

0층에 N명의 사람이 queue 형태로 모여있음
각 사람의 몸무게는 A[K]
각 사람의 목적층은 B[K]

사람들은 순서대로 들어감
꽉차면 올라감
다 내려주면 내려감
남은 사람들이 마저 탐

총 멈춘 수를 계산하라.


예)
0~5층
사람제한 X: 2
무게제한 Y: 200
A[K] = 60, 80, 40
B[K] = 2, 3, 5

- 두명탐
- 2층 멈춤
- 3층 멈춤
- 0층 감
- 한명 탐
- 5층 멈춤
- 0층 감


예)
M:3
X:5
Y:200
A[] = 40, 40, 100, 80, 20
B[] = 3, 3, 2, 2, 3

- 세명탐
- 2층감
- 3층감
- 0층감
- 두명탐
- 2층감
- 3층감
- 0층감

 */