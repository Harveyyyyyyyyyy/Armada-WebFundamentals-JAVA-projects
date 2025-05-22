import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'

function App() {
    // Logic Section: Define your variables here
    const greeting = "Hello, JSX!";
    const name = "React Developer's";
    const year = 2025;

    return (
        <>
            {/* Render Section: Use JSX expressions to insert variables */}
            <h1>{greeting} Welcome to the {name} year {year}</h1>
        </>
    )
}

export default App
