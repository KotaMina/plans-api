package jp.co.plans.apps.web.query;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jp.co.plans.apps.validation.MaxLength;
import jp.co.plans.apps.validation.Numeric;
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

	/**メニューID*/
	@MaxLength(max = 255, params = "メニューID")
	private String menuId;
	/**メニュー名*/
	@MaxLength(max = 255, params = "メニュー名［ENGLISH]")
	private String name;
	/**メニュー名 日本*/
	@MaxLength(max = 255, params = "メニュー名 [JAPANESE]")
	private String jpName;
	/**パス*/
	@MaxLength(max = 255, params = "リンクパス")
	private String path;
	@Numeric(params = "エリアタイプ")
	private String areaType;
	/**有効フラグ*/
	@Numeric(params = "権限フラグ")
	private String availableFlg;
	/**登録時の権限情報*/
	@MaxLength(max = 3, params = "権限")
	private String authority;
	/**メニュ表示権限リスト*/
	private List<String> authorityList = new ArrayList<>();
}
