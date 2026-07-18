import React, { useState } from 'react';
import './App.css';

function CurrencyConvertor() {
  const [rupees, setRupees] = useState('');
  const [message, setMessage] = useState('');

  const handleSubmit = (e) => {
    e.preventDefault();
    const euro = parseFloat(rupees) / 80; // Assuming 1 Euro = 80 Rupees
    setMessage(`Converting to Euro Amount is ${euro}`);
  };

  return (
    <div style={{ marginTop: '20px' }}>
      <h2 style={{ color: 'green' }}>Currency Convertor!!!</h2>
      <form onSubmit={handleSubmit}>
        <div style={{ marginBottom: '10px' }}>
          <label style={{ marginRight: '10px' }}>Amount:</label>
          <input 
            type="number" 
            value={rupees} 
            onChange={(e) => setRupees(e.target.value)} 
            placeholder="Rupees" 
          />
        </div>
        <div style={{ marginBottom: '10px' }}>
          <label style={{ marginRight: '10px' }}>Currency:</label>
          <input type="text" value="Euro" readOnly />
        </div>
        <button type="submit">Submit</button>
      </form>
      {message && <p>{message}</p>}
    </div>
  );
}

function App() {
  const [counter, setCounter] = useState(5);
  const [message, setMessage] = useState('');

  const handleIncrement = () => {
    setCounter(prev => prev + 1);
    setMessage('Hello! Member1');
  };

  const handleDecrement = () => {
    setCounter(prev => prev - 1);
  };

  const sayWelcome = (msg) => {
    setMessage(msg);
  };

  const handleSyntheticEvent = (e) => {
    setMessage('I was clicked');
  };

  return (
    <div style={{ fontFamily: 'sans-serif', padding: '20px' }}>
      <h1>{counter}</h1>
      <div style={{ display: 'flex', flexDirection: 'column', width: '150px', gap: '5px' }}>
        <button onClick={handleIncrement}>Increment</button>
        <button onClick={handleDecrement}>Decrement</button>
        <button onClick={() => sayWelcome('welcome')}>Say welcome</button>
        <button onClick={handleSyntheticEvent}>Click on me</button>
      </div>
      
      {message && (
        <div style={{ marginTop: '20px', padding: '10px', border: '1px solid #ccc' }}>
          <p>localhost:3000 says</p>
          <p>{message}</p>
          <button onClick={() => setMessage('')}>OK</button>
        </div>
      )}

      <CurrencyConvertor />
    </div>
  );
}

export default App;
