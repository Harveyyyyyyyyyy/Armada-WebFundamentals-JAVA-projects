// Task 1
let item1 = 2;
let item2 = 4;
let item3 = 6;
let total = item1 + item2 + item3;

console.log("The total cost of the items is: $" + total);

// Task 2
let num1 = 2;
let num2 = 4;
let num3 = 6;
let avg = (num1 + num2 + num3)/3;

console.log("The average is: " + avg)

// Task 3
let store = 15;

if (store % 2 == 0) {
    console.log(store + " is an even number.")
} else {
    console.log(store + " is an odd number.")
}

// Task 4
let price = 100;
let discount = 20;
let discount_amount = (price * discount) / 100;
let discounted_price = price - discount_amount

console.log("The discounted price is: $" + discounted_price + ".")

// Bonus Task
let final_price = 80;
let discount_percentage = 20;
let originalprice = final_price / (1 - discount_percentage / 100);

console.log("The original price before the discount was: $" + originalprice + ".")


