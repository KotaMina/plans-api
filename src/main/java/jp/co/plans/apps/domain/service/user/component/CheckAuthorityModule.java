package jp.co.plans.apps.domain.service.user.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jp.co.plans.apps.common.exception.AuthException;
import jp.co.plans.apps.domain.mapper.AccountMapper;

/**
 * 権限チェックを行う。
 * @author kotarominamiyama
 *
 */
@Component
public class CheckAuthorityModule {

	private final static Logger logger = LoggerFactory.getLogger(LoginUserModule.class);

	@Autowired
	private AccountMapper accountMapper;

	/**
	 * 権限チェックを行う
	 *
	 * @param userId
	 * @param authority
	 */
	public void execute(String userId, String authority) throws AuthException {
		logger.debug("権限チェック開始");

		//権限の存在チェックを行う。
		boolean isExist = accountMapper.isExist(userId, authority);

		//権限が存在しない場合は、
		if (!isExist) {
			//例外処理を行う。
			logger.debug("権限チェックエラー");
			throw new AuthException();
		}

		logger.debug("権限チェック終了");
	}
}
