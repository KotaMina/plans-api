package jp.co.plans.apps.domain.model;

import java.io.Serializable;

import lombok.Data;

/**
 * アカウントモデルクラス
 * @author kotarominamiyama
 *
 */
@Data
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;

	private String userId;
	/**名前*/
	private String name;
	/**和名*/
	private String jpName;
	/**パスワード*/
	private String password;
	/**ホワイトリストフラグ*/
	private int whiteFlg;
	/**ログイン失敗回数*/
	private int failedCount;
	/**ログ*/
	private String log;
	/**作成者*/
	private String createUser;
	/**作成日時*/
	private String createdAt;
	/**更新者*/
	private String updatedUser;
	/**更新日時*/
	private String upadatedAt;
}
