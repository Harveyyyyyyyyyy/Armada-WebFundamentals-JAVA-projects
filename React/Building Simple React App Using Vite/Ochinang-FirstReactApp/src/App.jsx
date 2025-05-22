import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'

function App() {
    const [count, setCount] = useState(0)

    return (
        <>
            <h1>Vite and Node.js</h1>
            <button onClick={() => setCount(count + 1)}>
                You clicked {count} times
            </button>

            <p><strong>Important Commands in Order:</strong></p>

            <ol>
                <li>Navigate to the folder where you want your app.</li>
                <li>Create a React app using Vite:</li>
                <code>npm create vite@latest my-react-app -- --template react-swc</code>
                <li>Navigate into the new app folder:</li>
                <code>cd my-react-app</code>
                <li>Install dependencies:</li>
                <code>npm install</code>
                <li>Run your app in development mode:</li>
                <code>npm run dev</code>
            </ol>

            <p>
                After running <code>npm run dev</code>, you can open your browser and go to:
                <br />
                <a href="http://localhost:5173/">http://localhost:5173/</a>
            </p>
        </>
    )
}

export default App