package jp.co.plans.apps.common.exception;

/**
 * 処理実行例外
 * @author kotarominamiyama
 *
 */
public class ProcessException extends RuntimeException {

	public ProcessException(String message) {
		super(message);
	}

	public ProcessException(String message, Throwable e) {
		super(message, e);
	}
}
