package com.bngferoz.encryption.elgamal.service;

import java.math.BigInteger;

import java.security.*;

public class ElGamalSignature {
	public static String[] sign(BigInteger message, BigInteger p, BigInteger g, BigInteger x) {
        SecureRandom random = new SecureRandom();
        BigInteger k = new BigInteger(p.bitLength() - 1, random);

        // Calculate r = g^k mod p
        BigInteger r = g.modPow(k, p);

        // Calculate k^-1 mod (p-1)
        BigInteger kInverse = k.modInverse(p.subtract(BigInteger.ONE));

        // Calculate s = (message - x*r) * k^-1 mod (p-1)
        BigInteger s = (message.subtract(x.multiply(r))).multiply(kInverse).mod(p.subtract(BigInteger.ONE));

        return new String[]{r.toString(), s.toString()};
    }

}
