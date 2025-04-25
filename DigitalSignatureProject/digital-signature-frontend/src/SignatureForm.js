// src/SignatureForm.js
import React, { useState } from 'react';
import axios from 'axios';

const SignatureForm = () => {
    const [message, setMessage] = useState('');
    const [signature, setSignature] = useState('');
    const [verificationStatus, setVerificationStatus] = useState('');

    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            const response = await axios.post('http://localhost:8080/sign', { message });
            setSignature(response.data.signature);
            setVerificationStatus(''); // Clear old status
        } catch (error) {
            console.error('Error signing the message:', error);
        }
    };

    const handleVerify = async () => {
        try {
            const response = await axios.post('http://localhost:8080/verify', { message, signature });
            setVerificationStatus(response.data.verified ? "✅ Verified" : "❌ Not Verified");
        } catch (error) {
            console.error('Error verifying the signature:', error);
        }
    };

    return (
        <div style={{ padding: '20px', maxWidth: '600px', margin: '0 auto', fontFamily: 'Arial, sans-serif' }}>
            <img
                src="/honeywell-logo.png"
                alt="Honeywell Logo"
                style={{ width: '150px', marginBottom: '20px' }}
            />
            <form onSubmit={handleSubmit}>
                <textarea
                    value={message}
                    onChange={(e) => setMessage(e.target.value)}
                    placeholder="Enter your message"
                    required
                    rows="5"
                    style={{ width: '100%', padding: '10px', marginBottom: '10px' }}
                />
                <button type="submit" style={{ padding: '10px 20px' }}>Submit</button>
            </form>

            {signature && (
                <div style={{ marginTop: '20px' }}>
                    <h3>Signature (Base64):</h3>
                    <p style={{ wordBreak: 'break-word' }}>{signature}</p>
                    <button onClick={handleVerify} style={{ padding: '10px 20px', marginTop: '10px' }}>
                        Verify
                    </button>
                </div>
            )}

            {verificationStatus && (
                <div style={{ marginTop: '20px' }}>
                    <h3>Verification Status:</h3>
                    <p>{verificationStatus}</p>
                </div>
            )}
        </div>
    );
};

export default SignatureForm;
