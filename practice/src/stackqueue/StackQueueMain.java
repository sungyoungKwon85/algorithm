package stackqueue;

/**
 * Description :
 */
public class StackQueueMain {
    public static void main(String[] args) {
        String str1 = "()(((()())(())()))(())";
        int result1 = 17;
        System.out.println("Stick input: " + str1);
        if (new Stick().solution(str1) == 17) {
            System.out.println("Stick result is " + result1);
        } else {
            System.out.println("Stick result is not correct");
        }

    }
}
