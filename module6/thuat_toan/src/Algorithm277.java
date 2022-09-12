public class Algorithm277 {
    public static void main(String[] args) {
        int[] arr = {1, 4, 6, 8, 9, 2, 7};
        int a = arr[0];
        int a2 = 0;
        for (int i = 1; i < arr.length; i++) {
            if (a <= arr[i]) {
                a = arr[i];
            }

            if (a2 < arr[i] && arr[i] < a) {
                a2 = arr[i];
            }
        }
        System.out.println(a2);


//        int[] arr = {-9, -1,-8, -4, -8, -6, -9, -2, -7, -9};
//        int max1 = arr[0];
//        int max2 = 0;
//        int max3 = 0;
//
//        for (int i = 1; i < arr.length; i++) {
//            if (max1 < arr[i]) {
//                max3 = max2;
//                max2 = max1;
//                max1 = arr[i];
//
//            }
//            if (max2 < arr[i] && arr[i] < max1) {
//                max2 = arr[i];
//            }
//            if (max3 < arr[i] && arr[i] < max2) {
//                max3 = arr[i];
//            }
//
//        }
//        System.out.println("số lớn thứ 2 trong mảng là: " + max3);


//         int n = 5;
//        int q = 0;
//        while (n > 0) {
//            for (int i = 1; i < n; i++)
//                System.out.printf(" ");
//            for (int j = 0; j <= q; j++)
//                System.out.print("*");
//            n--;
//            q+=2;
//            System.out.println();
//        }


//        int a = 0, b = 0;
//       if(a==0&& b!=0){a=b
////       a = a + b;
////        b = a - b;
////        a = a - b;
//        System.out.println(a + "   " + b);
    }
}
