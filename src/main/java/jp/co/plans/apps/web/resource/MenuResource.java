package jp.co.plans.apps.web.resource;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import jp.co.plans.apps.common.dto.MenuInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * メニュー取得結果クラス。
 * @author kotarominamiyama
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class MenuResource extends BaseResource implements Serializable {
	private static final long serialVersionUID = 1L;

	/**メニューリスト*/
	List<MenuInfo> menuList = new ArrayList<>();

}
