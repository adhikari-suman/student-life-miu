/**
 * Fibonacci [0, 1, 1, 2, 3 ...]
 * n starts at 0
 * @param n
 */
function fibonacci(n) {
    if (n === 0) {
        return 0;
    } else if (n === 1) {
        return 1;
    } else if (n > 1) {
        const first = fibonacci(n - 1);
        const second = fibonacci(n - 2);

        const result = first + second;

        return result;
    } else {
        n = -n;
        return -fibonacci(n);
    }
}

// cache to save fibonacci results
fibonacciCache = {
    0: 0,
    1: 1,
}


/**
 * Fibonacci [0, 1, 1, 2, 3 ...]
 * n starts at 0
 * @param n
 */
function fibonacciWithCache(n) {
    if (n in fibonacciCache) {
        return fibonacciCache[n];
    }

    if (n >= 0) {
        const first = fibonacciWithCache(n - 1);
        const second = fibonacciWithCache(n - 2);

        const result = first + second;

        fibonacciCache[n] = result;

        // console.log(fibonacciCache);

        return result;

    } else {
        n = -n;

        if (n in fibonacciCache) {
            return -fibonacciCache[n];
        } else {
            return -fibonacciWithCache(n);
        }
    }
}

async function nonBlockingFibonacciWithCache(n) {
    return new Promise((resolve, reject) => {
        setTimeout(() => {
            resolve(fibonacciWithCache(n));
        }, 0);

    });
}

const operations = async () => {
    let startTime = performance.now();
    console.log(`Fibonacci of -53 is ${await nonBlockingFibonacciWithCache(-53)}`);
    let endTime = performance.now();

    console.log(`nonBlockingFibonacciWithCache(-53) took ${endTime - startTime} ms\n`);

    startTime = performance.now();
    console.log(`Fibonacci of 19 is ${await nonBlockingFibonacciWithCache(19)}`);
    endTime = performance.now();
    console.log(`fibonacciWithCache(19) took ${endTime - startTime} ms\n`);

    startTime = performance.now();
    console.log(`Fibonacci of 19 is ${fibonacci(19)}`);
    endTime = performance.now();
    console.log(`fibonacci(19) took ${endTime - startTime} ms\n`);

    console.log(fibonacciCache);
}

operations();