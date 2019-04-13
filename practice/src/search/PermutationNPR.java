package search;

/**
 * Description :
 */
public class PermutationNPR {

    public static void main(String[] ar) {
        PermutationNPR ex = new PermutationNPR();
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        // nPr 구하기
        int n = arr.length;
        int r = 3;
        int[] combArr = new int[r];
        ex.doCombination(combArr, arr, n, r, 0, 0);
    }

    public void doCombination(int[] combArr, int[] arr, int n, int r, int index, int target) {
        if (r == 0) {
            doPermutation(combArr, 0);
            System.out.println("------------------");
        } else if (target == n) {
            return;
        } else {
            combArr[index] = arr[target];
            doCombination(combArr, arr, n, r - 1, index + 1, target + 1);
            doCombination(combArr, arr, n, r, index, target + 1);
        }
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
