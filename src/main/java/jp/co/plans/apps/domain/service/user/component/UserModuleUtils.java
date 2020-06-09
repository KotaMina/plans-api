package jp.co.plans.apps.domain.service.user.component;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import jp.co.plans.apps.domain.criteria.UserCriteria;
import jp.co.plans.apps.domain.model.Account;

/**
 * 安全なパスワードを生成するクラス。
 * @author kotarominamiyama
 *
 */
public class UserModuleUtils {

	private UserModuleUtils() {
		//コンストラクト禁止
	}

	/** パスワードを安全にするためのアルゴリズム */
	private static final String ALGORITHM = "PBKDF2WithHmacSHA256";
	/** ストレッチング回数 */
	private static final int ITERATION_COUNT = 10000;
	/** 生成される鍵の長さ */
	private static final int KEY_LENGTH = 256;

	/**
	 *　平文のパスワードとソルトから安全なパスワードを生成し、返却します
	 *
	 * @param password 平文のパスワード
	 * @param salt ソルト
	 * @return 安全なパスワード
	 */
	protected static String getSafetyPassword(String password, String salt) {

		char[] passCharAry = password.toCharArray();
		byte[] hashedSalt = getHashedSalt(salt);

		PBEKeySpec keySpec = new PBEKeySpec(passCharAry, hashedSalt, ITERATION_COUNT, KEY_LENGTH);

		SecretKeyFactory skf;
		try {
			skf = SecretKeyFactory.getInstance(ALGORITHM);
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}

		SecretKey secretKey;
		try {
			secretKey = skf.generateSecret(keySpec);
		} catch (InvalidKeySpecException e) {
			throw new RuntimeException(e);
		}
		byte[] passByteAry = secretKey.getEncoded();

		// 生成されたバイト配列を16進数の文字列に変換
		StringBuilder sb = new StringBuilder(64);
		for (byte b : passByteAry) {
			sb.append(String.format("%02x", b & 0xff));
		}
		return sb.toString();
	}

	/**
	 * ソルトをハッシュ化して返却します
	 * ※ハッシュアルゴリズムはSHA-256を使用
	 *
	 * @param salt ソルト
	 * @return ハッシュ化されたバイト配列のソルト
	 */
	private static byte[] getHashedSalt(String salt) {
		MessageDigest messageDigest;
		try {
			messageDigest = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
		messageDigest.update(salt.getBytes());
		return messageDigest.digest();
	}

	/**
	 * マッピングする。
	 * @param criteria
	 * @return
	 */
	protected static Account toMap(UserCriteria criteria) {
		//アカウント情報を取得する。
		Account account = new Account();
		//パスワードをハッシュ化する。
		String safetyPassword = UserModuleUtils.getSafetyPassword(criteria.getPassword(), criteria.getUserId());

		account.setUserId(criteria.getUserId());
		account.setName(criteria.getName());
		account.setJpName(criteria.getJpName());
		account.setPassword(safetyPassword);

		return account;
	}
}
