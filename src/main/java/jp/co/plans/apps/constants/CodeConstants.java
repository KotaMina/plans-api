package jp.co.plans.apps.constants;

/**
 * コードリストクラス。
 *
 * @author kotarominamiyama
 *
 */
public class CodeConstants {

	private CodeConstants() {
		//コンストラクト禁止
	}

	/**実行結果OK : 0*/
	public static final int RESULT_OK = 0;

	/**実行結果NG : 1*/
	public static final int RESULT_NG = 1;

	/**権限コード：管理者*/
	public static final String AUTHORITY_ADMIN = "010";

	/**権限コード：一般*/
	public static final String AUTHORITY_GENERAL = "000";
}
