package jp.co.plans.apps.domain.service.menu.component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import jp.co.plans.apps.common.exception.ProcessException;
import jp.co.plans.apps.domain.criteria.MenuCriteria;
import jp.co.plans.apps.domain.mapper.AccountMapper;
import jp.co.plans.apps.domain.mapper.AuthorityMenuMapper;
import jp.co.plans.apps.domain.mapper.MenuMapper;
import jp.co.plans.apps.domain.model.AuthorityMenu;
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

	@Autowired
	private AccountMapper accountMapper;

	@Autowired
	private AuthorityMenuMapper authorityMenuMapper;

	/**
	 * メイン処理。
	 * @return
	 */
	@Transactional(rollbackFor = Exception.class)
	public void execute(MenuCriteria criteria) {

		//権限情報リストの初期化
		List<String> authorityList = new ArrayList<>();

		//引数に権限情報が存在しない場合は、
		if (Objects.isNull(criteria.getAuthority()) || criteria.getAuthority().size() > 0) {
			//権限情報を取得する。
			authorityList = accountMapper.searchAuthority();
		} else {
			//それ以外は、引数の権限情報を格納する。
			authorityList = criteria.getAuthority();
		}

		try {
			//登録を行う。
			menuMapper.insert(toMap(criteria));

			//中間テーブルの登録を行う。
			authorityMenuMapper.insert(toMap(criteria, authorityList));

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

		return menu;
	}

	/**
	 * マッピングする。
	 * @param criteria
	 * @param authorityList
	 * @return
	 */
	private List<AuthorityMenu> toMap(MenuCriteria criteria, List<String> authorityList) {

		List<AuthorityMenu> menuList = new ArrayList<>();
		for (String auth : authorityList) {
			AuthorityMenu authMenu = new AuthorityMenu();
			authMenu.setAuthority(auth);
			authMenu.setMenuId(criteria.getMenuId());

			menuList.add(authMenu);
		}

		return menuList;
	}
}
