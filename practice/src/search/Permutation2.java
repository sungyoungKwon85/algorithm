package search;

import java.util.HashSet;
import java.util.Set;

/**
 * Description :
 */
public class Permutation2 {
/*
한자리 숫자가 적힌 종이 조각이 흩어져있습니다.
흩어진 종이 조각을 붙여 소수를 몇 개 만들 수 있는지 알아내려 합니다.

각 종이 조각에 적힌 숫자가 적힌 문자열 numbers가 주어졌을 때,
종이 조각으로 만들 수 있는 소수가 몇 개인지 return 하도록 solution 함수를 완성해주세요.

제한사항
numbers는 길이 1 이상 7 이하인 문자열입니다.
numbers는 0~9까지 숫자만으로 이루어져 있습니다.
013은 0, 1, 3 숫자가 적힌 종이 조각이 흩어져있다는 의미입니다.


입출력 예
numbers	return
17	3  // 7, 17
011	2   // 11, 101


입출력 예 설명
예제 #1
[1, 7]으로는 소수 [7, 17, 71]를 만들 수 있습니다.

예제 #2
[0, 1, 1]으로는 소수 [11, 101]를 만들 수 있습니다.

123 // 2, 3, 23, 13, 31, 123, 231, 213

1234 // 2,3,13,31,23,43,123,321,231,421,241,431,341,413,143,4321,2431,4123,2341..

11과 011은 같은 숫자로 취급합니다.
 */



/*
JAVA로 중복이 없는 조합을 구하는 방법


우선 1,2,3 구슬이 있습니다.
3개중에 2개를 뽑는다고 했을때, 모든 경우의 수는 다음과 같습니다.
1,2
1,3
2,1
2,3
3,1
3,2
총 6가지 입니다. 팩토리얼 개념으로 접근하면 3*2 = 6 가지임을 알 수 있습니다.

이제 여기서 중복을 제거한 경우의 수만 따진다면,
1,2
1,3
2,3
총 3가지 입니다. 이를 조합이라고 합니다. 수학적인 기호로 나타내면! nCr 입니다.

중복이 없고, 순서도 없는 경우의 수(조합) = nCr

재귀함수의 특징을 이용하여, 모든 경우의 수를 다 탐색하도록 하겠습니다.(=백트래킹 개념)

1,2,3 이 3개중에 2개를 뽑는 경우는 단계적으로 쪼개보면 다음과 같이 생각할 수 있습니다.
현재 index가 가리키고 있는 녀석을 뽑는경우!!
현재 index가 가리키고 있는 녀석을 뽑지 않는 경우!!


예를 들어 첫번째 구슬인 1을 뽑을 경우와 안뽑는 경우 2가지 경우로 뻗어 나갈 수 있습니다.
그 다음, 1을 뽑았으니 두번째 구슬인 2를 뽑을 경우와 안뽑는 경우로 또 2가지로 경우로 뻗어 나갈 수 있습니다.
또 하나! 1을 안뽑은 경우도 있었죠? 1을 안뽑은 경우 그냥 스킵하고 두번째 구슬인 2를 뽑을 경우와 안뽑는 경우 2가지로 뻗어 나갑니다.


언제 끝나나요...?
처음 우리가 원한 2개의 구슬을 모두 뽑은 경우! 이럴경우 r == 0
모든 구슬을 다 탐색한 경우


출처: https://limkydev.tistory.com/156
 */

    // wow............이런 규칙이!!!!!
    private boolean[] prime() {
        boolean[] primes = new boolean[10000000];
        primes[0] = true;
        primes[1] = true;
        for(int i = 2; i < primes.length; i++) {
            if(!primes[i]) {
                for(int j = 2; j * i < primes.length; j++) {
                    primes[j * i] = true;
                }
            }
        }

        return primes;
    }

    private boolean isPrimeNumber(Integer num) {
        if (num <= 1) return false;
        for (int i=2; i<num; i++) {
            if (num%i == 0) {
                return false;
            }
        }
//        System.out.println("PrimeNumber is " + num);
        return true;
    }

    // r: n개중 r개 뽑기
    private void permutation(Set<Integer> set, int[] arr, int index, int r){
//        System.out.println("permutation, index: " + index + ", r: " + r);
        if(index == r){
            set.add(createInteger(arr, r));
        } else {
            for(int i = 0; i + index < arr.length; i++){
                swap(arr, index, index + i);
                permutation(set, arr, index + 1, r); // 재귀적으로 호출
                swap(arr, index, index + i);
            }
        }
    }

    private void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    private int createInteger(int[] arr, int r) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < r; i++) {
            sb.append(arr[i]);
        }

        return Integer.parseInt(sb.toString());
    }

    public int solution(String numbers) {
        int answer = 0;

        // int array로 바꿈
        int[] arr = new int[numbers.length()];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = numbers.charAt(i) - '0';
        }

        // 중복 허용 안함
        Set<Integer> set = new HashSet<>();
        for(int r = 1; r <= arr.length; r++) {
            permutation(set, arr, 0, r);
        }

        boolean[] primes = prime();
        for(int num : set) {
            answer = primes[num] ? answer : answer + 1;
        }

//        for (Integer num : set) {
//            if (isPrimeNumber(num)) answer++;
//        }

        System.out.println("count: " + answer);
        return answer;
    }

    public static void main(String[] args) {
        new Permutation2().solution("12345");
        new Permutation2().solution("011");
        new Permutation2().solution("17");
        new Permutation2().solution("123");
        new Permutation2().solution("11");
        new Permutation2().solution("33");
    }
}
