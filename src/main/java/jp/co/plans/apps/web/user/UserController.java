package jp.co.plans.apps.web.user;

import java.util.Arrays;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

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
import jp.co.plans.apps.web.resource.UserResource;

/**
 * ユーザー作成・認証コントローラークラス。
 *
 * @author kotarominamiyama
 *
 */
@RestController
public class UserController {

	private final static Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@Autowired
	private ValidationUtils validationUtils;

	/**
	 * ログインを行う。
	 * @return
	 */
	@RequestMapping(value = "/login", method = { RequestMethod.POST })
	public ResponseEntity<UserResource> login(HttpServletRequest request, @Valid @RequestBody UserQuery query,
			BindingResult bindingResult) {

		//結果初期化
		UserResource resource = new UserResource();

		//エラーが発生した場合は、エラーを格納する。
		if (bindingResult.hasErrors()) {
			resource.setErrorList(validationUtils.setValidationErrors(bindingResult));
			resource.setResult(CodeConstants.RESULT_NG);

			logger.debug("精査チェックエラー => {}", resource);
			return ResponseEntity.ok().body(resource);
		}

		//引数をつめる。
		UserCriteria criteria = toMap(query);

		//ログイン処理を行う。
		userService.login(criteria);

		//セッション時間を格納する。
		resource.setIntervalTime(60 / 2);
		//処理結果を格納する。
		resource.setResult(CodeConstants.RESULT_OK);

		return ResponseEntity.ok().body(resource);

	}

	/**
	 * ユーザーの存在確認を行う。
	 * @return
	 */
	@RequestMapping(value = "/signup/exist", method = { RequestMethod.GET })
	public ResponseEntity<BaseResource> search(HttpServletRequest request, @RequestBody @Validated UserQuery query,
			BindingResult bindingResult) {

		UserCriteria criteria = toMap(query);

		int result = userService.search(criteria);

		//結果初期化
		BaseResource resource = new BaseResource();

		//取得できなかった場合、エラー情報を格納する。
		if (Objects.equals(result, CodeConstants.RESULT_NG)) {
			resource.setErrorList(Arrays.asList(CommonUtils.error("NON_USER", "ユーザー情報が存在しません。")));
		}

		resource.setResult(result);

		return ResponseEntity.ok().body(resource);
	}

	/**
	 * ユーザーの登録を行う。
	 * @return
	 */
	@RequestMapping(value = "/signup/new", method = { RequestMethod.POST })
	public ResponseEntity<BaseResource> insert(HttpServletRequest request, @RequestBody @Validated UserQuery query,
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

		//引数をセットする。
		UserCriteria criteria = toMap(query);

		int result = userService.insert(criteria);

		//取得できなかった場合、エラー情報を格納する。
		if (Objects.equals(result, CodeConstants.RESULT_NG)) {
			resource.setErrorList(Arrays.asList(CommonUtils.error("INSERT_USER_FAILED", "ユーザー情報を登録できませんでした。")));
		}

		resource.setResult(result);

		return ResponseEntity.ok().body(resource);
	}

	/**
	 * ユーザーの更新を行う。
	 * @return
	 */
	@RequestMapping(value = "/user/update", method = { RequestMethod.POST })
	public ResponseEntity<BaseResource> update(HttpServletRequest request, @RequestBody @Validated UserQuery query,
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

		//引数をセットする。
		UserCriteria criteria = toMap(query);

		int result = userService.update(criteria);

		//取得できなかった場合、エラー情報を格納する。
		if (Objects.equals(result, CodeConstants.RESULT_NG)) {
			resource.setErrorList(Arrays.asList(CommonUtils.error("UPDATE_USER_FAILED", "ユーザー情報の更新ができませんでした。")));
		}

		resource.setResult(result);

		return ResponseEntity.ok().body(resource);
	}

	/**
	 * ログイン失敗回数のリセットを行う。
	 * @return
	 */
	@RequestMapping(value = "/admin/reset", method = { RequestMethod.POST })
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

		//引数をセットする。
		UserCriteria criteria = toMap(query);

		int result = userService.resetFailedCount(criteria);

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
