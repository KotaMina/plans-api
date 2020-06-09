package jp.co.plans.apps.domain.service.plans.impl;

import org.springframework.stereotype.Service;

import jp.co.plans.apps.domain.criteria.PlansCriteria;
import jp.co.plans.apps.domain.service.plans.PlansService;

/**
 * Plansサービスクラス
 * @author kotarominamiyama
 *
 */
@Service
public class PlansServiceImpl implements PlansService {

	/**
	 * plans_infoテーブルへの登録を行う。
	 * 成功した場合は、plans_idが返却される。
	 * @param criteria
	 * @return
	 */
	public String insertPlansInfo(PlansCriteria criteria) {
		return "plans_id";
	}
}
