/* let name = 'bob';

console.log(`hi ${name}`);

let sentence = `This is really a convenience.
    You probably will never want to do something
  quite like this. You might choose to put...`;

console.log(sentence);
 */

function getReasonCount() {
    return 2;
}

let interpolation = `Give me ${ (getReasonCount() == 1) ? 'one good reason' : 'a few reasons'} to try this.`
console.log(interpolation);