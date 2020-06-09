package jp.co.plans.apps.domain.service.plans.component;

import org.springframework.stereotype.Component;

import jp.co.plans.apps.domain.criteria.PlansCriteria;

/**
 * plans登録用モジュール
 * @author kotarominamiyama
 *
 */
@Component
public class InsertPlansModule {

	/**
	 *Plansの登録を行う。
	 *
	 * @param criteria
	 * @param tableDivsion
	 * @return
	 */
	public String insert(PlansCriteria criteria, int tableDivsion) {

		return "plans_id";
	}

}
