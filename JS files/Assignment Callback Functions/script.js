// Task 1: Custom Array Filter
function customFilter(arr, callback) {
    let result = [];
    for (let item of arr) {
        if (callback(item)) {
            result.push(item);
        }
    }
    return result;
}
function isEven(num) {
    return num % 2 === 0;
}
var numbers = [1, 2, 3, 4, 5, 6];
var evenNumbers = customFilter(numbers, isEven);
console.log(evenNumbers);  // Output: [2, 4, 6]

// Task 2: Countdown Timer
function countdown(start, callback) {
    function timer(num) {
        if (num < 0) return;
        callback(num);
        setTimeout(() => timer(num - 1), 1000);
    }
    timer(start);
}
function displayNumber(num) {
    console.log(num);
}
countdown(5, displayNumber);  // Output: 5 4 3 2 1 0 (with 1-second delay between each)

// Task 3: Simple Event listener
function createButton(buttonText, callback) {
    let button = document.createElement("button");
    button.textContent = buttonText;
    button.addEventListener("click", callback);
    document.body.appendChild(button);
}
function buttonClicked() {
    console.log("Button Clicked!");
}
createButton("Click Me", buttonClicked);

//Task 4: Task Runner
function runTasks(tasks) {
    // Your code here
    function executetask(index) {
        if (index >= tasks.length) return;
        tasks[index]();
        setTimeout(() => executetask(index + 1), 1000);
    }
    executetask(0);
}

function task1() {
    console.log("Task 1 completed");
}

function task2() {
    console.log("Task 2 completed");
}

function task3() {
    console.log("Task 3 completed");
}

runTasks([task1, task2, task3]);  

// Task 5: Interactive Quiz Game (Extra Miles)
function askQuestion(question, choices, correctAnswer, callback) {
    // Your code here
    console.log(question);
    console.log(choices);
    let useranswer = "4";
    console.log("answer: " + useranswer);
    callback(useranswer == correctAnswer)
}
function checkAnswer(isCorrect) {
    if (isCorrect) {
        console.log("Correct!");
    } else {
        console.log("Wrong!");
    }
}
askQuestion("What is 2 + 2?", ["1", "2", "3", "4"], "4", checkAnswer);