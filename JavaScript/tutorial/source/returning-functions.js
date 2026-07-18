// function one() {
//     return 'one';
// }

// let value = one;
// console.log(typeof value);
// console.log(value());

// function two() {
//     return function() {
//         console.log('two');
//     }
// }

// let myFunction = two();
// myFunction();

function three() {
    return function() {
        return 'three';
    }
}

console.log(three()());