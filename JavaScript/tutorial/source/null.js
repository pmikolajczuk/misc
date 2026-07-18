/* let a;
console.log(a); // undefined
console.log(typeof a); // "undefined" */

let pattern = /xyz/;
let value = 'This is just a test.';
let result = value.match(pattern);
console.log(result);
console.log(typeof result);

if (result === null) {
    console.log('No match found.');
}