import React from 'react';
import './App.css';

const officeSpaces = [
  { id: 1, Name: 'DBS', Rent: 50000, Address: 'Chennai' },
  { id: 2, Name: 'WeWork', Rent: 80000, Address: 'Bangalore' },
  { id: 3, Name: 'Regus', Rent: 60000, Address: 'Mumbai' },
];

function App() {
  const imageUrl = "https://images.unsplash.com/photo-1497366216548-37526070297c?auto=format&fit=crop&w=400&q=80";
  
  return (
    <div style={{ padding: '20px', fontFamily: 'sans-serif' }}>
      <h1>Office Space , at Affordable Range</h1>
      <img src={imageUrl} width="25%" height="25%" alt="Office Space" style={{ marginBottom: '20px' }} />
      
      <div>
        {officeSpaces.map((item) => {
          let rentColor = item.Rent <= 60000 ? 'red' : 'green';
          
          return (
            <div key={item.id} style={{ marginBottom: '30px' }}>
              <h1 style={{ margin: '5px 0' }}>Name: {item.Name}</h1>
              <h3 style={{ margin: '5px 0', color: rentColor }}>Rent: Rs. {item.Rent}</h3>
              <h3 style={{ margin: '5px 0' }}>Address: {item.Address}</h3>
            </div>
          );
        })}
      </div>
    </div>
  );
}

export default App;
