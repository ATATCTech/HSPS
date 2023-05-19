package com.atatctech.hsps.verification;

import org.jetbrains.annotations.NotNull;

@FunctionalInterface
public interface Verification {
    /**
     * Verify the main class.
     * @param clz the main class
     * @return true if verified; false if failed
     */
    boolean verify(@NotNull Class<?> clz);
}
