package jp.co.plans.apps.domain.service.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.plans.apps.domain.criteria.UserCriteria;
import jp.co.plans.apps.domain.service.user.UserService;
import jp.co.plans.apps.domain.service.user.component.InsertUserModule;
import jp.co.plans.apps.domain.service.user.component.LoginUserModule;
import jp.co.plans.apps.domain.service.user.component.ResetUserInfoModule;
import jp.co.plans.apps.domain.service.user.component.SearchUserModule;
import jp.co.plans.apps.domain.service.user.component.UpdateUserModule;

@Service
public class UserServiceImpl implements UserService {

	/**ログインモジュール*/
	@Autowired
	private LoginUserModule loginModule;

	/**参照モジュール*/
	@Autowired
	private SearchUserModule searchModule;

	/**登録モジュール*/
	@Autowired
	private InsertUserModule insertModule;

	/**登録モジュール*/
	@Autowired
	private UpdateUserModule updateModule;

	/**リセットモジュール*/
	@Autowired
	private ResetUserInfoModule resetModule;

	/**
	 * ログインする。
	 * @param critera
	 * @return
	 */
	public void login(UserCriteria criteria) {
		//ログインを行う。
		loginModule.execute(criteria);
	}

	/**
	 * ユーザー情報を参照する。
	 * @param critera
	 * @return
	 */
	public int search(UserCriteria criteria) {
		//参照結果を返却する。
		return searchModule.execute(criteria);
	}

	/**
	 * 新規ユーザーを登録する。
	 */
	public int insert(UserCriteria criteria) {
		//登録を行う。
		return insertModule.execute(criteria);
	}

	/**
	 * ユーザー情報を更新する。
	 * @param criteria
	 * @return
	 */
	public int update(UserCriteria criteria) {
		//更新を行う。
		return updateModule.execute(criteria);
	}

	/**
	 * ログイン失敗回数をリセットする。
	 * @param criteria
	 * @return
	 */
	public int resetFailedCount(UserCriteria criteria) {
		//カウントを０にする。
		return resetModule.resetCount(criteria);
	}
}
