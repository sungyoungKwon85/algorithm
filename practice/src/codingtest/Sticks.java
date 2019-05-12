package codingtest;

import java.io.BufferedReader;
import java.io.InputStreamReader;


/**
 * Description :
 */
public class Sticks {

    private int target;
    private int[] results;

    public int[] func(int[] array, int target) {
        this.target = target;
        this.results = new int[]{-1, -1};
        int[] combArray = new int[array.length];
        combination(combArray, array.length, 2, 0, 0, array);

        return results;
    }

    private void combination(int[] combArray, int n, int r, int index, int dest, int[] arr) {
        if (r == 0) {
            int a = arr[combArray[0]];
            int b = arr[combArray[1]];
            int sum = a + b;
            if (sum == this.target) {
                if (a > b) {
                    if (results[0] == -1 || (results[0] != -1 && results[0] > b)) {
                        results[0] = b;
                        results[1] = a;
                    }
                } else {
                    if (results[0] == -1 || (results[0] != -1 && results[0] > a)) {
                        results[0] = a;
                        results[1] = b;
                    }
                }
            }
        } else if (dest == n) {
            return;
        } else {
            combArray[index] = dest;
            combination(combArray, n, r - 1, index + 1, dest + 1, arr); // (i)
            combination(combArray, n, r, index, dest + 1, arr); //(ii)
        }
    }


    public static void main(String[] args) throws java.lang.Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        String[] firstLines = input.split(" ");
        if (firstLines == null || firstLines.length == 0) {
            return;
        }
        int[] array = new int[firstLines.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(firstLines[i]);
        }

        String target = br.readLine();

        Sticks sticks = new Sticks();
        int[] result = sticks.func(array, Integer.parseInt(target));
        if (result == null || result.length == 0 || result[0] == -1) {
            System.out.println(-1);
        } else {
            for (int num : result) {
                System.out.print(num + " ");
            }
        }
        System.out.println();

    }
}
