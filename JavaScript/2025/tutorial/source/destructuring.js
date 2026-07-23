let a, b, c, d, e;

let names = ['david', 'john', 'mike', 'sarah', 'linda'];

/* 
[a, b, c, e, d] = names;

console.log(a); // david
console.log(b); // john
console.log(c); // mike
console.log(d); // linda
console.log(e); // sarah
 */

/* 
let others;
[a, b, ...others] = names;

console.log(a); // david
console.log(b); // john
console.log(others); // [ 'mike', 'sarah', 'linda' ]
 */

let year, model;
({year, model} = {
    make: 'Toyota',
    model: 'Camry',
    year: 2020,
    value: 5000
});

console.log(year); // 2020
console.log(model); // Camry