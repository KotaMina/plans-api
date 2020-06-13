package jp.co.plans.apps.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import jp.co.plans.apps.common.utils.CommonUtils;

public class NumericImpl implements ConstraintValidator<MaxLength, String> {

	@SuppressWarnings("unused")
	private String params;

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {

		boolean result = true;

		if (!CommonUtils.isEmpty(value)) {
			try {
				Integer.parseInt(value);
			} catch (Exception e) {
				//パースできない場合は、false
				result = false;
			}
		}

		return result;
	}
}
