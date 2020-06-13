package jp.co.plans.apps.domain.criteria;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class MenuCriteria implements Serializable {

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
	private String authority;
	/**有効フラグ*/
	private int availableFlg = 0;

	/**メニュ表示権限リスト：管理者権限ごとにメニュー表示を可変したい場合に使用*/
	private List<String> authorityList = new ArrayList<>();
}
