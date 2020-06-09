package jp.co.plans.apps.common.dto;

import java.io.Serializable;

import lombok.Data;

/**
 * エラー情報
 * @author kotarominamiyama
 *
 */
@Data
public class ErrorInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	public ErrorInfo() {
		super();
	}

	public ErrorInfo(String errorId, String message) {
		this.errorId = errorId;
		this.message = message;
	}

	public ErrorInfo(String message) {
		this.message = message;
	}

	/**エラーID*/
	private String errorId;
	/**エラーメッセージ*/
	private String message;

}
