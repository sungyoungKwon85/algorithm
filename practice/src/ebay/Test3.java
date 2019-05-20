package ebay;

import java.util.Arrays;
import java.util.Comparator;

/**
 * User: kkwonsy
 * Date: 2019-05-18 11:13
 */
public class Test3 {

    public String solution(int []num) {

        String[] strArray = new String[num.length];
        for (int i = 0; i < num.length; i++) {
            strArray[i] = String.valueOf(num[i]);
        }

        Arrays.sort(strArray, (o1, o2) -> (o2+o1).compareTo(o1+o2));

        String result = "";
        for (String each : strArray) {
            result += each;
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(new Test3().solution(new int[]{2, 123,43,125}));
        System.out.println(new Test3().solution(new int[]{2, 123,43,125, 123, 1234}));
    }

}
/*
N개의 숫자가 주어질 때 이 숫자들을 이어 붙여서 만들 수 있는 수 중에서 가장 큰 수를 만들려고 합니다. 예를 들어 주어진 수가 [2, 123, 43, 125]일 때 이 숫자들을 이어붙여 만들 수 있는 수 중에서 가장 큰 수는 432125123입니다. 수들이 들어있는 배열 nums가 매개변수로 주어질 때 nums의 수들을 이어 붙여 만들 수 있는 수 중에서 가장 큰 수를 문자열 형태로 return 하도록 solution 함수를 완성해 주세요.

제한사항
nums에는 1개 이상 15개 이하의 숫자가 들어있습니다.
nums의 각 원소는 1 이상 9999 이하의 자연수입니다.
숫자를 모두 이어 붙일 경우 32bit int 범위를 넘을 수 있으므로 반드시 문자열 형태로 return 해주세요.
입출력 예
nums	result
[2, 123, 43, 125]	432125123
[987, 654, 3210]	9876543210
[123, 456, 123]	456123123
입출력 예 설명
입출력 예 #1
만들 수 있는 수중 가장 큰 수는 432125123입니다.

입출력 예 #2
만들 수 있는 수중 가장 큰 수는 9876543210입니다.

입출력 예 #3
만들 수 있는 수중 가장 큰 수는 456123123입니다.
 */