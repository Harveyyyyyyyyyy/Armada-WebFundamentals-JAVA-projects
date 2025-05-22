// Task 1
let number = 5;

for (let i = 1; i <= 10; i++) {
    console.log(`${number} x ${i} = ${number * i}`)
}

// Task 2
let n = 5;
let sum = 0;

for (let i = 1; i <= n; i++) {
    sum = sum + i;
}
console.log(`The sum of the first ${n} numbers is: ${sum}`)

// Task 3
let integers = [2, 4, 6, 8, 10];

for (let i = 0; i < integers.length; i++) {
    console.log(`Array elements: ${integers[i]}`)
}

// Task 4
for (let row = 1; row <= 5; row++) {
    let stars = "";
    for (let col = 1; col <= row; col++) {
        stars = stars + "*";
    }
    console.log(stars);
}

// Task 5
let inte = [1, 3, 5, 7, 9];

for (let i = inte.length - 1; i >= 0; i--) {
    console.log(`Reversed Element: ${inte[i]}`);
}