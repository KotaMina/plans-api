package jp.co.plans.apps.web.query;

import java.io.Serializable;

import lombok.Data;

@Data
public class BaseQuery implements Serializable {
	private static final long serialVersionUID = 1L;

	/**ユーザーID*/
	private String userId;

}
