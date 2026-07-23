/* let hi = () => { console.log('Howdy'); };
hi();
 */

/* let hi = (name) => { console.log(`Howdy, ${name}!`); };
hi('Alice'); */

/* let add = (x, y) => { return x + y; };
console.log(add(3, 5)); */

//let names = ['Alice', 'Bob', 'Charlie'];

//names.map((name) => {console.log(`Hello, ${name}!`); });

/* let i = 0;
names.forEach((name) => {
    i++;
    console.log(`${i}: ${name}`);
}); */

let names = ['Alice', 'Bob', 'Charlie'];
var transformed = names.map((name) => { return `howdy, ${name}!`; });
console.log(transformed);