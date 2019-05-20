package ebay;

/**
 * User: kkwonsy
 * Date: 2019-05-18 11:06
 */
public class Test2 {
    public int solution(int n) {

        int result = 0;


        String a = "";
        while (n != 0) {
            int start = 1;
            n -= start;
            a += start;
        }

        return result;
    }


    public static void main(String[] args) {
        int b = 3;

        System.out.println(new Test2().solution(b));
    }

}
/*
2 이상의 자연수 n을 두 개 이상의 자연수의 합으로 나타내려고 합니다. n을 만들 방법 중 각 항의 곱이 가장 큰 방법을 가장 좋은 합이라고 하겠습니다.

예를 들면 n = 8 일 때

1+1+1+1+1+1+1+1
1+2+2+3
2+2+2+2
3+3+2
4+4
등 여러 가지 방법이 있지만, 이 중 3 + 3 + 2인 경우 3 x 3 x 2 = 18 로 가장 좋은 합이 됩니다.

자연수 n이 매개변수로 주어질 때, 가장 좋은 합을 이루는 수들을 곱한 값을 return 하도록 solution 함수를 완성해 주세요.

제한사항
n은 2 이상 100 이하의 자연수 입니다.
입력 n에 대해서 가장 좋은 합을 이루는 수들을 곱한 값은 263 - 1 이하의 자연수 입니다.

 */