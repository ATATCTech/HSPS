package com.atatctech.hsps;

import com.atatctech.arsa.ARSA;
import com.atatctech.hsps.verification.Signature;
import com.atatctech.hsps.verification.Signed;
import com.atatctech.hsps.verification.Verification;
import com.atatctech.hsps.verification.VerificationError;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.File;

public class Plugin {
    protected final @NotNull File file;
    protected final @NotNull String mainClass;

    public Plugin(@NotNull File file, @NotNull String mainClass) {
        this.file = file;
        this.mainClass = mainClass;
    }

    public Plugin(@NotNull String path, @NotNull String mainClass) {
        this.file = new File(path);
        this.mainClass = mainClass;
    }

    public @Nullable Class<?> load(@Nullable Verification verification) throws ClassNotFoundException, VerificationError {
        ClassLoader classLoader = ClassLoaderUtils.getClassLoader(file);
        if (classLoader == null) return null;
        Class<?> clz = classLoader.loadClass(mainClass);
        if (clz == null) return null;
        if (verification != null && !verification.verify(clz)) throw new VerificationError(clz);
        return clz;
    }

    public @Nullable Class<?> load(@NotNull ARSA.APublicKey publicKey) throws VerificationError, ClassNotFoundException {
        return load(clz -> {
            Signed signed = clz.getAnnotation(Signed.class);
            return signed != null && Signature.verify(clz, signed.value(), publicKey);
        });
    }
}
