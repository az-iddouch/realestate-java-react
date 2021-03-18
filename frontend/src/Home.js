import React from 'react';
import './Home.css';
import Banner from './Banner';
import Card from './Card';

function Home() {
  return (
    <div className="home">
      <Banner />
      <div className="home__section">
        <Card
          cityName="Agadir"
          src="https://media.istockphoto.com/photos/marina-in-agadir-city-at-sunset-morocco-picture-id845800272?k=6&m=845800272&s=612x612&w=0&h=iu9ocf9HZNufnz37ncjeKaMZ-b4CO_zRaYkcACJ75_I="
          numberOfPostings={100}
        />
        <Card />
        <Card />
        <Card />
        <Card />
        <Card />
        <Card />
        <Card />
      </div>
    </div>
  );
}

export default Home;
