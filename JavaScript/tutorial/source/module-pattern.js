var counter = (function() {
    //private stuff
    let count = 0;

    function print(message) {
        console.log(message + '---' + count);
    }

    // return an object
    return {
        //value: count,

        get: function() { return count; },
        set: function(value) { count = value; },

        increment: function() {
            count += 1;
            print('After increment: ');
        },

        reset: function() {
            print('Before reset: ');
            count = 0;
            print('After reset: ');
        }
    }
})();

//console.log(counter.count); // undefined

counter.increment(); // After increment: ---1
counter.increment(); // After increment: ---2
counter.increment(); // After increment: ---3

// Accidently created closure over initial value of count
//console.log(counter.value); // 0

counter.set(7);
console.log(counter.get()); // 7

counter.reset();     // Before reset: ---3