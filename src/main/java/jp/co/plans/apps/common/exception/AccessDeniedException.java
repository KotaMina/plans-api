package jp.co.plans.apps.common.exception;

/**
 * アクセル拒否例外
 * @author kotarominamiyama
 *
 */
public class AccessDeniedException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public AccessDeniedException() {
		super();
	}

	public AccessDeniedException(Throwable error) {
		super(error);
	}
}
