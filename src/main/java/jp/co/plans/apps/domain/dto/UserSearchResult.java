package jp.co.plans.apps.domain.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * ユーザー情報参照結果DTO
 *
 * @author kotarominamiyama
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class UserSearchResult extends BaseResult implements Serializable {

	private static final long serialVersionUID = 1L;

	/**ユーザーID*/
	private String userId;

	/**名前*/
	private String name;
}
