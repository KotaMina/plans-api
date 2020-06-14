package jp.co.plans.apps.common.utils;

import java.util.Objects;

import org.springframework.util.StringUtils;

import jp.co.plans.apps.common.dto.ErrorInfo;

/**
 * 共通処理
 * @author kotarominamiyama
 *
 */
public class CommonUtils {

	private CommonUtils() {
		//コンストラクタ禁止
	}

	/**
	 * エラーオブジェクト生成
	 * @param errorId
	 * @param errorMessage
	 * @return
	 */
	public static ErrorInfo error(String errorId, String errorMessage) {
		ErrorInfo errorInfo = new ErrorInfo();
		errorInfo.setErrorId(errorId);
		errorInfo.setMessage(errorMessage);

		return errorInfo;
	}

	/**
	 * 空の場合は、True
	 * @param src
	 * @return
	 */
	public static boolean isEmpty(String src) {
		return Objects.isNull(src) || StringUtils.isEmpty(src);
	}

	/**
	 * 数字かどうかを判定する。
	 * @param src
	 * @return
	 */
	public static boolean isNumeric(String src) {
		if (isEmpty(src)) {
			return true;
		}

		try {
			Integer.parseInt(src);
		} catch (Exception e) {
			return false;
		}

		return true;
	}
}
