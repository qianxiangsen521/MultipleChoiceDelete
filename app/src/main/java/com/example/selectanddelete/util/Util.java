package com.example.selectanddelete.util;

import android.text.TextUtils;


import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by qianxiangsen on 2017/10/12.
 */

public class Util {

    public static String md5(String string) {
        byte[] hash;
        try {
            hash = MessageDigest.getInstance("MD5").digest(string.getBytes("UTF-8"));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Huh, MD5 should be supported?", e);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Huh, UTF-8 should be supported?", e);
        }

        StringBuilder hex = new StringBuilder(hash.length * 2);
        for (byte b : hash) {
            if ((b & 0xFF) < 0x10) hex.append("0");
            hex.append(Integer.toHexString(b & 0xFF));
        }
        return hex.toString();
    }

    public static String onLineText(String lineID){
        if (TextUtils.isEmpty(lineID)){
            return "";
        }
        else if (lineID.equals("3")){
            return "";
        }else if (lineID.equals("0")){
            return "上线";
        }else if (lineID.equals("1")){

            return "下线";
        }
        return "";
    }

}
