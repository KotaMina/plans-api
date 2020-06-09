package jp.co.plans.apps.common.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class AccountInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	/**ユーザーID*/
	private String userId;
	/**ユーザー名*/
	private String uesrName;
	/**フリガナ*/
	private String jpName;
}
