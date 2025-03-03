## Challenge 1: Generate Pattern

```javascript
function generatePattern() {
    let result = "";
    for (let i = 1; i <= 3; i++) {
        for (let j = 1; j <= i; j++) {
            result += j + " ";
        }
        result += "\n";
    }
    return result;
}
console.log(generatePattern());
```
This code generates a simple number pattern in the shape of a triangle. 
The function generatePattern builds a string (result) by looping throughnumbers in a specific order. 
The outer loop (i) controls the number of rows, while the inner loop (j)determines how many numbers appear in each row. 
Each row is followed by a newline (\n), so the out put have spacebetween. 
This happens because the loop runs from 1 to i, so each row gets one morenumber than the previous row.

### Output:
```
1  
1 2  
1 2 3  
```

| Variable | Value                                     |
| -------- | ----------------------------------------- |
| `result` | "" (initial), "1", "1 2", "1 2 3" (final) |
| `i`      | Iterates from `1` to `3`                  |
| `j`      | Iterates from `1` to `i`                  |

---

## Challenge 2: Swap First and Last Element

```javascript
function swapFirstLast(arr) {
    let first = arr.shift();
    let last = arr.pop();
    arr.unshift(last);
    arr.push(first);
    return arr;
}
let numbers = [10, 20, 30, 40];
console.log(swapFirstLast(numbers));
console.log(numbers);
```
This code swaps the first and last elements of an array while modifying the original array.
The function removes (shift) the first element (10) and stores it infirst.
It removes (pop) the last element (40) and stores it in last.
It then inserts (unshift) last (40) at the beginning of the array.
Finally, it adds (push) first (10) to the end of the array.
Both console.log() calls print the modified array because the functiondirectly changes the original array.

### Output:
```
[40, 20, 30, 10]
[40, 20, 30, 10]
```

| Variable  | Value              |
| --------- | ------------------ |
| `first`   | `10`               |
| `last`    | `40`               |
| `numbers` | `[40, 20, 30, 10]` |

---

## Challenge 3: Filter Passing Grades

```javascript
function filterPassingGrades(grades) {
    let passing = [];
    for (let grade of grades) {
        if (grade >= 70) {
            passing.push(grade);
        } else {
            passing.unshift(grade);
        }
    }
    return passing;
}
let scores = [85, 45, 90, 60];
console.log(filterPassingGrades(scores));
```
This code separates passing and failing grades into a new arrangement.
It loops each grade in the grades array.
If the grade is 70 or higher, it's passing and added to the end of thepassing array using push().
If the grade is below 70, it's considered failing and added to thebeginning of the passing array using unshift().
This happens because failing grades get placed at the front while passinggrades go to the back.

### Output:
```
[60, 45, 85, 90]
```

| Variable  | Value                     |
| --------- | ------------------------- |
| `grades`  | `[85, 45, 90, 60]`        |
| `passing` | `[60, 45, 85, 90]`        |
| `grade`   | Iterates through `grades` |

---

## Challenge 4: Update Task Status

```javascript
function updateStatus(tasks) {
    for (let task of tasks) {
        task.completed = !task.completed;
    }
    return tasks;
}
let taskList = [
    { id: 1, completed: false },
    { id: 2, completed: true }
];
console.log(updateStatus(taskList));
console.log(taskList);
```
This code check the completed status of each task in the taskList array.
The function loops through each task in the tasks array.
It updates the completed property by setting it to the opposite valueusing !task.completed.false 
becomes true, and true becomes false.
### Output:
```
{ id: 1, completed: true },
{ id: 2, completed: false }
```

| Variable         | Value                                      |
| ---------------- | ------------------------------------------ |
| `task`           | Iterates through `taskList`                |
| `task.completed` | `true` (was `false`), `false` (was `true`) |

---

## Challenge 5: Find Value in an Array

```javascript
function findValue(arr, target) {
    for (let i = 0; i < arr.length; i++) {
        if (arr[i] === target) {
            return `Found at index ${i}`;
        }
    }
    return "Not found";
}
let data = [5, 12, 8, 130, 44];
console.log(findValue(data, 12));
console.log(findValue(data, 100));
```
 On this code it search a specific value (target) in an array and returns its position if found.
The function loops in the array using an index (i).
If the current element (arr[i]) matches the target, it returns "Found atindex i".
If the loop finishes without finding the value, it returns "Not found".
### Output:
```
Found at index 1
Not found
```

| Variable | Value                                  |
| -------- | -------------------------------------- |
| `arr`    | `[5, 12, 8, 130, 44]`                  |
| `target` | `12` (first call), `100` (second call) |
| `i`      | Iterates from `0` to `arr.length - 1`  |
