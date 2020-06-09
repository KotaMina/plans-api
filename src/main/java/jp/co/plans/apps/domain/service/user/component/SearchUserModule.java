package jp.co.plans.apps.domain.service.user.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jp.co.plans.apps.constants.CodeConstants;
import jp.co.plans.apps.domain.criteria.UserCriteria;
import jp.co.plans.apps.domain.mapper.AccountMapper;

/**
 * ユーザー情報を参照するモジュールクラス。
 * @author kotarominamiyama
 *
 */
@Component
public class SearchUserModule {

	@Autowired
	private AccountMapper accountMapper;

	/**
	 * メイン実行
	 * @param criteria
	 * @return
	 */
	public int execute(UserCriteria criteria) {

		int result = CodeConstants.RESULT_OK;

		//アカウントが存在しない場合は、
		if (accountMapper.search(criteria.getUserId()) == 0)
			//結果NG
			result = CodeConstants.RESULT_NG;

		return result;
	}

}
