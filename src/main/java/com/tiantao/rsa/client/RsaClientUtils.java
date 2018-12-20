package com.tiantao.rsa.client;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;

/**
 * @Author: tiantao
 * @Date: 2018/12/20 6:02 PM
 * @Version 1.0
 * 用于客户端进行解密
 */
public class RsaClientUtils {

    /**
     * 非对称密钥算法
     */
    public static final String KEY_ALGORITHM = "RSA";

    /**
     * 公钥
     */
    private static final String PUBLIC_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCidgwAP4UvGfZG2TAfS7ookIj/zltg0t3zwgq8qIws7veg8aN4kU8E4Xc+KKefeJ7zcFp5G9Y4s0V7uhgKaZCzotPbqwnNj24qoNQfLkUXfwZSIGEsRFEP1to5b8eFo5IQu8OEt8w4Tz4TgZaXyoLPoMLQYLoud07VlxewrfZdvQIDAQAB";


    /**
     * 公钥解密
     *
     * @param decryptStr 待解密数据
     * @return byte[] 解密数据
     */
    public static String decryptByPublicKey(String decryptStr) throws Exception {

        byte[] data = Base64.decodeBase64(decryptStr);

        //实例化密钥工厂
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        //初始化公钥
        //密钥材料转换
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(Base64.decodeBase64(PUBLIC_KEY));
        //产生公钥
        PublicKey pubKey = keyFactory.generatePublic(x509KeySpec);
        //数据解密
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE, pubKey);
        return new String(cipher.doFinal(data));
    }
}
