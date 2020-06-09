package jp.co.plans.apps.constants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jp.co.plans.apps.domain.mapper.MenuMapper;

/**
 * テーブル名のenumクラス
 * @author kotarominamiyama
 *
 */
@Component
public enum DbTableDivision {

	PLANS_INFO {

		@Autowired
		private MenuMapper menuMapper;

		public MenuMapper getTableName() {
			return menuMapper;
		}
	};

	public abstract Object getTableName();
}
