package jp.co.plans.apps.domain.criteria;

import java.io.Serializable;

import lombok.Data;

/**
 * ユーザークライテリアクラス。
 * @author kotarominamiyama
 *
 */
@Data
public class UserCriteria implements Serializable {

	private static final long serialVersionUID = 1L;
	/**ユーザーID*/
	private String userId;
	/**名前*/
	private String name;
	/**フリガナ*/
	private String jpName;
	/**パスワード*/
	private String password;
}
