## 1. Inventory Tracker

```javascript
let inventory = ["apple", "banana", "cherry", "date", "elderberry"];
let inventoryCount = [10, 15, 5, 20, 7];

for (let i = 0; i < inventory.length; i++) {
    console.log(`${inventory[i]}: ${inventoryCount[i]}`);
}
```

### Output:
```
apple: 10  
banana: 15  
cherry: 5  
date: 20  
elderberry: 7  
```

This code pairs each fruit with its corresponding count. The loop moves through both arrays together, printing each fruit name followed by its stock count.

### Variables and Values:

| Variable         | Value          |
|------------------|----------------|
| `inventory`      | `["apple", "banana", "cherry", "date", "elderberry"]` |
| `inventoryCount` | `[10, 15, 5, 20, 7]`                     |
| `i`              | Iterates from `0` to `inventory.length - 1` |

---

## 2. Alphabetical Sorting

```javascript
let words = ["zebra", "apple", "mango", "cherry", "banana"];

for (let i = 0; i < words.length; i++) {
    for (let j = i + 1; j < words.length; j++) {
        if (words[i] > words[j]) {
            let temp = words[i];
            words[i] = words[j];
            words[j] = temp;
        }
    }
}
console.log(words);
```

### Output:
```
['apple', 'banana', 'cherry', 'mango', 'zebra']
```

This code sorts the list of words alphabetically. It goes through the list, comparing each word with the others, and swaps them if they are out of order.

### Variables and Values:

| Variable  | Value                                       |
|-----------|---------------------------------------------|
| `words`   | `["zebra", "apple", "mango", "cherry", "banana"]` *(before sorting)* |
| `words`   | `["apple", "banana", "cherry", "mango", "zebra"]` *(after sorting)* |
| `i`       | Iterates from `0` to `words.length - 1` |
| `j`       | Iterates from `i + 1` to `words.length - 1` |
| `temp`    | Stores temporary swap values during sorting |

---

## 3. Unique Array Builder

```javascript
let uniqueNumbers = [];

while (uniqueNumbers.length < 10) {
    let randomNumber = Math.floor(Math.random() * 20) + 1;
    // Check if the randomNumber already exists in the array
    let exists = false;
    for (let i = 0; i < uniqueNumbers.length; i++) {
        if (uniqueNumbers[i] === randomNumber) {
            exists = true;
            break;
        }
    }
    // If it doesn't exist, add it to the array
    if (!exists) {
        uniqueNumbers.push(randomNumber);
    }
}
console.log(uniqueNumbers);
```

### Output:
```
[10, 2, 3, 5, 14, 7, 12, 8, 13, 6]
```

This code produces 10 unique random numbers between 1 and 20. It starts with an empty list (`uniqueNumbers = []`), keeps picking a random number between 1 and 20, and before adding it, checks if the number already exists in the list. If it’s new, it is added; otherwise, another number is picked. The process repeats until we have 10 unique numbers.

### Variables and Values:

| Variable         | Value                                  |
|------------------|----------------------------------------|
| `uniqueNumbers`  | A dynamically generated array of 10 unique random numbers between 1 and 20 |
| `randomNumber`   | Randomly generated number (1-20) |
| `exists`         | `true` if `randomNumber` is already in `uniqueNumbers`, otherwise `false` |

---

## 4. Triangle Checker

```javascript
let sideA = 7;
let sideB = 10;
let sideC = 5;

if (sideA + sideB > sideC && sideB + sideC > sideA && sideA + sideC > sideB) {
    console.log(`The sides ${sideA}, ${sideB}, and ${sideC} form a valid triangle.`);
} else {
    console.log(`The sides ${sideA}, ${sideB}, and ${sideC} do not form a valid triangle.`);
}
```

### Output:
```
The sides 7, 10, and 5 form a valid triangle.
```

This code checks whether three given sides can form a valid triangle. The rule states that the sum of any two sides must be greater than the third side:
- `sideA + sideB > sideC`
- `sideB + sideC > sideA`
- `sideA + sideC > sideB`

If all three conditions are true, the sides form a valid triangle. If even one condition fails, it's not a triangle.

### Variables and Values:

| Variable  | Value  |
|-----------|--------|
| `sideA`   | `7`    |
| `sideB`   | `10`   |
| `sideC`   | `5`    |
| Triangle Validity | `true` if sum of any two sides is greater than the third |