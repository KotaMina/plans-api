package jp.co.plans.apps.domain.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class Plans implements Serializable {

	private static final long serialVersionUID = 1L;

	public String plansId;

	public String relationId;

	public String userId;

	public String title;

	public String categoryId;

	public int activity;

	public boolean publicFlg;

	public String createdUser;

	public String createdAt;

	public String updatedUser;

	public String updatedAt;

}
