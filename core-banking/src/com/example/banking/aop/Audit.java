package com.example.banking.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface Audit {
	int fromIbanIndex() default 0;

	int toIbanIndex() default 1;

	int amountIndex() default 2;
}
