package jp.co.plans.apps.domain.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import jp.co.plans.apps.domain.model.Account;

/**
 * accountMapper
 * @author kotarominamiyama
 *
 */
@Mapper
public interface AccountMapper {

	/**
	 * ログインを行う。
	 * @param userId
	 * @param password
	 * @return
	 */
	public Integer login(@Param("userId") String userId, @Param("password") String password);

	/**
	 * ログイン失敗回数をカウントアップする。
	 * @param userId
	 */
	public void countUpLoginFailed(@Param("userId") String userId);

	/**
	 * ログイン失敗回数を０にする。
	 * @param userId
	 */
	public void countZeroFailed(@Param("userId") String userId);

	/**
	 * ユーザ情報を取得する。
	 *
	 * @param userId
	 * @param name
	 * @param password
	 * @return
	 */
	public Integer search(@Param("userId") String userId);

	/**
	 * アカウント情報を登録する。
	 * @param account
	 */
	public void insert(Account account);

	/**
	 * アカウント情報を更新する。
	 * @param account
	 */
	public void update(Account account);

	/**
	 * 権限情報を取得する。
	 * @return
	 */
	public List<String> searchAuthority();
}
