let today = new Date();

let bob = new Date('December 17, 1995 03:24:00');
let alice = new Date(1995, 11, 17, 3, 24, 0);
console.log(alice.getDate());

var elapsed = today - bob; // elapsed time in milliseconds
console.log(elapsed);