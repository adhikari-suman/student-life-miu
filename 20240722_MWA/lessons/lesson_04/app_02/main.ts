import { DE_Student } from './DE_Student.js';

const jack = new DE_Student(123, "Jack", 3.0);

console.log(jack.id);
console.log(jack.getName());
console.log(jack.gpa);
console.log(jack.getName(), "is enrolled in", jack["course"]);
console.log(jack.getName(), "can you prgram?");
console.log(jack["canProgram"]);


if (jack["canProgram"]) {
    console.log(jack.getName(), "please program.");
    jack["program"]();
} else {
    console.log(jack.getName(), "don't worry you will learn after this course.");
}


for(const key in jack){
    console.log(key);
}
