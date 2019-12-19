package com.example.lottery.model;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface RandomNumber {

	int size();

	boolean distinct();

	boolean sorted();

	int max();

	int min();

}
