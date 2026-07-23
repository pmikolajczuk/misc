let names = ['Alice', 'Bob', 'Charlie', 'Diana', 'Ethan'];
let others = ['Fiona', 'George', 'Hannah'];

let lost = [4, 8 , 15, 16, 23, 42];
let fibonacci = [0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55];

var combine = lost.concat(fibonacci);
// console.log(combine);

//console.log(fibonacci.join('~'));

// console.log(lost.shift());
// console.log(lost);

// lost.unshift(1, 2, 3, 4);
// console.log(lost);

// console.log(names);
// console.log(names.reverse());
// console.log(names);

// console.log(names.sort());

// console.log(names.indexOf('Charlie'));
// console.log(names.lastIndexOf('Zoe'));

var filtered = combine.filter((x) => x <= 15);
// console.log(filtered);

//names.forEach((name) => {console.log(`howdy ${name}`);});

//console.log(filtered.every((num) => num < 50));

console.log(combine.some((num) => num % 2 === 0));