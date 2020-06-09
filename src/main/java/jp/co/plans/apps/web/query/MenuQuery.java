package jp.co.plans.apps.web.query;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * メニュークエリ
 * @author kotarominamiyama
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class MenuQuery extends BaseQuery implements Serializable {

	private static final long serialVersionUID = 1L;

	/**ユーザーID*/
	private String userId;
	/**メニューID*/
	private String menuId;
	/**メニュー名*/
	private String menuName;
	/**パス*/
	private String path;
	/**権限情報*/
	private List<String> authority = new ArrayList<>();
}
