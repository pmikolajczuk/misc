let pattern = /xyz/;
//console.log(pattern);
//console.log(typeof pattern);

let value = "This is xyz a test.";
// let result = pattern.test(value);
// console.log(result);

// console.log(value.replace(pattern, "just"));

console.log(value.match(pattern));
var match = value.match(pattern);
console.log(match.index);