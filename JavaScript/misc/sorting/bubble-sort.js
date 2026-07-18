testNumbers = [5, 4, 1, 3, 2];

console.log('Input:')
console.log(testNumbers);
sortV2(testNumbers);
console.log('\nOutput:')
console.log(testNumbers);


/**
 * bubble sort implementation - optimized version 
 * @param {number[]} numbers 
 */
function sortV2(numbers) {
  for(let maxElementIndex = numbers.length - 1; maxElementIndex > 0; maxElementIndex--) {
    for(let index = 0; index < maxElementIndex; index++) {
      if(numbers[index] > numbers[index +1]) {
        [numbers[index], numbers[index+1]] = [numbers[index+1], numbers[index]];
      }
    }
    
  }
}

/**
 * bubble sort implementation - basic version
 * @param {number[]} numbers 
 */
function sortV1(numbers) {
  let wasSwapped = true;
  while(wasSwapped) {
    wasSwapped = false;
    for(let i = 0; i < numbers.length - 1; i++) {
      if(numbers[i] > numbers[i+1]) {
        const tmp = numbers[i];
        numbers[i] = numbers[i+1];
        numbers[i+1] = tmp;
        wasSwapped = true;
      }
    }
  }
}