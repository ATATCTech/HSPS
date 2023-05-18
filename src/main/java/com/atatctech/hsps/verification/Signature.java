package com.atatctech.hsps.verification;

import com.atatctech.arsa.ARSA;
import org.jetbrains.annotations.NotNull;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;

public class Signature {
    public static boolean verify(@NotNull Class<?> clz, @NotNull String signature, @NotNull ARSA.APublicKey publicKey) {
        try {
            return ARSA.verify(clz.getName(), signature, publicKey);
        } catch (NoSuchAlgorithmException | SignatureException | InvalidKeyException e) {
            return false;
        }
    }

    public static @NotNull String sign(@NotNull Class<?> clz, @NotNull ARSA.APrivateKey privateKey) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException {
        return ARSA.sign(clz.getName(), privateKey);
    }
}
