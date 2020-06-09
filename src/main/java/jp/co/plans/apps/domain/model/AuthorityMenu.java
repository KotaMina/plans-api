package jp.co.plans.apps.domain.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class AuthorityMenu implements Serializable {
	private static final long serialVersionUID = 1L;

	private String authority;
	private String menuId;

}
