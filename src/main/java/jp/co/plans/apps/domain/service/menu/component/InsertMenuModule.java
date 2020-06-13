package jp.co.plans.apps.domain.service.menu.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import jp.co.plans.apps.common.exception.ProcessException;
import jp.co.plans.apps.domain.criteria.MenuCriteria;
import jp.co.plans.apps.domain.mapper.MenuMapper;
import jp.co.plans.apps.domain.model.Menu;

/**
 *メニューの作成を行う。
 * @author kotarominamiyama
 *
 */
@Component
public class InsertMenuModule {

	@Autowired
	private MenuMapper menuMapper;

	/**
	 * メイン処理。
	 * @return
	 */
	@Transactional(rollbackFor = Exception.class)
	public void execute(MenuCriteria criteria) {

		try {
			//登録を行う。
			menuMapper.insert(toMap(criteria));
		} catch (Exception e) {
			throw new ProcessException("メニュー情報登録", e);
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
		menu.setName(criteria.getMenuName());
		menu.setPath(criteria.getPath());
		menu.setAuthority(criteria.getAuthority());
		menu.setAvailableFlg(criteria.getAvailableFlg());

		return menu;
	}
}
