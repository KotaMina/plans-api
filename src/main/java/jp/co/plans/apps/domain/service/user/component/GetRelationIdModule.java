package jp.co.plans.apps.domain.service.user.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jp.co.plans.apps.common.exception.ProcessException;
import jp.co.plans.apps.common.utils.CommonUtils;
import jp.co.plans.apps.domain.mapper.AccountMapper;

/**
 *
 *	リレーションIDを取得する
 * @author kotarominamiyama
 *
 */
@Component
public class GetRelationIdModule {

	@Autowired
	private AccountMapper accountMapper;

	public String execute(String userId) {

		String relationId = accountMapper.getRelationId(userId);

		//もし検索ができない場合は、
		if (CommonUtils.isEmpty(relationId))
			//「処理できませんでした。」とエラーを表示するようにする。
			throw new ProcessException("処理");

		return relationId;
	}

}
