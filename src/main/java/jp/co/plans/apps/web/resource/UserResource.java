package jp.co.plans.apps.web.resource;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

import jp.co.plans.apps.common.dto.AccountInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * ユーザー結果クラス
 * @author kotarominamiyama
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class UserResource extends BaseResource implements Serializable {
	private static final long serialVersionUID = 1L;

	/**セッション時間*/
	private int intervalTime;

	/**アカウント情報*/
	private AccountInfo accountInfo;

}
