package com.atatctech.hsps;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public final class ClassLoaderUtils {
    public static @Nullable ClassLoader getClassLoader(@NotNull File file) {
        try {
            return new URLClassLoader(new URL[]{file.toURI().toURL()}, ClassLoader.getSystemClassLoader());
        } catch (MalformedURLException e) {
            return null;
        }
    }
}
