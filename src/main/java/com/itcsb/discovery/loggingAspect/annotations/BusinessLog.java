package com.itcsb.discovery.loggingAspect.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.itcsb.discovery.loggingAspect.enums.BusinessAction;

@Target({ ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface BusinessLog {
	public BusinessAction LogAction() default BusinessAction.EMPTY;
}