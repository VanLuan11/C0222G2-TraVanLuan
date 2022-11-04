function bubbleSort(arr) {
    for (let i = 0; i < arr.length - 1; i++) {
        for (let j = arr.length - 1; j > i; j--) {
            if (arr[j] < arr[j - 1]) {
                let t = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = t;
            }
        }}return arr
}
let arr = [38, 27, 27 ,43, 3, 9, 82, 10 , 10, -6, -7]
console.log(bubbleSort(arr));