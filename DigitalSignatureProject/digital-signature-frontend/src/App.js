import React from 'react';
import './App.css';
import SignatureForm from './SignatureForm'; // Import the SignatureForm component
import logo from './honeywell-logo.png'; // Import the Honeywell logo

function App() {
  return (
    <div className="App">
      <header className="-headApper"><img src={logo} className="App-logo" alt="Honeywell Logo" style={{ width: '150px', marginBottom: '20px' }} /> 
        <h1>Digital Signature Application</h1>
      </header>
      <main>
        <SignatureForm /> {/* Include the SignatureForm component */}
      </main>
    </div>
  );
}

export default App;