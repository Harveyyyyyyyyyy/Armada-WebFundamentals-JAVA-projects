// Exercise 1: Writing Your First Callback Function
function calculate(num1, num2, operation) {
    return operation(num1, num2);
}

function add(a, b) {
    return a + b;
}

function multiply(a, b) {
    return a * b;
}

function subtraction(a, b) {
    return a - b;
}

function division(a, b) {
    return a / b;
}

console.log(calculate(5, 3, add));  //Output: 8
console.log(calculate(4, 2, multiply)); //Output: 8
console.log(calculate(4, 2, subtraction));   //Output: 2
console.log(calculate(15, 5, division)); //Output: 3

// Exercise 2: Using Callbacks with setTimeout
function delayedMessage(message, delay, beforeCallback, callback) {
    beforeCallback(message);
    setTimeout(() => {
        callback(message);
    }, delay);
}

delayedMessage("Hello, world!", 2000, function (msg) {
    console.log(msg);
},
    function (msg) {
        console.log("Hello, world! 2");
    }
);

// Exercise 3: Handling Events with Callbacks
document.getElementById("clickMe").addEventListener("click", function () {
    alert("Button clicked!");
});
document.getElementById("clickMe2").addEventListener("click", function () {
    alert("Button clicked! 2");
});

// Exercise 4: Looping with Callbacks
function repeatTask(times, callback) {
    for (let i = 0; i < times; i++) {
        if (callback(i) == false) {
            break;
        }
    }
}
repeatTask(3, function (index) {
    console.log("Iteration:", index);
});