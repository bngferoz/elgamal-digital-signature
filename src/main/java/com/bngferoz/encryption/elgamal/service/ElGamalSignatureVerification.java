package com.bngferoz.encryption.elgamal.service;

import java.math.BigInteger;

public class ElGamalSignatureVerification {
    public static boolean verify(BigInteger message, BigInteger r, BigInteger s, BigInteger p, BigInteger g, BigInteger y) {
        if (r.compareTo(BigInteger.ONE) <= 0 || r.compareTo(p.subtract(BigInteger.ONE)) >= 0) {
            return false;
        }
        if (s.compareTo(BigInteger.ONE) <= 0 || s.compareTo(p.subtract(BigInteger.ONE)) >= 0) {
            return false;
        }

        // Calculate v1 = (y^r * r^s) mod p
        BigInteger v1 = y.modPow(r, p).multiply(r.modPow(s, p)).mod(p);

        // Calculate v2 = g^message mod p
        BigInteger v2 = g.modPow(message, p);

        return v1.equals(v2);
    }
}

