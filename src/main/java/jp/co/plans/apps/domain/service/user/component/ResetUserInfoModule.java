package jp.co.plans.apps.domain.service.user.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jp.co.plans.apps.constants.CodeConstants;
import jp.co.plans.apps.domain.criteria.UserCriteria;
import jp.co.plans.apps.domain.mapper.AccountMapper;

/**
 * ユーザー情報をリセットする。
 * @author kotarominamiyama
 *
 */
@Component
public class ResetUserInfoModule {

	@Autowired
	private AccountMapper accountMapper;

	/**
	 * ログイン失敗回数を０にする。
	 * @return
	 */
	public int resetCount(UserCriteria criteria) {

		try {
			//カウントをリセットする。
			accountMapper.countZeroFailed(criteria.getUserId());

		} catch (Exception e) {
			return CodeConstants.RESULT_NG;
		}
		return CodeConstants.RESULT_OK;
	}
}
