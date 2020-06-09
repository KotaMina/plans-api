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

	private String plansName;

	private String plansDivision;

	private String time;

	private String timeDivision;

}
