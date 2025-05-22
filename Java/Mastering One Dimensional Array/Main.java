public class Main {
    static int[] arr = { 5, 10, 15, 20, 25 };

    static int sum() {
        int sum = 0;
        int i;

        for (i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        return sum;
    }

    static double average() {
        return sum() / arr.length;
    }

    public static void main(String[] args) {
        System.out.println("Sum of elements: " + sum());
        System.out.println("Average of elements: " + average());
    }
}