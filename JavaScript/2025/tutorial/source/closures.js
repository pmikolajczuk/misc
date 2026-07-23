function sayHello(name) {
    return function() {
        console.log('howdy ' + name);
    }
}

let bob = sayHello('Bob');
let conrad = sayHello('Conrad');
let grant = sayHello('Grant');

conrad(); // Output: howdy Conrad
grant(); // Output: howdy Grant

bob(); // Output: howdy Bob