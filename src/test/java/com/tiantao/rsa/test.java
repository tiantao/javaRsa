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
    public void testEncryptByPrivateKey(){
        String str = "测试加密";
        try {
            String encryptStr = RsaServerUtils.encryptByPrivateKey(str);
            System.out.println(encryptStr);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @Test
    public void testdecryptByPublicKey(){
        String str = "这是一个json";
        try {
            String encryptStr = RsaServerUtils.encryptByPrivateKey(str);
            System.out.println(encryptStr);
            String decryptStr = RsaClientUtils.decryptByPublicKey(encryptStr);
            System.out.println(decryptStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
