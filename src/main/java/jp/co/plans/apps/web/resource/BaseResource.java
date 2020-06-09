package jp.co.plans.apps.web.resource;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import jp.co.plans.apps.common.dto.ErrorInfo;
import lombok.Data;

/**
 * リソース基底クラス
 * @author kotarominamiyama
 *
 */
@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class BaseResource implements Serializable {
	private static final long serialVersionUID = 1L;

	/**結果 0:OK　1:NG*/
	private int result;

	/**エラー情報*/
	private List<ErrorInfo> errorList;
}
