package jp.co.plans.apps.domain.mapper;

import org.apache.ibatis.annotations.Mapper;

import jp.co.plans.apps.domain.model.Plans;

@Mapper
public interface PlansMapper {

	/**
	 * 登録を行う。
	 * @param plans
	 */
	public void insert(Plans plans);

}
