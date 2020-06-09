package jp.co.plans.apps.domain.service.user.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jp.co.plans.apps.common.exception.AuthException;
import jp.co.plans.apps.domain.criteria.UserCriteria;
import jp.co.plans.apps.domain.mapper.AccountMapper;

/**
 * ログインを行う。
 * @author kotarominamiyama
 *
 */
@Component
public class LoginUserModule {

	private final static Logger logger = LoggerFactory.getLogger(LoginUserModule.class);

	@Autowired
	private AccountMapper accountMapper;

	public void execute(UserCriteria criteria) {
		logger.debug("ログイン処理開始 LoginUserModule:exeute");

		//パスワードをハッシュ化する。
		String safetyPassword = UserModuleUtils.getSafetyPassword(criteria.getPassword(), criteria.getUserId());

		//ログインを行う。
		int loginResult = accountMapper.login(criteria.getUserId(), safetyPassword);

		//ログインが失敗した場合は、
		if (loginResult == 0) {
			//ログイン失敗回数をカウントアップする。
			accountMapper.countUpLoginFailed(criteria.getUserId());
			//例外を投げる
			throw new AuthException();
		}
	}
}
