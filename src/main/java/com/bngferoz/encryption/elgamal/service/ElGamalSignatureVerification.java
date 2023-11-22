package com.bngferoz.encryption.elgamal.service;

import java.math.BigInteger;

public class ElGamalSignatureVerification {
    public static boolean verify(BigInteger message, BigInteger S1, BigInteger S2, BigInteger q, BigInteger a, BigInteger publicKey) {
        if (S1.compareTo(BigInteger.ONE) <= 0 || S1.compareTo(q.subtract(BigInteger.ONE)) >= 0) {
            return false;
        }
        if (S2.compareTo(BigInteger.ONE) <= 0 || S2.compareTo(q.subtract(BigInteger.ONE)) >= 0) {
            return false;
        }


        BigInteger v1 = a.modPow(message, q);
        BigInteger v2 = publicKey.modPow(S1, q).multiply(S1.modPow(S2, q)).mod(q);

        return v1.equals(v2);
    }
}

