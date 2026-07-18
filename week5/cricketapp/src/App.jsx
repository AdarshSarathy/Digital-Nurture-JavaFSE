import React from 'react';
import './App.css';

const players = [
  { name: 'Jack', score: 50 },
  { name: 'Michael', score: 70 },
  { name: 'John', score: 40 },
  { name: 'Ann', score: 61 },
  { name: 'Elisabeth', score: 61 },
  { name: 'Sachin', score: 95 },
  { name: 'Dhoni', score: 100 },
  { name: 'Virat', score: 84 },
  { name: 'Jadeja', score: 64 },
  { name: 'Raina', score: 75 },
  { name: 'Rohit', score: 80 }
];

const IndianTeam = ['Sachin1', 'Dhoni2', 'Virat3', 'Rohit4', 'Yuvraj5', 'Raina6'];
const T20Players = ['First Player', 'Second Player', 'Third Player'];
const RanjiTrophyPlayers = ['Fourth Player', 'Fifth Player', 'Sixth Player'];

function ListofPlayers({ players }) {
  return (
    <ul>
      {players.map((item, index) => (
        <li key={index}>Mr. {item.name} <span>{item.score}</span></li>
      ))}
    </ul>
  );
}

function Scorebelow70({ players }) {
  const players70 = [];
  players.map((item) => {
    if (item.score < 70) {
      players70.push(item);
    }
  });

  return (
    <ul>
      {players70.map((item, index) => (
        <li key={index}>Mr. {item.name} <span>{item.score}</span></li>
      ))}
    </ul>
  );
}

function OddPlayers({ players }) {
  const [first, , third, , fifth] = players;
  return (
    <div>
      <ul>
        <li>First : {first}</li>
        <li>Third : {third}</li>
        <li>Fifth : {fifth}</li>
      </ul>
    </div>
  );
}

function EvenPlayers({ players }) {
  const [, second, , fourth, , sixth] = players;
  return (
    <div>
      <ul>
        <li>Second : {second}</li>
        <li>Fourth : {fourth}</li>
        <li>Sixth : {sixth}</li>
      </ul>
    </div>
  );
}

function ListofIndianPlayers({ IndianPlayers }) {
  return (
    <ul>
      {IndianPlayers.map((player, index) => (
        <li key={index}>Mr. {player}</li>
      ))}
    </ul>
  );
}

function App() {
  let flag = true; // Change to false to see the other component

  if (flag === true) {
    return (
      <div style={{ padding: '20px', fontFamily: 'sans-serif' }}>
        <h1>List of Players</h1>
        <ListofPlayers players={players} />
        <hr />
        <h1>List of Players having Scores Less than 70</h1>
        <Scorebelow70 players={players} />
      </div>
    );
  } else {
    const IndianPlayersMerged = [...T20Players, ...RanjiTrophyPlayers];
    return (
      <div style={{ padding: '20px', fontFamily: 'sans-serif' }}>
        <h1>Odd Players</h1>
        <OddPlayers players={IndianTeam} />
        <hr />
        <h1>Even Players</h1>
        <EvenPlayers players={IndianTeam} />
        <hr />
        <h1>List of Indian Players Merged:</h1>
        <ListofIndianPlayers IndianPlayers={IndianPlayersMerged} />
      </div>
    );
  }
}

export default App;
