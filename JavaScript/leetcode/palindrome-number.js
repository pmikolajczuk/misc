let number = 1001;

/**
 * @param {number} x
 * @return {boolean}
 */
let isPalindrome = function(x) {
  return isPalindromeV2(x);
      
};

/**
 * @param {number} x
 * @return {boolean}
 */
function isPalindromeV1(x) {
  let xStr = x.toString();

  let xStrReverse = '';

  for (let i = xStr.length - 1; i >= 0; i--) {
    xStrReverse += xStr[i];
  }

  return xStr === xStrReverse;
}

/**
 * 
 * @param {number} x
 * @return {boolean} 
 */
function isPalindromeV2(x) {
  let xStr = x.toString();
  let length = xStr.length;

  for (let i = 0; i < Math.floor(length / 2); i++ ) {
    if (xStr[i] != xStr[length - 1 - i]) {
      return false;
    }
  }
  return true;
}


console.log(isPalindrome(number));

// let result = reverseNumber(number);
// console.log(result);

function reverseNumber(number) {
  let a = Math.floor(number / 1) % 10;
  let b = Math.floor(number / 10) % 10;
  let c = Math.floor(number / 100) % 10;
  let d = Math.floor(number / 1000) % 10;

  return(a*1000 + b*100 + c*10 + d);

}