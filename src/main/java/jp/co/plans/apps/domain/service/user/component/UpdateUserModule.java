package jp.co.plans.apps.domain.service.user.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import jp.co.plans.apps.constants.CodeConstants;
import jp.co.plans.apps.domain.criteria.UserCriteria;
import jp.co.plans.apps.domain.mapper.AccountMapper;
import jp.co.plans.apps.domain.model.Account;

/**
 * ユーザー情報を更新する。
 * @author kotarominamiyama
 *
 */
@Component
public class UpdateUserModule {

	@Autowired
	private AccountMapper accountMapper;

	/**
	 * メイン処理
	 * @param criteria
	 * @return
	 */
	@Transactional(rollbackFor = Exception.class)
	public int execute(UserCriteria criteria) {

		int result = CodeConstants.RESULT_OK;

		Account account = UserModuleUtils.toMap(criteria);

		try {
			//更新する。
			accountMapper.update(account);

		} catch (Exception e) {
			//更新失敗の場合は、NGにする。
			result = CodeConstants.RESULT_NG;
		}

		return result;
	}
}
