package jp.co.plans.apps.domain.criteria;

import java.io.Serializable;

import lombok.Data;

/**
 * Plansクライテリア
 * @author kotarominamiyama
 *
 */
@Data
public class PlansCriteria implements Serializable {

	private static final long serialVersionUID = 1L;

	/**ユーザーID*/
	private String userId;

	/**権限*/
	private String authority;

	/**タイトル*/
	private String title;

	/**カテゴリーId*/
	private String categroyId;

}
