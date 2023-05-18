package com.atatctech.hsps.verification;

import org.jetbrains.annotations.NotNull;

@FunctionalInterface
public interface Verification {
    boolean verify(@NotNull Class<?> clz);
}
