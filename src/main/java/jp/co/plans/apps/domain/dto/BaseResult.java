package jp.co.plans.apps.domain.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

/**
 * 実行結果BASEDTO
 *
 * @author kotarominamiyama
 *
 */
@Data
public class BaseResult implements Serializable {

	private static final long serialVersionUID = 1L;

	/**実行結果*/
	int result;

	/**エラー情報 */
	List<Error> error = new ArrayList<>();

}
