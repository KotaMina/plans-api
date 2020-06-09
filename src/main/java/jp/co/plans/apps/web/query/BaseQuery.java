package jp.co.plans.apps.web.query;

import java.io.Serializable;

import jp.co.plans.apps.common.dto.AccountInfo;
import lombok.Data;

@Data
public class BaseQuery implements Serializable {
	private static final long serialVersionUID = 1L;

	/**アカウント情報*/
	private AccountInfo accountInfo;

}
