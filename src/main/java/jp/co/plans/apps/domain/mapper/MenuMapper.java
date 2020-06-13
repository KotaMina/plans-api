package jp.co.plans.apps.domain.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import jp.co.plans.apps.domain.model.Menu;

/**
 * メニューマッパー。
 * @author kotarominamiyama
 *
 */
@Mapper
public interface MenuMapper {

	/**
	 * メニュー情報を取得する。
	 * @param userId
	 * @Param authorityList
	 * @return	 */
	public List<Menu> search(@Param("userId") String userId, @Param("authorityList") List<String> authorityList);

	/**
	 * メニュー情報を登録する。
	 */
	public void insert(Menu menu);

	/**
	 * メニュー情報を削除する。
	 */
	public void delete(Menu menu);
}
