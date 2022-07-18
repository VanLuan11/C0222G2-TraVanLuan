function isFibonacci(n) {
    if (n == 0 || n == 1) {
        return n;
    }
    return isFibonacci(n - 1) + isFibonacci(n - 2);
}
var n = 10;
var sum = 0;
for (var i = 0; i < n; i++) {
    console.log(isFibonacci(i));
    sum += isFibonacci(i);
}
console.log("T\u1ED5ng: ".concat(sum));
