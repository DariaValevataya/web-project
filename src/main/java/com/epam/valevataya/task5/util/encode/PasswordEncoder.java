package com.epam.valevataya.task5.util.encode;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordEncoder {
  public static final Logger logger = LogManager.getLogger();
  private static MessageDigest messageDigest;

  static {
    try {
      messageDigest = MessageDigest.getInstance("SHA-1");
    } catch (NoSuchAlgorithmException e) {
      logger.warn("Error");
      throw new RuntimeException(e);
    }
  }

  public String encode(String password) {
    try {
      messageDigest.update(password.getBytes("utf8"));
    } catch (UnsupportedEncodingException e) {
      throw new RuntimeException(e);
    }
    byte[] bytesEncoded=messageDigest.digest();;
    BigInteger bigInt = new BigInteger(1, bytesEncoded);
    String resHex = bigInt.toString(16);
    return resHex;
  }
}
