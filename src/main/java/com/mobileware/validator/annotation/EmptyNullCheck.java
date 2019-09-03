package com.mobileware.validator.annotation;

import java.lang.reflect.Field;

import net.sf.oval.Validator;
import net.sf.oval.configuration.annotation.AbstractAnnotationCheck;
import net.sf.oval.context.OValContext;

public class EmptyNullCheck extends AbstractAnnotationCheck<MwtEmptyNull> {
	private static final long serialVersionUID = 1L;

	public boolean isSatisfied(Object validatedObject, Object valueToValidate, OValContext context,
			Validator validator) {

		boolean result = false;
		if (valueToValidate != null && !valueToValidate.toString().isEmpty()) {
			result = true;
		} else {
			Field[] ff = validatedObject.getClass().getDeclaredFields();
			for (Field field : ff) {
				this.setMessage(field.getName() + " Field can not be blank");
			}
		}
		return result;
	}
}
