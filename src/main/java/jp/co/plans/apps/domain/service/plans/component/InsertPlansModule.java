package jp.co.plans.apps.domain.service.plans.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jp.co.plans.apps.domain.criteria.PlansCriteria;
import jp.co.plans.apps.domain.mapper.PlansMapper;
import jp.co.plans.apps.domain.model.Plans;
import jp.co.plans.apps.domain.service.user.UserService;

/**
 * plans登録用モジュール
 * @author kotarominamiyama
 *
 */
@Component
public class InsertPlansModule {

	//ユーザーサービス。
	@Autowired
	private UserService userService;

	@Autowired
	private PlansMapper plansMapper;

	/**
	 *Plansの登録を行う。
	 *
	 * @param criteria
	 * @param tableDivsion
	 * @return
	 */
	public String insert(PlansCriteria criteria) {

		//権限チェックを行う。
		userService.checkAuthority(criteria.getUserId(), criteria.getAuthority());

		//プランの登録を行う。
		plansMapper.insert(toMap(criteria));

		return "plans_id";
	}

	/**
	 * マッピングをする。
	 * @param criteria
	 * @return
	 */
	public Plans toMap(PlansCriteria criteria) {

		Plans plans = new Plans();

		//relationIdを取得する。
		String relationId = userService.getRelationId(criteria.getUserId());

		plans.setRelationId(relationId);

		plans.setRelationId(criteria.getUserId());

		plans.setTitle(criteria.getTitle());

		plans.setActivity(0);

		plans.setCategoryId(criteria.getCategroyId());

		return plans;
	}

}
