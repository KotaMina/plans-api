package jp.co.plans.apps.web.query;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *　プラン作成用クエリ
 * @author kotarominamiyama
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class InsertPlansQuery extends BaseQuery implements Serializable {

	private static final long serialVersionUID = 1L;

	/**プラン名*/
	private String title;

	/**達成度*/
	private int activity;

	/**カテゴリ*/
	private String categoryId;

	/**目的*/
	private String purpose;

}
