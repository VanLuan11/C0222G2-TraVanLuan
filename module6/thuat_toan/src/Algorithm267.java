public class Algorithm267 {
     public static void main(String[] args) {
        int[] arr = {1, 6, 5, 2, 1, 5, 2, 4, 3, 3};
        int sum;
        int n = 455;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                sum = arr[i] + arr[j];
                if (sum == n) {
                    System.out.println("Vị trí i: " + i + " = " + arr[i] + " " + " Vị trí j: " + j + " = " + arr[j]);
                    count++;
                }

            }
        }
        if (count == 0) {
            System.out.println("Không tìm thấy 2 số có tổng bằng " + n);
        }

    }
}
