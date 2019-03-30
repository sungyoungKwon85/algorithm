package stackqueue;

/**
 * Description :
 */
public class StackQueueMain {
    public static void main(String[] args) {
        String str1 = "()(((()())(())()))(())";
        int stickResult1 = 17;
        System.out.println("Stick input: " + str1);
        if (new Stick().solution(str1) == stickResult1) {
            System.out.println("Stick result is " + stickResult1);
        } else {
            System.out.println("Stick result is not correct");
        }

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();


        int[] prints1 = {2,1,3,2};
        int location1 = 2;
        int printAnswer1 = 1;
        System.out.println("Printer input: " + prints1);
        int printResult1 = new Printer().solution2(prints1, location1);
        if (printResult1 == printAnswer1) {
            System.out.println("Printer result is " + printResult1);
        } else {
            System.out.println("Printer result is not correct, " + printResult1);
        }
        int[] prints2 = {1,1,9,1,1,1};
        int location2 = 0;
        int printAnswer2 = 5;
        System.out.println("Printer input: " + prints2);
        int printResult2 = new Printer().solution2(prints2, location2);
        if (printResult2 == printAnswer2) {
            System.out.println("Printer result is " + printAnswer2);
        } else {
            System.out.println("Printer result is not correct, " + printResult2);
        }
        int[] prints3 = {8,5,1,8,5,1,3,2};
        int location3 = 5;
        int printAnswer3 = 8;
        System.out.println("Printer input: " + prints3);
        int printResult3 = new Printer().solution2(prints3, location3);
        if (printResult3 == printAnswer3) {
            System.out.println("Printer result is " + printResult3);
        } else {
            System.out.println("Printer result is not correct, " + printResult3);
        }

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();

    }
}
