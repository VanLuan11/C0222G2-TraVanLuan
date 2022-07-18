function isFibonacci(n: number): number {
    if (n == 0 || n == 1) {
        return n;
    }
    return isFibonacci(n - 1 ) + isFibonacci(n - 2);

}

let n: number = 10;
let sum = 0;
for (let i = 0; i < n; i++) {
    console.log(isFibonacci(i));
    sum += isFibonacci(i);
}
console.log(`Tổng: ${sum}`);

