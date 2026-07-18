let car = {
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

// car.printDescription();
// console.log(car.year);
// console.log(car['year']);

/*
var anotherCar = {};
anotherCar.whatever = 'bob';
console.log(anotherCar.whatever);

var a = {
    myProperty: {b: 'hi'}
};

console.log(a.myProperty.b);
*/

/*
var c = {
    myProperty: [
        {d: 'this' },
        {e: 'can' },
        {f: 'get' },
        {g: 'crazy' }
    ]
}

console.log(c.myProperty[3].g);
*/

let carLot = [
    {year: 2001, make: 'honda', model: 'accord'},
    {year: 2010, make: 'bmw', model: '745li'},
    {year: 1985, make: 'mercury', model: 'cougar'}
];

let contacts = {
    customers: [
        {firstName: 'joe', lastName: 'smith', phoneNumbers: ['800-555-1212', '415-555-1212']},
        {firstName: 'sally', lastName: 'jones', phoneNumbers: ['650-555-1212']}
    ],
    employees: [
        {firstName: 'jim', lastName: 'johnson', phoneNumbers: ['510-555-1212', '212-555-1212']},
        {firstName: 'ann', lastName: 'jones', phoneNumbers: ['415-555-1212']},
        {firstName: 'jill', lastName: 'brown', phoneNumbers: ['415-555-1213', '510-555-1212']}
    ]
};
console.log(contacts.employees[2].phoneNumbers[0]);