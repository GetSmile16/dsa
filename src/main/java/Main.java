import java.util.Arrays;

public class Main {
    public static int COUNT = 100;

    public static void main(String[] args) {
        int[] arr = new int[COUNT];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i * 2 + 10;
        }

        System.out.println(Arrays.toString(arr));

        int look = 42;

        System.out.println("Simple");
        System.out.println(binary_search(arr, look));

        System.out.println("Recursive");
        System.out.println(recursive_binary_search(arr, look, 0, arr.length, 0));
    }

    private static int recursive_binary_search(int[] arr, int look, int low, int high, int i) {

        int mid = (low + high) / 2;

        if (high < low) {
            return -1;
        }

        if (look == arr[mid]) {
            System.out.println(i);
            return mid;
        } else if (look > arr[mid]) {
            return recursive_binary_search(arr, look, mid + 1, arr.length, ++i);
        } else {
            return recursive_binary_search(arr, look, low, mid - 1, ++i);
        }
    }

    private static int binary_search(int[] arr, int look) {
        int low = 0;
        int high = arr.length;

        int i = 0;
        while (low <= high) {
            int mid = (low + high) / 2;

            if (look == arr[mid]) {
                System.out.println(i);
                return mid;
            } else if (look > arr[mid]) {
                i++;
                low = mid + 1;
            } else {
                i++;
                high = mid - 1;
            }
        }

        return -1;
    }
}
