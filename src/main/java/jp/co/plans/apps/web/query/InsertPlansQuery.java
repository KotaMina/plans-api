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

	private String plansName;

	private String plansDivision;

	private String time;

}
