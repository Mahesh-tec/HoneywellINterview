package com.example.demo;

import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.Signature;
import java.util.Base64;
import java.util.Collections;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:3000") // to allow frontend requests
public class DigitalSignatureController {

    private KeyPair keyPair;

    @PostConstruct
    public void init() throws NoSuchAlgorithmException {
        KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
        generator.initialize(2048);
        keyPair = generator.generateKeyPair();
    }

    @PostMapping("/sign")
    public Map<String, String> signMessage(@RequestBody Map<String, String> request) throws Exception {
        String message = request.get("message");
        Signature privateSignature = Signature.getInstance("SHA256withRSA");
        privateSignature.initSign(keyPair.getPrivate());
        privateSignature.update(message.getBytes(StandardCharsets.UTF_8));
        byte[] signature = privateSignature.sign();
        String base64Signature = Base64.getEncoder().encodeToString(signature);
        return Collections.singletonMap("signature", base64Signature);
    }

    @PostMapping("/verify")
    public Map<String, Boolean> verifySignature(@RequestBody Map<String, String> request) throws Exception {
        String message = request.get("message");
        String base64Signature = request.get("signature");
        Signature publicSignature = Signature.getInstance("SHA256withRSA");
        publicSignature.initVerify(keyPair.getPublic());
        publicSignature.update(message.getBytes(StandardCharsets.UTF_8));
        boolean isCorrect = publicSignature.verify(Base64.getDecoder().decode(base64Signature));
        return Collections.singletonMap("verified", isCorrect);
    }
}
