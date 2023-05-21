package com.atatctech.hsps;

import com.atatctech.arsa.ARSA;
import com.atatctech.hsps.verification.Signature;
import com.atatctech.hsps.verification.VerificationError;
import com.atatctech.packages.basics.Basics;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;

public class HSPSTest {
    @Test
    public void sign() throws NoSuchAlgorithmException, SignatureException, InvalidKeyException {
        ARSA.AKeyPair keyPair = ARSA.newKeys(2048);
        Basics.NativeHandler.writeFile("./keys/pri.key", keyPair.getPrivateKey().toString());
        Basics.NativeHandler.writeFile("./keys/pub.pem", keyPair.getPublicKey().toString());
        System.out.println(Signature.sign(TestPlugin.class, keyPair.getPrivateKey()));
    }

    @Test
    public void test() throws IOException, NoSuchAlgorithmException, InvalidKeySpecException, VerificationError, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        PluginLoader pluginLoader = new PluginLoader("./build/libs/testplugin.jar", "com.atatctech.hsps.TestPlugin");
        Class<?> clz = pluginLoader.load(ARSA.APublicKey.importPublicKey(Basics.NativeHandler.readFile("./keys/pub.pem"), 2048));
        if (clz != null) clz.getDeclaredMethod("run").invoke(null);
    }
}
