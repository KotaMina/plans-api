package jp.co.plans.apps.domain.service.menu;

import java.util.List;

import org.springframework.stereotype.Service;

import jp.co.plans.apps.common.dto.MenuInfo;
import jp.co.plans.apps.domain.criteria.MenuCriteria;

/**
 * メニュー取得サービス
 * @author kotarominamiyama
 *
 */
@Service
public interface MenuService {

	/**
	 * ユーザー情報の権限に紐づいたメニュー情報を取得する。
	 * @param userId
	 * @return
	 */
	public List<MenuInfo> search(String userId);

	/**
	 * メニュー情報の登録を行う。
	 * @param criteria
	 * @return
	 */
	public void insert(MenuCriteria criteria);
}
