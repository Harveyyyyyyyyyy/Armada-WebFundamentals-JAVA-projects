## Challenge 1:

```javascript
function calculateSum(arr) {
    let sum = 0;
    for (let i = 0; i < arr.length; i++) {
        sum += arr[i];
    }
    return sum;
}
let numbers = [1, 2, 3, 4];
console.log("Sum:", calculateSum(numbers));
```

### Output:
```
Sum: 10
```
In this code it defines a function calculateSum that takes array of numbers and just adds them.
Then it calls the function with array [1,2,3,4] and print the  result.
It then uses a loop to iterate over the array and add all the numbers then return the final  sum. 
In this case it adds 1+2+3+4 and print  10.

| Variable | Value                                 |
| -------- | ------------------------------------- |
| `arr`    | `[1, 2, 3, 4]`                        |
| `sum`    | Iterates from `0` to final sum `10`   |
| `i`      | Iterates from `0` to `arr.length - 1` |

---

## Challenge 2:

```javascript
function isEven(num) {
    if (num % 2 === 0) {
        return true;
    } else {
        return false;
    }
}
console.log(isEven(4));
console.log(isEven(7));
console.log(isEven(0));
```

### Output:
```
true
false
true
```
On this code it declares a function named isEven(num) that returns whether a number is even or not 
and it tries the function with three numbers: 4, 7, and 0. 
This function is an easy method to see if a number is even and the zero display true because 
it uses a === that checks whether the operands are equal in both value and type. 
It accomplishes this by employing the modulus operator (%) to determine if the number is divisible by 2.

| Variable | Value     |
| -------- | --------- |
| `num`    | `4, 7, 0` |

---

## Challenge 3:

```javascript
function greet(name) {
    return "Hello, " + name + "!";
}

function personalizedGreeting(names) {
    for (let i = 0; i < names.length; i++) {
        console.log(greet(names[i]));
    }
}
let friends = ["Alice", "Bob", "Charlie"];
personalizedGreeting(friends);
```

### Output:
```
Hello, Alice!
Hello, Bob!
Hello, Charlie!
```
This function is designed to greet many people individually it takes a name as an argument and returns a "Hello, Alice!". 
Then the personalizedGreeting function takes a list of names and loops over each name, calling the greet function for each name. 
The result is printed using console.log(). in addition we have list of friends which is ["Alice", "Bob", "Charlie"], 
it prints "Hello, Alice!", "Hello, Bob!", and "Hello, Charlie!" individually. 
That is, the loop loops over each name individually, producing and printing a customized hello for each person.

| Variable | Value                                   |
| -------- | --------------------------------------- |
| `names`  | `["Alice", "Bob", "Charlie"]`           |
| `i`      | Iterates from `0` to `names.length - 1` |

---

## Challenge 4:

```javascript
function reverseArray(arr) {
    let reversed = [];
    for (let i = arr.length - 1; i >= 0; i--) {
        reversed.push(arr[i]);
    }
    return reversed;
}
let originalArray = [10, 20, 30];
console.log(reverseArray(originalArray));
console.log(originalArray);
```

### Output:
```
[30, 20, 10]
[10, 20, 30]
```

This is a function used to reverse an array but will not touch the original array. The function reverseArray receives an array and then 
forms a new empty array to be referred to as reversed. It proceeds with looping over the original array in the last element and 
backward direction, adding one element to the reversed array at a time. It finally returns the new reversed array.
When it performs the call of reverseArray([10, 20, 30]), the function processes elements in reverse order:[30, 20, 10]. 
In addition on the second console.log(originalArray); prints [10, 20, 30], which indicates that the original array has not been changed. 
This is because the function creates a new array rather than modifying the original array directly.


| Variable   | Value                                 |
| ---------- | ------------------------------------- |
| `arr`      | `[10, 20, 30]`                        |
| `reversed` | `[30, 20, 10]`                        |
| `i`        | Iterates from `arr.length - 1` to `0` |

---

## Challenge 5:

```javascript
function multiplyMatrix(matrix) {
    for (let i = 0; i < matrix.length; i++) {
        for (let j = 0; j < matrix[i].length; j++) {
            matrix[i][j] *= 2;
        }
    }
    return matrix;
}
let matrix = [
    [1, 2],
    [3, 4],
];
console.log(multiplyMatrix(matrix));
```

### Output:
```
[2, 4]
[6, 8]
```
On this code the out put is [2,4] and [6,8] because it takes a 2D array and multiplies every number in it by 2. 
The function multiplyMatrix goes through each row and then each number in the row, doubling its value. 
When called with [[1, 2], [3, 4]].This happens because the loop updates each value in the given matrix, and the modified matrix is returned.

| Variable | Value                                        |
| -------- | -------------------------------------------- |
| `matrix` | `[[1, 2], [3, 4]]` *(before multiplication)* |
| `matrix` | `[[2, 4], [6, 8]]` *(after multiplication)*  |
| `i`      | Iterates from `0` to `matrix.length - 1`     |
| `j`      | Iterates from `0` to `matrix[i].length - 1`  |