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
	/**メニュー名（日本名)*/
	private String jpName;
	/**表示エリア*/
	private String areaType;
	/**パス*/
	private String path;
}
