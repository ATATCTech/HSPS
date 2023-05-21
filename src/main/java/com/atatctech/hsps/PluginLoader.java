package com.atatctech.hsps;

import com.atatctech.arsa.ARSA;
import com.atatctech.hsps.verification.Signature;
import com.atatctech.hsps.verification.Signed;
import com.atatctech.hsps.verification.Verification;
import com.atatctech.hsps.verification.VerificationError;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.File;

/**
 * Plugin loader class.
 */
public class PluginLoader {
    protected final @NotNull File file;
    protected final @NotNull String mainClass;

    /**
     * Create a plugin loader.
     * @param file target file
     * @param mainClass the entry class, such as `com.example.plugin.Plugin`
     */
    public PluginLoader(@NotNull File file, @NotNull String mainClass) {
        this.file = file;
        this.mainClass = mainClass;
    }

    /**
     * Create a plugin loader.
     * @param path path to target file
     * @param mainClass the entry class, such as `com.example.plugin.Plugin`
     */
    public PluginLoader(@NotNull String path, @NotNull String mainClass) {
        this.file = new File(path);
        this.mainClass = mainClass;
    }

    /**
     * Load plugin.
     * @param verification verification method, set to null to disable verification
     * @return the main class
     * @throws ClassNotFoundException main class not found
     * @throws VerificationError verification failed
     */
    public @Nullable Class<? extends Plugin> load(@Nullable Verification verification) throws ClassNotFoundException, VerificationError {
        ClassLoader classLoader = ClassLoaderUtils.getClassLoader(file);
        if (classLoader == null) return null;
        Class<?> clz = classLoader.loadClass(mainClass);
        if (clz == null) return null;
        if (verification != null && !verification.verify(clz)) throw new VerificationError(clz);
        return Plugin.class.isAssignableFrom(clz) ? clz.asSubclass(Plugin.class) : null;
    }

    /**
     * Load plugin with default verification method, which is RSA signature.
     * @param publicKey RSA public key
     * @return the main class
     * @throws ClassNotFoundException main class not found
     * @throws VerificationError verification failed
     */
    public @Nullable Class<? extends Plugin> load(@NotNull ARSA.APublicKey publicKey) throws ClassNotFoundException, VerificationError {
        return load(clz -> {
            Signed signed = clz.getAnnotation(Signed.class);
            return signed != null && Signature.verify(clz, signed.value(), publicKey);
        });
    }
}
