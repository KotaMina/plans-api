package jp.co.plans.apps.common.exception;

/**
 * 認証例外
 * @author kotarominamiyama
 *
 */
public class AuthException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public AuthException() {
		super();
	}

	public AuthException(Throwable error) {
		super(error);
	}
}
