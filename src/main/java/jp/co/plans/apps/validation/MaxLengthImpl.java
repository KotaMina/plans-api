package jp.co.plans.apps.validation;

import java.util.Objects;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

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
		return !Objects.isNull(value) && value.length() <= max;
	}
}
