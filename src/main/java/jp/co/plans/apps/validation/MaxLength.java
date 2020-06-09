package jp.co.plans.apps.validation;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * 文字数の最大値のチェックを行う。
 * @author kotarominamiyama
 *
 */
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
@Constraint(validatedBy = { MaxLengthImpl.class })
public @interface MaxLength {
	String message()

	default "{common.validation.MaxLength.message}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	int max();

	String params();

	@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
	@Retention(RUNTIME)
	public @interface List {
		MaxLength[] value();
	}
}
