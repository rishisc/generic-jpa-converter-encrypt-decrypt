package com.sunitkatkar.blogspot.converters;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * Utility class to generate an instance of {@link javax.crypto.Cipher}
 * 
 * @author Sunit Katkar, sunitkatkar@gmail.com (https://sunitkatkar.blogspot.com/)
 * @since ver 1.0 (Apr 2018)
 * @version 1.0
 */
public class CipherMaker {

	private static final String CIPHER_INSTANCE_NAME = "AES/CBC/PKCS5Padding";
	private static final String SECRET_KEY_ALGORITHM = "AES";

	/**
	 * @param encryptionMode
	 *            - decides whether to ecrypt or decrypt data. Values accepted:
	 *            {@link Cipher#ENCRYPT_MODE} for encryption and
	 *            {@link Cipher#DECRYPT_MODE} for decryption.
	 * @param key
	 *            - the key to use for encrypting or decrypting data. This can
	 *            be a simple String like "MySecretKey" or a more complex, hard
	 *            to guess longer string
	 * @return
	 * @throws InvalidKeyException
	 * @throws NoSuchPaddingException
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidAlgorithmParameterException
	 * @throws InvalidKeyException
	 * @throws InvalidAlgorithmParameterException
	 */
	public Cipher configureAndGetInstance(int encryptionMode, String key)
			throws InvalidKeyException, NoSuchPaddingException,
			NoSuchAlgorithmException, InvalidAlgorithmParameterException,
			InvalidKeyException, InvalidAlgorithmParameterException {

		Cipher cipher = Cipher.getInstance(CIPHER_INSTANCE_NAME);
		Key secretKey = new SecretKeySpec(key.getBytes(), SECRET_KEY_ALGORITHM);

		byte[] ivBytes = new byte[cipher.getBlockSize()];
		AlgorithmParameterSpec algorithmParameters = new IvParameterSpec(
				ivBytes);

		cipher.init(encryptionMode, secretKey, algorithmParameters);
		return cipher;
	}
}
