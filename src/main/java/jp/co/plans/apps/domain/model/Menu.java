package jp.co.plans.apps.domain.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class Menu implements Serializable {

	private static final long serialVersionUID = 1L;

	private String menuId;
	private String name;
	private String path;
	private String authority;
	private String availableFlg;
	/**作成者*/
	private String createUser;
	/**作成日時*/
	private String createdAt;
	/**更新者*/
	private String updatedUser;
	/**更新日時*/
	private String upadatedAt;
}
