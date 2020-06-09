package jp.co.plans.apps.common.utils;

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
	 * 時間を判定して、区分値を返却する。
	 * @param time
	 * @return
	 */
	public static String chkTimeDiv(String time) {
		//初期化
		String timeDivision = null;

		try {

		} catch (Exception e) {
			//測定不明
			timeDivision = "0";
		}

		return timeDivision;
	}
}
