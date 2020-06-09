package jp.co.plans.apps.domain.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import jp.co.plans.apps.domain.model.AuthorityMenu;

/**
 * authority_menu マッパークラス。
 * @author kotarominamiyama
 *
 */
@Mapper
public interface AuthorityMenuMapper {

	/**
	 * 登録を行う。
	 * @param menuList
	 */
	public void insert(List<AuthorityMenu> menuList);
}
