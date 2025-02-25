// Task 1
let book = {
    title: "To Kill a Mockingbird",
    author: "Harper Lee",
    pages: 246,
    isRead: false
};

console.log(book.title)
console.log(book.author)
console.log(book.pages)
console.log(book.isRead)

console.log(book["title"])
console.log(book["author"])
console.log(book["pages"])
console.log(book["isRead"])

book.isRead = true;
book.genre = "Horror";

console.log(book)

// Task 2
let movies = [
    {
        title: "Inside Out 2",
        director: "Kelsey Mann",
        year: 2024
    },
    {
        title: "Deadpool & Wolverine",
        director: "Shawn Levy",
        year: 2024
    },
    {
        title: "Moana 2",
        director: "Dana Ledoux Miller",
        year: 2024
    },
];

console.log(movies[1].title)

movies.push({
    title: "Spider-Man: Beyond the Spider-Verse",
    director: "Joaquim Dos Santos",
    year: 2024
});

movies[0].year = 2023;

console.log(movies);

// Task 3
let students = {
    name: "Mark Harvey C. Ochinang",
    age: 22,
    subjects: ["Math", "Science", "History"]
};

console.log(students.subjects[0]);
students.subjects.push("English");
console.log(students)

// Task 4
let recipe = {
    name: "Pasta Salad",
    ingredients: ["Pasta", "1 cup"],
    isvegetarian: true
};

recipe.ingredients.push("Fruits");
console.log(recipe.ingredients[1]);
console.log(recipe)