package search;

/**
 * Description :
 */
public class PermutationNPN {

    public static void main(String[] ar) {
        int[] arr = {1, 2, 3};
        new PermutationNPN().doPermutation(arr, 0);
    }

    public void doPermutation(int[] arr, int startIdx) {
        int length = arr.length;
        if (startIdx == length - 1) {
            for (int n : arr) {
                System.out.print(n + " ");
            }
            System.out.println();
            return;
        }

        for (int i = startIdx; i < length; i++) {
            swap(arr, startIdx, i);
            doPermutation(arr, startIdx + 1);
            swap(arr, startIdx, i);
        }
    }

    private void swap(int[] arr, int n1, int n2) {
        int temp = arr[n1];
        arr[n1] = arr[n2];
        arr[n2] = temp;
    }
}
