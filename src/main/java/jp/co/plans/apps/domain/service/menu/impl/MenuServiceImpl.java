package jp.co.plans.apps.domain.service.menu.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.plans.apps.common.dto.MenuInfo;
import jp.co.plans.apps.domain.criteria.MenuCriteria;
import jp.co.plans.apps.domain.service.menu.MenuService;
import jp.co.plans.apps.domain.service.menu.component.InsertMenuModule;
import jp.co.plans.apps.domain.service.menu.component.SearchMenuModule;

/**
 * メニュー取得サービス
 * @author kotarominamiyama
 *
 */
@Service
public class MenuServiceImpl implements MenuService {

	@Autowired
	private SearchMenuModule searchModule;

	@Autowired
	private InsertMenuModule insertModule;

	/**
	 * ユーザー情報を取得する。
	 * @param userId
	 * @return
	 */
	public List<MenuInfo> search(String userId) {
		//検索結果を返却する。
		return searchModule.execute(userId);
	}

	/**
	 * メニュー情報の登録を行う。
	 * @param criteria
	 * @return
	 */
	public void insert(MenuCriteria criteria) {
		//登録処理を行う。
		insertModule.execute(criteria);
	}

	/**
	 * メニュー削除を行う。
	 */
	public void delete(MenuCriteria criteria) {

	}

}
