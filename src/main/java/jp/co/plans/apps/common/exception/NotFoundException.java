package jp.co.plans.apps.common.exception;

/**
 * 検索結果なし例外
 * @author kotarominamiyama
 *
 */
public class NotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public NotFoundException(String itemName) {
		super(itemName);
	}

	public NotFoundException(String itemName, Throwable error) {
		super(itemName, error);
	}
}
