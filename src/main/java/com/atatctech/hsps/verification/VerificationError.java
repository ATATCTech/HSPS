package com.atatctech.hsps.verification;

public class VerificationError extends Exception {
    public VerificationError(Class<?> clz) {
        super("Unverified class: " + clz.getName() + ".");
    }

    public VerificationError(String clz) {
        super("Unverified class: " + clz + ".");
    }
}
