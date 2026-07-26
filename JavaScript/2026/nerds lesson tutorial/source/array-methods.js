let names = ['david', 'eddie', 'alex', 'michael'];
let others = ['james', 'matthew', 'john', 'peter'];

let lost = [4, 8, 15, 16, 23, 42];
let fibonacci = [1, 1, 2, 3, 5, 8, 13, 21, 34, 55];

var combined = lost.concat(fibonacci);
// console.log(combined);

// console.log(fibonacci.join('~'));

// push, pop

// console.log(lost.shift());
// console.log(lost);
// lost.unshift(1, 2, 3, 4);
// console.log(lost);

// console.log(names.reverse());
// console.log(names.sort());

// console.log(others.indexOf('matthew'));
// console.log(combined.lastIndexOf(1));

// map

var filtered = combined.filter((x) => x <= 15);
// console.log(filtered);

// names.forEach((name) => console.log(`howdy ${name}`));

// console.log(filtered.every((num) => num < 16));
console.log(fibonacci.some((num) => num > 50));