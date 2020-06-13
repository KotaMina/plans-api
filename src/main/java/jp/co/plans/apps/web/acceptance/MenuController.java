package jp.co.plans.apps.web.acceptance;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jp.co.plans.apps.common.dto.MenuInfo;
import jp.co.plans.apps.common.utils.ValidationUtils;
import jp.co.plans.apps.constants.CodeConstants;
import jp.co.plans.apps.domain.criteria.MenuCriteria;
import jp.co.plans.apps.domain.service.menu.MenuService;
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

	private final static Logger logger = LoggerFactory.getLogger(MenuController.class);

	@Autowired
	private MenuService menuService;

	@Autowired
	private ValidationUtils validationUtils;

	/**
	 * メニューの取得を行う。
	 * @return
	 */
	@RequestMapping(value = "/menu", method = { RequestMethod.POST })
	@CrossOrigin(origins = { "http://localhost:3000" })
	public ResponseEntity<MenuResource> search(HttpServletRequest request, @RequestBody @Validated MenuQuery query,
			BindingResult bindingResult) {

		logger.debug("メニュー取得処理開始 => {}", query);

		//結果初期化
		MenuResource resource = new MenuResource();

		//エラーが発生した場合は、エラーを格納する。
		if (bindingResult.hasErrors()) {
			resource.setErrorList(validationUtils.setValidationErrors(bindingResult));
			resource.setResult(CodeConstants.RESULT_NG);

			logger.debug("精査チェックエラー => {}", resource);
			return ResponseEntity.ok().body(resource);
		}

		//メニュー情報を取得する。
		List<MenuInfo> menuList = menuService.search(toMap(query));

		//結果を格納する。
		resource.setMenuList(menuList);
		//結果OKとする。
		resource.setResult(CodeConstants.RESULT_OK);

		logger.debug("メニュー取得処理終了 => {}", resource);

		return ResponseEntity.ok().body(resource);
	}

	/**
	 * マッピングを行う。
	 * @param query
	 * @return
	 */
	private MenuCriteria toMap(MenuQuery query) {

		MenuCriteria criteria = new MenuCriteria();

		criteria.setAuthorityList(query.getAuthorityList());

		return criteria;
	}

}
