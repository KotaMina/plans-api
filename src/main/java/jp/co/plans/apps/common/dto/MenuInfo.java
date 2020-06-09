package jp.co.plans.apps.common.dto;

import java.io.Serializable;

import lombok.Data;

/**
 * メニュー情報
 * @author kotarominamiyama
 *
 */
@Data
public class MenuInfo implements Serializable {

	/**メニューID*/
	private String menuId;
	/**メニュー名*/
	private String name;
	/**パス*/
	private String path;
}
