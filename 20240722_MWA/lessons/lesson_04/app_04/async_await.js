function resolveAfter2Seconds() {
  return new Promise((resolve) =>
    setTimeout(() => {
      resolve("Done");
    }, 2000)
  );
}

async function myAsyncFunction() {
  console.log("Start");
  const promise = await resolveAfter2Seconds();
  console.log(promise);
  console.log("End");
}

console.log("Begin");
myAsyncFunction();
console.log("Finish");