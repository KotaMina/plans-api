package jp.co.plans.apps.web.admin;

import java.util.Arrays;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jp.co.plans.apps.common.utils.CommonUtils;
import jp.co.plans.apps.common.utils.ValidationUtils;
import jp.co.plans.apps.constants.CodeConstants;
import jp.co.plans.apps.domain.criteria.UserCriteria;
import jp.co.plans.apps.domain.service.user.UserService;
import jp.co.plans.apps.web.query.UserQuery;
import jp.co.plans.apps.web.resource.BaseResource;

/**
 * 管理者用ユーザー作成・認証コントローラークラス。
 *
 * @author kotarominamiyama
 *
 */
@RestController
@RequestMapping(value = "/admin")
public class AdminUserController {

	private final static Logger logger = LoggerFactory.getLogger(AdminUserController.class);

	@Autowired
	private UserService userService;

	@Autowired
	private ValidationUtils validationUtils;

	/**
	 * ログイン失敗回数のリセットを行う。
	 * @return
	 */
	@RequestMapping(value = "/reset", method = { RequestMethod.POST })
	public ResponseEntity<BaseResource> resetFailedCount(HttpServletRequest request,
			@RequestBody @Validated UserQuery query,
			BindingResult bindingResult) {

		//結果初期化
		BaseResource resource = new BaseResource();

		//エラーが発生した場合は、エラーを格納する。
		if (bindingResult.hasErrors()) {
			resource.setErrorList(validationUtils.setValidationErrors(bindingResult));
			resource.setResult(CodeConstants.RESULT_NG);

			logger.debug("精査チェックエラー => {}", resource);
			return ResponseEntity.ok().body(resource);
		}

		//管理者権限チェックを行う。
		userService.checkAuthority(query.getUserId(), CodeConstants.AUTHORITY_ADMIN);

		int result = userService.resetFailedCount(toMap(query));

		//取得できなかった場合、エラー情報を格納する。
		if (Objects.equals(result, CodeConstants.RESULT_NG)) {
			resource.setErrorList(Arrays.asList(CommonUtils.error("RESET_FAILED", "ユーザー情報の更新ができませんでした。")));
		}

		resource.setResult(result);

		return ResponseEntity.ok().body(resource);
	}

	/**
	 * マッピングする。
	 * @return
	 */
	private UserCriteria toMap(UserQuery query) {

		//引数をセットする。
		UserCriteria criteria = new UserCriteria();

		criteria.setUserId(query.getUserId());
		criteria.setName(query.getName());
		criteria.setJpName(query.getJpName());
		criteria.setPassword(query.getPassword());

		return criteria;
	}
}
