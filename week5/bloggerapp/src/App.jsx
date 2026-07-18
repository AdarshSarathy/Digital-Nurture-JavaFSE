import React, { useState } from 'react';
import './App.css';

export const books = [
  {id: 101, bname: 'Master React', price: 670},
  {id: 102, bname: 'Deep Dive into Angular 11', price: 800},
  {id: 103, bname: 'Mongo Essentials', price: 450},
];

export const courses = [
  {id: 1, cname: 'Angular', date: '4/5/2021'},
  {id: 2, cname: 'React', date: '6/3/2020'},
];

export const blogs = [
  {id: 1, title: 'React Learning', author: 'Stephen Biz', desc: 'Welcome to learning React!'},
  {id: 2, title: 'Installation', author: 'Schewzdenier', desc: 'You can install React from npm.'},
];

function BookDetails({ show }) {
  if (!show) {
    return null; // Conditional rendering using null
  }
  
  const bookdet = (
    <ul>
      {books.map((book) => (
        <div key={book.id} style={{marginBottom: '10px'}}>
          <h3 style={{margin: '0'}}>{book.bname}</h3>
          <h4 style={{margin: '0'}}>{book.price}</h4>
        </div>
      ))}
    </ul>
  );
  
  return (
    <div className="section">
      <h2>Book Details</h2>
      {bookdet}
    </div>
  );
}

function CourseDetails({ courses }) {
  // Conditional rendering using short circuit &&
  return (
    <div className="section">
      <h2>Course Details</h2>
      {courses.length > 0 && (
        <ul>
          {courses.map(course => (
            <div key={course.id} style={{marginBottom: '10px'}}>
              <h3 style={{margin: '0'}}>{course.cname}</h3>
              <p style={{margin: '0', fontWeight: 'bold'}}>{course.date}</p>
            </div>
          ))}
        </ul>
      )}
    </div>
  );
}

function BlogDetails({ blogs }) {
  // Conditional rendering using ternary operator
  return (
    <div className="section">
      <h2>Blog Details</h2>
      {blogs ? (
        <ul>
          {blogs.map(blog => (
            <div key={blog.id} style={{marginBottom: '10px'}}>
              <h3 style={{margin: '0'}}>{blog.title}</h3>
              <h5 style={{margin: '0'}}>{blog.author}</h5>
              <p style={{margin: '0'}}>{blog.desc}</p>
            </div>
          ))}
        </ul>
      ) : (
        <p>No blogs available</p>
      )}
    </div>
  );
}

function App() {
  const [showBooks, setShowBooks] = useState(true);

  // Conditional rendering using element variable
  let courseElement = null;
  if (true) {
    courseElement = <CourseDetails courses={courses} />;
  }

  return (
    <div className="container" style={{ display: 'flex', justifyContent: 'space-around', fontFamily: 'sans-serif' }}>
      {courseElement}
      <BookDetails show={showBooks} />
      <BlogDetails blogs={blogs} />
    </div>
  );
}

export default App;
