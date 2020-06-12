package jp.co.plans.apps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import jp.co.plans.apps.common.dto.ErrorInfo;
import jp.co.plans.apps.common.exception.AccessDeniedException;
import jp.co.plans.apps.common.exception.AuthException;
import jp.co.plans.apps.common.exception.NotFoundException;
import jp.co.plans.apps.common.exception.ProcessException;
import jp.co.plans.apps.constants.CodeConstants;
import jp.co.plans.apps.web.resource.BaseResource;

/**
 * 例外ハンドリング
 * @author kotarominamiyama
 *
 */
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		List<ErrorInfo> errors = new ArrayList<>();
		BindingResult bindingResult = ex.getBindingResult();

		for (FieldError fieldError : bindingResult.getFieldErrors()) {
			ErrorInfo err = new ErrorInfo(fieldError.getField(), fieldError.getDefaultMessage());

			errors.add(err);

		}

		BaseResource resource = new BaseResource();
		resource.setErrorList(errors);
		resource.setResult(CodeConstants.RESULT_NG);

		return super.handleExceptionInternal(ex, resource, headers,
				HttpStatus.INTERNAL_SERVER_ERROR, request);
	}

	/**
	 * NotFoundExceptionハンドリング
	 * @param e
	 * @return
	 */
	@ExceptionHandler({ NotFoundException.class })
	public BaseResource handleNotFoundException(NotFoundException e) {

		e.printStackTrace();
		BaseResource resource = new BaseResource();

		ErrorInfo error = new ErrorInfo("NOT_FOUND_EXCPETION", e.getMessage() + "が見つかりませんでした。");
		resource.setResult(CodeConstants.RESULT_NG);
		resource.setErrorList(Arrays.asList(error));

		return resource;
	}

	/**
	 * AuthExcepionハンドリング
	 * @param e
	 * @return
	 */
	@ExceptionHandler({ AuthException.class })
	public BaseResource handleAuthException(AuthException e) {

		e.printStackTrace();
		BaseResource resource = new BaseResource();

		ErrorInfo error = new ErrorInfo("LOGIN_FAILED", "ユーザーIDまたはパスワードが正しくありません。");
		resource.setResult(CodeConstants.RESULT_NG);
		resource.setErrorList(Arrays.asList(error));

		return resource;
	}

	/**
	 * ProcessExcepionハンドリング
	 * @param e
	 * @return
	 */
	@ExceptionHandler({ ProcessException.class })
	public BaseResource handleProcessException(ProcessException e) {

		e.printStackTrace();
		BaseResource resource = new BaseResource();

		ErrorInfo error = new ErrorInfo("PROCESS_FAILED", e.getMessage() + "の処理に失敗しました。");
		resource.setResult(CodeConstants.RESULT_NG);
		resource.setErrorList(Arrays.asList(error));

		return resource;
	}

	/**
	 * AccessDeniedExceptionハンドリング
	 * @param e
	 * @return
	 */
	@ExceptionHandler({ AccessDeniedException.class })
	public BaseResource handleAccessDeniedException(AccessDeniedException e) {

		e.printStackTrace();
		BaseResource resource = new BaseResource();

		ErrorInfo error = new ErrorInfo("ACCESS_DENIED", "アクセスができませんでした。");
		resource.setResult(CodeConstants.RESULT_NG);
		resource.setErrorList(Arrays.asList(error));

		return resource;
	}

	/**
	 * Exceptionハンドリング
	 * @param e
	 * @return
	 */
	@ExceptionHandler({ Exception.class })
	public BaseResource handleException(Exception e) {

		e.printStackTrace();
		BaseResource resource = new BaseResource();

		ErrorInfo error = new ErrorInfo("SYSTEM_ERROR", "システム例外が発生しました。");
		resource.setResult(CodeConstants.RESULT_NG);
		resource.setErrorList(Arrays.asList(error));

		return resource;
	}
}
