package jp.co.plans.apps.validation;

import java.util.Objects;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class SizeNotNullImpl implements ConstraintValidator<MaxLength, String> {

	@SuppressWarnings("unused")
	private String params;

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return !Objects.isNull(value) && value != "";
	}
}
