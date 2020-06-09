package jp.co.plans.apps.domain.service.menu.component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jp.co.plans.apps.common.dto.MenuInfo;
import jp.co.plans.apps.common.exception.ProcessException;
import jp.co.plans.apps.domain.mapper.MenuMapper;
import jp.co.plans.apps.domain.model.Menu;

/**
 * メニュー情報を取得する。
 * @author kotarominamiyama
 *
 */
@Component
public class SearchMenuModule {

	@Autowired
	private MenuMapper menuMapper;

	/**
	 * メイン処理。
	 * @param userId
	 * @return
	 */
	public List<MenuInfo> execute(String userId) {
		List<MenuInfo> result = new ArrayList<>();

		//メニュー情報を取得する。
		List<Menu> menuList = menuMapper.search(userId);

		//取得できない場合は、例外発生。
		if (Objects.isNull(menuList) || menuList.size() == 0) {
			throw new ProcessException("メニュー取得");
		}

		//結果に格納する。
		for (Menu menu : menuList) {
			MenuInfo info = new MenuInfo();
			info.setMenuId(menu.getMenuId());
			info.setName(menu.getName());
			info.setPath(menu.getPath());
			result.add(info);
		}

		return result;
	}
}
