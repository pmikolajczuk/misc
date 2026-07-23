/* 
var car = {
    make: 'bmw',
    model: '745li',
    year: 2010,
    getPrice: function() {
        return 5000;
    },
    printDescription: function() {
        console.log(this.make + ' ' + this.model);
    }
};

car.printDescription(); 
*/

/* function first() {
    return this;
}

console.log(first() === global); // true
 */

/* function second() {
    'use strict';
}

console.log(second() === global); // false

console.log(second() === undefined); // true 
*/

/* let myObject = { value: 'My Object' };

// value is set on the global object
global.value = 'Global Object';

function third(name) {
    return this.value + name;
}
//console.log(third()); // 'Global Object'

console.log(third.call(myObject, 'bob')); // 'My Object'
console.log(third.apply(myObject, ['bob'])); // 'My Object' */

function fifth() {
    console.log(this.firstName + ' ' + this.lastName);
}

let customer1 = {
    firstName: 'bob',
    lastName: 'tabor',
    print: fifth
};

let customer2 = {
    firstName: 'sue',
    lastName: 'storm',
    print: fifth
};

customer2.print(); // 'sue storm'
customer1.print(); // 'bob tabor'