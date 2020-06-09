package jp.co.plans.apps.web.query;

import java.io.Serializable;

import jp.co.plans.apps.validation.MaxLength;
import jp.co.plans.apps.validation.SizeNotNull;
import lombok.Builder;
import lombok.Getter;

/**
 * ユーザクエリ。
 * @author kotarominamiyama
 *
 */
@Getter
@Builder
public class UserQuery implements Serializable {
	private static final long serialVersionUID = 1L;

	@SizeNotNull(params = "ユーザーID")
	@MaxLength(max = 100, params = "ユーザーID")
	private String userId;

	@SizeNotNull(params = "名前")
	@MaxLength(max = 25, params = "名前")
	private String name;

	@MaxLength(max = 25, params = "フリガナ")
	private String jpName;

	@SizeNotNull(params = "パスワード")
	@MaxLength(max = 50, params = "パスワード")
	private String password;

}
