package codingtest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Description :
 */
public class Window {

    public void func(int[] arr) {
        int windowSize = arr[0];
        int[] stream = new int[arr.length-1];
        for (int i=1; i<arr.length; i++) {
            stream[i-1] = arr[i];
        }

        int max;
        int j;
        for (int i=0; i<=stream.length-windowSize; i++) {
            max = stream[i];

            for (j=1; j<windowSize; j++) {
                if (stream[i+j] > max) {
                    max = stream[i+j];
                }
            }
            System.out.println(max);
        }
    }



    public static void main(String[] args) throws java.lang.Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String input = br.readLine();
//        System.out.println(input);
        String str = "";
        String s;
        while ((s = br.readLine()) != null) {
            str = str + " " + s;
        }
//        System.out.println("str:" + str);
        String[] splited = str.split(" ");
        System.out.println(Arrays.toString(splited));

        int[] arr = new int[splited.length];
        for (int i=0; i<arr.length; i++) {
            arr[i] = Integer.parseInt(splited[i]);
        }

        new Window().func(arr);



//        new Window().func(new int[]{2,2,1,2,-1,3});
//        System.out.println();
//        new Window().func(new int[]{3,1,2,3,4,5,6,7,8,9});
//        System.out.println();
    }
}
