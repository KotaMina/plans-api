package jp.co.plans.apps.domain.service.user.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import jp.co.plans.apps.constants.CodeConstants;
import jp.co.plans.apps.domain.criteria.UserCriteria;
import jp.co.plans.apps.domain.mapper.AccountMapper;
import jp.co.plans.apps.domain.model.Account;

/**
 * 新規ユーザー作成モジュール
 * @author kotarominamiyama
 *
 */
@Component
public class InsertUserModule {

	@Autowired
	private AccountMapper accountMapper;

	/**
	 * メイン処理
	 */
	@Transactional(rollbackFor = Exception.class)
	public int execute(UserCriteria criteria) {

		//結果初期化
		int result = CodeConstants.RESULT_OK;

		//アカウントの存在確認を行う。
		int accountCnt = accountMapper.search(criteria.getUserId());

		//検索結果が存在しない場合は、
		if (accountCnt == 0) {

			//マッピングする。
			Account account = UserModuleUtils.toMap(criteria);

			//登録を行う。
			accountMapper.insert(account);
		} else {
			//それ以外は、結果NGとする。
			result = CodeConstants.RESULT_NG;
		}

		return result;

	}

}
