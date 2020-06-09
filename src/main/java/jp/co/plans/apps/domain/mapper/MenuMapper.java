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
	 * @return	 */
	public List<Menu> search(@Param("userId") String userId);

	/**
	 * メニュー情報を登録する。
	 */
	public void insert(Menu menu);
}
