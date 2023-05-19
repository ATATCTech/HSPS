package com.atatctech.hsps.verification;

import com.atatctech.arsa.ARSA;
import org.jetbrains.annotations.NotNull;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;

/**
 * Signature utils.
 */
public final class Signature {
    /**
     * Verify a class's signature.
     * @param clz target class
     * @param signature signature to be verified
     * @param publicKey RSA public key
     * @return true if verified; false if failed
     */
    public static boolean verify(@NotNull Class<?> clz, @NotNull String signature, @NotNull ARSA.APublicKey publicKey) {
        try {
            return ARSA.verify(clz.getName(), signature, publicKey);
        } catch (NoSuchAlgorithmException | SignatureException | InvalidKeyException e) {
            return false;
        }
    }

    /**
     * Generate a signature.
     * @param clz target class
     * @param privateKey RSA private key
     * @return generated signature
     */
    public static @NotNull String sign(@NotNull Class<?> clz, @NotNull ARSA.APrivateKey privateKey) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException {
        return ARSA.sign(clz.getName(), privateKey);
    }
}
