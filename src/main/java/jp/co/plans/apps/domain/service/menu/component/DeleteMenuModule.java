package jp.co.plans.apps.domain.service.menu.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import jp.co.plans.apps.common.exception.ProcessException;
import jp.co.plans.apps.domain.criteria.MenuCriteria;
import jp.co.plans.apps.domain.mapper.MenuMapper;
import jp.co.plans.apps.domain.model.Menu;

/*
 *
 */
@Component
public class DeleteMenuModule {

	@Autowired
	private MenuMapper menuMapper;

	/**
	 * メイン処理
	 * @param criteria
	 */
	@Transactional(rollbackFor = Exception.class)
	public void execute(MenuCriteria criteria) {

		try {
			//メニューを削除する。
			menuMapper.delete(toMap(criteria));

		} catch (Exception e) {
			throw new ProcessException("メニュー情報削除", e);
		}
	}

	/**
	 * マッピングする。
	 * @param criteria
	 * @return
	 */
	private Menu toMap(MenuCriteria criteria) {

		Menu menu = new Menu();

		menu.setMenuId(criteria.getMenuId());
		menu.setName(criteria.getName());
		menu.setJpName(criteria.getJpName());
		menu.setPath(criteria.getPath());
		menu.setAuthority(criteria.getAuthority());
		menu.setAvailableFlg(criteria.getAvailableFlg());

		return menu;
	}
}
