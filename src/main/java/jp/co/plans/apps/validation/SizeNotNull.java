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
@Constraint(validatedBy = { SizeNotNullImpl.class })
public @interface SizeNotNull {
	String message()

	default "{common.validation.SizeNotNull.message}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	String params();

	@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
	@Retention(RUNTIME)
	public @interface List {
		SizeNotNull[] value();
	}
}
