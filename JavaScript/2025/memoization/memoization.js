const memoizeFn = (fn) => {
	const cache = {};
	return (...n) => {
		if(cache[n]) {
			return cache[n];
		} else {
			cache[n] = fn(...n);
			return cache[n];
		}
	}
};

const fibonacci = (n) => {
  return n <= 1 ? n : fibonacci(n - 1) + fibonacci(n - 2);
};
const memoizeFibonacci = memoizeFn(fibonacci);
console.log(memoizeFibonacci(40));
console.log(memoizeFibonacci(40));
console.log(memoizeFibonacci(40));

console.log(memoizeFibonacci(42));
console.log(memoizeFibonacci(42));
console.log(memoizeFibonacci(42));


const memoizeFibonacciFast = memoizeFn(fibonacciFast);
function fibonacciFast(n) {
	return n <= 1 ? n : memoizeFibonacciFast(n - 1) + memoizeFibonacciFast(n - 2)
}
console.log(fibonacciFast(60));

