let a = 7;
let b = '6';
b = parseInt(b, 10);
let c = a + b;

console.log('Result: ' + c); // Result: 13

let d = parseInt('bob', 10);
let e = isNaN(d);

console.log(d); // NaN
console.log(e); // true