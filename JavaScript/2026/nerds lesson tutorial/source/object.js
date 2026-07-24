let car = {
    make: 'bmw',
    model: '745li',
    year: 2010,
    getPrice: function() {
        // perform some calculation
        return 5000;
    },
    printDescription() {
        console.log(this.make + ' ' + this.model);
    }
}

car.printDescription();
console.log(car.year);

// console.log(car['year']);
// console.log(car[1]);

/*
var anotherCar = {};
anotherCar.whatever = 'bob';
console.log(anotherCar.whatever);
*/

/*
var a = {
    myProperty: {b: 'hi' }
};

console.log(a.myProperty.b);
*/

/*
var c = {
    myProperty: [
        { d: 'this'},
        { e: 'can'},
        { f: 'get'},
        { g: 'crazy'}
    ]
};
console.log(c.myProperty[1].e);
*/

let carLot = [
    {year: 2018, make: 'Honda', model: 'Accord'},
    {year: 2017, make: 'Honda', model: 'Civic'},
    {year: 2019, make: 'Toyota', model: 'Corolla'}
];

let contacts = {
    customers: [
        {firstName: 'Joe', lastName: 'Smith', phoneNumbers: ['800-555-1212', '800-555-1213']},
        {firstName: 'Sally', lastName: 'Smith', phoneNumbers: ['800-555-1214', '800-555-1215']},
        {firstName: 'Jim', lastName: 'Johnson', phoneNumbers: ['800-555-1216', '800-555-1217']}
    ],
    employees: [
        {firstName: 'Bob', lastName: 'Smith', phoneNumbers: ['800-555-1218', '800-555-1219']},
        {firstName: 'Sue', lastName: 'Smith', phoneNumbers: ['800-555-1220', '800-555-1221']},
        {firstName: 'Joe', lastName: 'Johnson', phoneNumbers: ['800-555-1222', '800-555-1223']}
    ]
};

console.log(contacts.customers[0].phoneNumbers[1]);
console.log(contacts.employees[2].phoneNumbers[0]);