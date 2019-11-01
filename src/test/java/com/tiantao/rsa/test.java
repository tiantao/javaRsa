package com.tiantao.rsa;

import com.tiantao.rsa.client.RsaClientUtils;
import com.tiantao.rsa.server.RsaServerUtils;
import org.junit.Test;

/**
 * @Author: tiantao
 * @Date: 2018/12/20 6:09 PM
 * @Version 1.0
 */
public class test {

    @Test
    public void testEncryptByPrivateKey() {
        String str = "test encrypt";
        try {
            String encryptStr = RsaServerUtils.encryptByPrivateKey(str);
            System.out.println(encryptStr);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @Test
    public void testdecryptByPublicKey() {
        String str = "this is json";
        try {
            String encryptStr = RsaServerUtils.encryptByPrivateKey(str);
            //String encryptStr = RsaClientUtils.encryptByPublicKey(str);
            System.out.println(encryptStr);
            String decryptStr = RsaClientUtils.decryptByPublicKey(encryptStr);
            System.out.println(decryptStr);
            assert str.equals(decryptStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testencryptByPublicKey() {
        String str = "{" +
                "    \"password\":\"1a@12345\"," +
                "    \"userName\":\"tiantaoc\"," +
                "    \"timestamp\":\"1235124453\"" +
                "}";
        System.out.println(System.currentTimeMillis());
        try {
            String encryptStr = RsaClientUtils.encryptByPublicKey(str);
            System.out.println(encryptStr);

            String decryptStr = RsaServerUtils.decryptByPrivateKey(encryptStr);
            System.out.println(decryptStr);
            assert str.equals(decryptStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
