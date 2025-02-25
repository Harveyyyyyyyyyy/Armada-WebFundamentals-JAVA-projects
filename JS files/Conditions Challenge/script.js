// Task 1
let score = 60;

if (score >= 90 && score <= 100) {
    console.log(score + " Grade A");
} else if (score >= 80 && score <= 89) {
    console.log(score + " Grade B")
} else if (score >= 70 && score <= 79) {
    console.log(score + " Grade C")
} else if (score >= 60 && score <= 69) {
    console.log(score + " Grade D")
} else if (score < 60) {
    console.log(score + " Grade F")
}

// Task 2
let temperature = -15;

if (temperature < 0) {
    console.log("It's freezing outside! Bundle up!")
} else if (temperature >= 0 && temperature <= 15) {
    console.log("It's cold outside. Wear a jacket.")
} else if (temperature >= 16 && temperature <= 30) {
    console.log("The weather is nice. Enjoy your day!")
} else if (temperature > 30) {
    console.log("It's hot outside. Stay hydrated!")
}

// Task 3
let age = 15

if (age < 13) {
    console.log("You are too young for this activity.")
} else if (age >= 13 && age <= 17) {
    console.log("You need parental permission.")
} else if (age >= 18) {
    console.log("You are eligible for this activity.")
}

// Task 4
let year_old = 12;
let ismember = false;

if (year_old < 12) {
    console.log("The ticket is free.")
} else if (year_old >= 12 && ismember == true) {
    console.log("The ticket costs $10.")
} else if (year_old >= 12 && ismember == false) {
    console.log("The ticket costs $15.")
}

// Task 5
function isLeapYear(year) {
    if ((year % 4 == 0 && year % 100 !== 0) || (year % 400 == 0)) {
        return true;
    } else {
        return false;
    }
}
console.log(isLeapYear(2024));
console.log(isLeapYear(2025));