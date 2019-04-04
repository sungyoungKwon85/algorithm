package sort;

import java.util.ArrayList;
import java.util.List;

public class Biggest {
/*
0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.

예를 들어, 주어진 정수가 [6, 10, 2]라면 [6102, 6210, 1062, 1026, 2610, 2106]를 만들 수 있고, 이중 가장 큰 수는 6210입니다.

0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때,
순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어 return 하도록 solution 함수를 작성해주세요.

제한 사항
numbers의 길이는 1 이상 100,000 이하입니다.
numbers의 원소는 0 이상 1,000 이하입니다.
정답이 너무 클 수 있으니 문자열로 바꾸어 return 합니다.
입출력 예
numbers	return
[6, 10, 2]	6210
[3, 30, 34, 5, 9]	9534330
 */



    public String solution(int[] numbers) {
        boolean isAllZero = true;
        for (int i : numbers) {
            if (i != 0) {
                isAllZero = false;
            }
        }
        if (isAllZero) return "0";

        List<String> list = new ArrayList<>();
        for (int number : numbers) {
            list.add(String.valueOf(number));
        }

        list.sort((o1, o2) -> {
            // !!! 이렇게나 간단한 걸 -_-;;;
            return (o1+o2).compareTo(o2+o1);
//            char c1 = o1.charAt(0);
//            char c2 = o2.charAt(0);
//
//            if (c1 > c2) return 1;
//            else if (c1 < c2) return -1;
//            else {
//                if (o1.length() == 1 && o2.length() >= 2) {
//                    c2 = o2.charAt(1);
//                } else if (o1.length() >= 2 && o2.length() == 1) {
//                    c1 = o1.charAt(1);
//                } else if (o1.length() == 1 && o2.length() == 1) {
//                    return 1;
//                } else {
//                    c1 = o1.charAt(1);
//                    c2 = o1.charAt(1);
//                }
//                if (c1 > c2) return 1;
//                else if (c1 < c2) return -1;
//                else {
//                    if (o1.length() == 2 && o2.length() >= 3) {
//                        c2 = o2.charAt(0);
//                    } else if (o1.length() >= 3 && o2.length() == 2) {
//                        c1 = o1.charAt(0);
//                    } else if (o1.length() == 2 && o2.length() == 2) {
//                        return 1;
//                    } else {
//                        c1 = o1.charAt(0);
//                        c2 = o1.charAt(0);
//                    }
//                    if (c1 > c2) return 1;
//                    else if (c1 < c2) return -1;
//                    else {
//                        return 1;
//                    }
//                }
//            }
        });

        String answer = "";
        for (int i=list.size()-1; i>=0; i--) {
            answer += list.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {



        if (new Biggest().solution(new int[]{2,22,223}).equals("223222")) {
            System.out.println("Biggest result8 is correct.");
        } else {
            System.out.println("Biggest result8 is not correct.");
        }

        if (new Biggest().solution(new int[]{0,0,0,0}).equals("0")) {
            System.out.println("Biggest result8 is correct.");
        } else {
            System.out.println("Biggest result8 is not correct.");
        }

        if (new Biggest().solution(new int[]{0,0,70}).equals("7000")) {
            System.out.println("Biggest result8 is correct.");
        } else {
            System.out.println("Biggest result8 is not correct.");
        }


        if (new Biggest().solution(new int[]{12, 121}).equals("12121")) {
            System.out.println("Biggest result8 is correct.");
        } else {
            System.out.println("Biggest result8 is not correct.");
        }

        if (new Biggest().solution(new int[]{5, 546}).equals("5546")) {
            System.out.println("Biggest result9 is correct.");
        } else {
            System.out.println("Biggest result9 is not correct.");
        }

        if (new Biggest().solution(new int[]{6, 6, 2}).equals("662")) {
            System.out.println("Biggest result1 is correct.");
        } else {
            System.out.println("Biggest result1 is not correct.");
        }

        if (new Biggest().solution(new int[]{6, 10, 2}).equals("6210")) {
            System.out.println("Biggest result2 is correct.");
        } else {
            System.out.println("Biggest result2 is not correct.");
        }

        if (new Biggest().solution(new int[]{3, 30, 34, 5, 9}).equals("9534330")) {
            System.out.println("Biggest result3 is correct.");
        } else {
            System.out.println("Biggest result3 is not correct.");
        }

        if (new Biggest().solution(new int[]{3, 30, 34, 5, 9, 2}).equals("95343302")) {
            System.out.println("Biggest result4 is correct.");
        } else {
            System.out.println("Biggest result4 is not correct.");
        }

        if (new Biggest().solution(new int[]{9, 93, 97, 5, 8, 2, 30, 34}).equals("997938534302")) {
            System.out.println("Biggest result5 is correct.");
        } else {
            System.out.println("Biggest result5 is not correct.");
        }

        if (new Biggest().solution(new int[]{9, 97, 4, 30, 39}).equals("99743930")) {
            System.out.println("Biggest result6 is correct.");
        } else {
            System.out.println("Biggest result6 is not correct.");
        }

        if (new Biggest().solution(new int[]{1,2,3,4,5,6,1000}).equals("6543211000")) {
            System.out.println("Biggest result7 is correct.");
        } else {
            System.out.println("Biggest result7 is not correct.");
        }

    }
}
