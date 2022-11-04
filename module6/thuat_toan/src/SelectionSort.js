function selectionSort(arr) {
    let min; // chỉ số phần tử nhỏ nhất trong dãy hiện hành
    for (let  i = 0; i < arr.length - 1; i++){
        min = i;
        for(let j = i + 1; j < arr.length; j++)
        if (arr[j] < arr[min])
            min = j; // ghi nhận vị trí phần tử nhỏ nhất
            let temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
    }
    return arr;
}
let arr = [38, 27, 27 ,43, 3, 9, 82, 10 , 10, -6, -7]
console.log(selectionSort(arr));