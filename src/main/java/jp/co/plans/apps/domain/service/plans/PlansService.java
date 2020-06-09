package jp.co.plans.apps.domain.service.plans;

import org.springframework.stereotype.Service;

import jp.co.plans.apps.domain.criteria.PlansCriteria;

/**
 * Plansサービスクラス
 *
 * @author kotarominamiyama
 *
 */
@Service
public interface PlansService {

	/**
	 * plans_infoテーブルへの登録を行う。
	 * 成功した場合は、plans_idが返却される。
	 * @param criteria
	 * @return
	 */
	public String insertPlansInfo(PlansCriteria criteria);
}
