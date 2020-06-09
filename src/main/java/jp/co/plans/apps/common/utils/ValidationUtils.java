package jp.co.plans.apps.common.utils;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import jp.co.plans.apps.common.dto.ErrorInfo;

@Component
public class ValidationUtils {

	private final static Logger logger = LoggerFactory.getLogger(ValidationUtils.class);

	/**
	 * パラメータチェックエラーをエラーオブジェクトに格納する。
	 * @param bindingResult
	 * @return
	 */
	public List<ErrorInfo> setValidationErrors(BindingResult bindingResult) {
		logger.debug("パラメーターチェックエラー処理開始");
		List<ErrorInfo> errors = new ArrayList<>();

		for (FieldError fieldError : bindingResult.getFieldErrors()) {
			ErrorInfo err = new ErrorInfo(fieldError.getField(), fieldError.getDefaultMessage());

			errors.add(err);

		}

		logger.debug("パラメーターチェックエラー処理終了　=> {0}", errors);
		return errors;

	}

}
