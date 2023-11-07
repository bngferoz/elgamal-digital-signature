package com.bngferoz.encryption.elgamal.service;
import java.math.BigInteger;
import java.security.SecureRandom;


public class ElGamalKeyPair {
    private BigInteger p;  // Large prime number
    private BigInteger g;  // Generator
    private BigInteger x;  // Private key
    private BigInteger y;  // Public key

    public ElGamalKeyPair(BigInteger p, BigInteger g) {
        this.p = p;
        this.g = g;
        generateKeys();
    }

    private void generateKeys() {
        SecureRandom random = new SecureRandom();
        x = new BigInteger(p.bitLength() - 1, random);
        y = g.modPow(x, p);
    }

    public BigInteger getP() {
        return p;
    }

    public BigInteger getG() {
        return g;
    }

    public BigInteger getX() {
        return x;
    }

    public BigInteger getY() {
        return y;
    }
}
