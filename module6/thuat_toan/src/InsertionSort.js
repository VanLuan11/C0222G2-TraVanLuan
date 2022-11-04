function insertionSort(arr) {
    let pos, x;
    for (let i = 1; i < arr.length; i++) {
        pos = i - 1;
        x = arr[i];
        while (pos >= 0 && arr[pos] > x) {
            arr[pos + 1] = arr[pos];
            pos--;
        }
        arr[pos + 1] = x;
    }
    return arr;
}

let arr = [9, 27, 38 ,43, 3, 9, 82, 10 , 10, -6, -7]
console.log(insertionSort(arr));