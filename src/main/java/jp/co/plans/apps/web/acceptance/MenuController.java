package jp.co.plans.apps.web.acceptance;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jp.co.plans.apps.common.dto.MenuInfo;
import jp.co.plans.apps.constants.CodeConstants;
import jp.co.plans.apps.domain.criteria.MenuCriteria;
import jp.co.plans.apps.domain.service.menu.MenuService;
import jp.co.plans.apps.domain.service.user.UserService;
import jp.co.plans.apps.web.query.MenuQuery;
import jp.co.plans.apps.web.resource.MenuResource;

/**
 * メニュー取得コントローラークラス。
 * @author kotarominamiyama
 *
 */
@RestController
@RequestMapping(value = "/request")
public class MenuController {

	@Autowired
	private MenuService menuService;

	@Autowired
	private UserService userService;

	/**
	 * メニューの取得を行う。
	 * @return
	 */
	@RequestMapping(value = "/menu", method = { RequestMethod.GET })
	public ResponseEntity<MenuResource> search(HttpServletRequest request, @RequestBody @Validated MenuQuery query,
			BindingResult bindingResult) {

		//結果初期化
		MenuResource resource = new MenuResource();

		//メニュー情報を取得する。
		List<MenuInfo> menuList = menuService.search(toMap(query));

		//結果を格納する。
		resource.setMenuList(menuList);
		//結果OKとする。
		resource.setResult(CodeConstants.RESULT_OK);

		return ResponseEntity.ok().body(resource);
	}

	/**
	 * メニューの作成を行う。
	 * @return
	 */
	@RequestMapping(value = "/admin/newmenu/", method = { RequestMethod.POST })
	public ResponseEntity<MenuResource> insert(HttpServletRequest request, @RequestBody @Validated MenuQuery query,
			BindingResult bindingResult) {

		//結果初期化
		MenuResource resource = new MenuResource();

		//管理者権限チェックを行う。
		userService.checkAuthority(query.getUserId(), CodeConstants.AUTHORITY_ADMIN);
		//メニュー情報を作成を行う。
		menuService.insert(toMap(query));
		//結果を格納する。
		resource.setResult(CodeConstants.RESULT_OK);

		return ResponseEntity.ok().body(resource);
	}

	/**
	 * マッピングを行う。
	 * @param query
	 * @return
	 */
	private MenuCriteria toMap(MenuQuery query) {

		MenuCriteria criteria = new MenuCriteria();

		criteria.setMenuId(query.getMenuId());
		criteria.setMenuName(query.getMenuName());
		criteria.setPath(query.getPath());
		criteria.setUserId(query.getUserId());
		criteria.setAvailableFlg(query.getAvailableFlg());
		criteria.setAuthority(query.getAuthority());
		criteria.setAuthorityList(query.getAuthorityList());

		return criteria;
	}

}
