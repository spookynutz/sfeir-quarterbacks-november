package com.sfeir.quarterbacks.eddsa;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.spec.EdECPoint;
import java.security.spec.EdECPublicKeySpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.NamedParameterSpec;
import java.util.Base64;

public class EdwardsCurveDigitalSignatureAlgorithmTest {

    @Test
    void lets_test_out_encoding_with_the_EdDSA_algorithm() throws NoSuchAlgorithmException, SignatureException, InvalidKeyException {

        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("EdDSA");
        KeyPair keyPair = keyPairGenerator.generateKeyPair();

        byte[] message = "you guys rock !".getBytes(StandardCharsets.UTF_8);

        Signature signature = Signature.getInstance("EdDSA");
        signature.initSign(keyPair.getPrivate());
        signature.update(message);

        byte[] signedMessage = signature.sign();

        System.out.println(Base64.getEncoder().encodeToString(signedMessage));
    }

    @Test
    void lets_test_out_creating_a_public_key() throws NoSuchAlgorithmException, InvalidKeySpecException {
        KeyFactory keyFactory = KeyFactory.getInstance("EdDSA");
        NamedParameterSpec parameterSpec = new NamedParameterSpec("EdDSA");

        EdECPublicKeySpec publicKeySpec = new EdECPublicKeySpec(parameterSpec, new EdECPoint(true, BigInteger.ONE));
        PublicKey publicKey = keyFactory.generatePublic(publicKeySpec);
    }

}
