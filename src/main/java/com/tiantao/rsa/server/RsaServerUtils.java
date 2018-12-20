package com.tiantao.rsa.server;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;

/**
 * @Author: tiantao
 * @Date: 2018/12/20 6:03 PM
 * @Version 1.0
 */
public class RsaServerUtils {


    /**
     * 非对称密钥算法
     */
    public static final String KEY_ALGORITHM = "RSA";

    /**
     * 私钥
     */
    private static final String PRIVATE_KEY = "MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBAKJ2DAA/hS8Z9kbZMB9LuiiQiP/OW2DS3fPCCryojCzu96Dxo3iRTwThdz4op594nvNwWnkb1jizRXu6GAppkLOi09urCc2Pbiqg1B8uRRd/BlIgYSxEUQ/W2jlvx4WjkhC7w4S3zDhPPhOBlpfKgs+gwtBgui53TtWXF7Ct9l29AgMBAAECgYAgk/d4HUTB2zztnCPwQqlD9Sfj1Cey1NY5SVIJ3uqtIAZ8ObiENu9XlTbqOhDTA8csHf2mh5R/rkNiukCT5fNkH8le8iu60Rt14yUdkck2nG09CVDo/ZS3jax7Ttug2wTapB2Gp/Vw9r3G1FlWRMCi6bwLDlDwASvRoJP6OjHCaQJBAOrZR6R4uHc6OTqY1JOKasHlOLwq5/9bS4oJSS9E0E6Bv4lZ0jomWJM8FB0uerq4CQTU38N09qypJy/ZVZpGsccCQQCxF8iDLwDRzGjMDRJyZC2LYaoxBVP/0Dokw/wlujsG9NuPhZOvKbt/uUT4fKIG+D9f/eXQ0De2KH2Afyr/gXRbAkAsLi4NIezJ+TkU7fVnwC1vRpkSxRuZ7WnbkP2kl9R8QGpxA2XKLLaTFEVQbBMIl2CS+R0TXyicuMG3fbJd8Ji3AkBCYyAPzXcJLw+6LsxThaptLdeXOOAcbfrd/XpwyjeGjBQi4XhTmdloMBPi8xXqdvWLDqswdF3uM4+YtBNyZR0xAkARa3ziY5orI6QTa1KY8wL/71xtkdxgNZXH1GB01DWT/hnxKvc4oZ+hO9qEwV27s8x2WyKIY1Ng2GH9nYU2uP5d";


    /**
     * 私钥加密
     *
     * @param encryptStr 待加密数据
     * @return byte[] 加密数据
     */
    public static String  encryptByPrivateKey(String encryptStr) throws Exception {


        byte[] data = encryptStr.getBytes();
        //取得私钥
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(Base64.decodeBase64(PRIVATE_KEY));
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        //生成私钥
        PrivateKey privateKey = keyFactory.generatePrivate(pkcs8KeySpec);
        //数据加密
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.ENCRYPT_MODE, privateKey);
        return Base64.encodeBase64String(cipher.doFinal(data));
    }

}
