package jp.co.plans.apps.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import jp.co.plans.apps.common.utils.CommonUtils;

public class MaxLengthImpl implements ConstraintValidator<MaxLength, String> {

	private int max;

	@SuppressWarnings("unused")
	private String params;

	@Override
	public void initialize(MaxLength constraintAnnotation) {
		max = constraintAnnotation.max();
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {

		boolean result = true;

		if (!CommonUtils.isEmpty(value)) {
			result = value.length() <= max;
		}

		return result;
	}
}
