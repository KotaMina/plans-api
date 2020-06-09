package jp.co.plans.apps.domain.service.user;

import org.springframework.stereotype.Service;

import jp.co.plans.apps.domain.criteria.UserCriteria;

/**
 *ユーザーサービスクラス
 * @author kotarominamiyama
 *
 */
@Service
public interface UserService {

	/**
	 * ログインする。
	 * @param critera
	 * @return
	 */
	public void login(UserCriteria criteria);

	/**
	 * ユーザー情報を参照する。
	 * @param critera
	 * @return
	 */
	public int search(UserCriteria criteria);

	/**
	 * 新規ユーザーを作成する。
	 * @param criteria
	 */
	public int insert(UserCriteria criteria);

	/**
	 * ユーザー情報を更新する。
	 * @param criteria
	 * @return
	 */
	public int update(UserCriteria criteria);

	/**
	 * ログイン失敗回数をリセットする。
	 * @param criteria
	 * @return
	 */
	public int resetFailedCount(UserCriteria criteria);
}
