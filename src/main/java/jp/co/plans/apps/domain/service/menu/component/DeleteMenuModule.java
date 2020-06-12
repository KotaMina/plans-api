package jp.co.plans.apps.domain.service.menu.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import jp.co.plans.apps.constants.CodeConstants;
import jp.co.plans.apps.domain.criteria.MenuCriteria;
import jp.co.plans.apps.domain.mapper.AuthorityMenuMapper;
import jp.co.plans.apps.domain.mapper.MenuMapper;
import jp.co.plans.apps.domain.service.user.UserService;

/*
 *
 */
@Component
public class DeleteMenuModule {

	@Autowired
	private MenuMapper menuMapper;

	@Autowired
	private AuthorityMenuMapper authorityMenuMapper;

	@Autowired
	private UserService userService;

	/**
	 * メイン処理
	 * @param criteria
	 */
	@Transactional(rollbackFor = Exception.class)
	public void execute(MenuCriteria criteria) {

		//権限チェックを行う。
		userService.checkAuthority(criteria.getUserId(), CodeConstants.AUTHORITY_ADMIN);

	}
}
