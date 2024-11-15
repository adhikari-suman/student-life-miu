const promise1 = new Promise((resolve, reject) => {
  let number = Math.random();
  number += 0.5;
  setTimeout(() => {
    if (number > 0.5) {
      resolve(number);
    } else {
      reject("Promise1 error");
    }
  }, 2000);
});

const promise2 = new Promise((resolve, reject) => {
  let number = Math.random();
  number += 0.5;
  setTimeout(() => {
    if (number > 0.5) {
      resolve(number);
    } else {
      reject("Promise2 error");
    }
  }, 1000);
});

const promise3 = new Promise((resolve, reject) => {
  let number = Math.random();
  number += 0.5;

  setTimeout(() => {
    if (number > 0.5) {
      resolve(number);
    } else {
      reject("Promise3 error");
    }
  }, 3000);
});

/////////////////////////////////////////////

// promise1.then((number)=>{
//     console.log("The number is",number);
// }).catch((errorMessage)=>{
//     console.log("The error is", errorMessage);
// });

// promise2.then((number)=>{
//     console.log("The number is",number);
// }).catch((errorMessage)=>{
//     console.log("The error is", errorMessage);
// });

// promise3.then((number)=>{
//     console.log("The number is",number);
// }).catch((errorMessage)=>{
//     console.log("The error is", errorMessage);
// });

// Takes a bunch of promise and executes them, if one of them fails,
// it will call catch on the first one and ends all
// will return an array of results
Promise.all([promise1, promise2, promise3])
  .then((data) => {
    console.log(data);
  })
  .catch((error) => {
    console.log(error);
  });

// Takes a bunch of promise and each promise race against the other. 
// the first one that get's done gets executed only in then and catch.
// other promises will still run and finish.
Promise.race([promise1, promise2, promise3])
  .then((data) => {
    console.log(data);
  })
  .catch((error) => {
    console.log(error);
  });
