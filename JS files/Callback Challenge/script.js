// // 1. Custom Map Function
// function customMap(arr, callback) {
//     let result = [];
//     for (let i = 0; i < arr.length; i++) {
//         result.push(callback(arr[i]));
//     }
//     return result;
// }
// let numbers = [1, 2, 3];
// let doubled = customMap(numbers, function (num) { return num * 2; });
// console.log(doubled); // Should output: [2,4,6]

// // 2. Filter Function
// function filter(arr, callback) {
//     let result = [];
//     for (let i = 0; i < arr.length; i++) {
//         if (callback(arr[i])) {
//             result.push(arr[i])
//         }
//     }
//     return result;
// }
// let result = filter([1, 2, 3, 4, 15, 5, 6, 7, 35], function (val) { return val < 20; });
// console.log(result); // Should output: [1,2,3,4]

// // 3. Some Function
// function some(arr, callback) {
//     for (let i = 0; i < arr.length; i++) {
//         if (callback(arr[i])) {
//             return false;
//         }
//     }
//     return true;
// }
// let result = some([1, 2, 3, 4], function (val) { return val > 5; });
// console.log(result); // Should output: true

// // 4. Every Function
// function every(arr, callback) {
//     for (let i = 0; i < arr.length; i++) {
//         if (!callback(arr[i])) {
//             return false;
//         }
//     }
//     return true;
// }
// let result = every([1, 2, 3], function (val) { return val > 0; });
// console.log(result); // Should output: true

// // 5. Reduce Function
// function reduce(arr, callback){
//     let sum = 0
//     for (let i = 0; i < arr.length; i++) {
//         sum = callback(sum, arr[i]);
//     }
//     return sum;
// }
// let sum = reduce([1, 2, 3], function (acc, num) { return acc + num; });
// console.log(sum); // Should output: 6

// // 6. Includes Check
// function includes(arr, callback) {
//     for (let i = 0; i < arr.length; i++) {
//         if (callback(arr[i])) {
//             return true;
//         }
//     }
//     return false;
// }
// let result = includes([1, 2, 3, 4, 5, 6], function (val) { return val === 7; });
// console.log(result); // Should output: true