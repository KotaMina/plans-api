package jp.co.plans.apps.domain.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class Menu implements Serializable {

	private static final long serialVersionUID = 1L;

	/**メニューID*/
	private String menuId;
	/**メニュー名*/
	private String name;
	/**メニュー名：和名*/
	private String jpName;
	/**リンクパス*/
	private String path;
	/**権限情報*/
	private String authority;
	/**有効フラグ 0:有効　1:無効*/
	private int availableFlg = 0;
	/**作成者*/
	private String createUser;
	/**作成日時*/
	private String createdAt;
	/**更新者*/
	private String updatedUser;
	/**更新日時*/
	private String upadatedAt;
}
