package com.caballero.futbolsa.vista.componentes;

import com.vaadin.data.Validator;

public class ValidadorNumerico implements Validator{
	private static final long serialVersionUID = 1L;

	@Override
	public void validate(Object valor) throws InvalidValueException {
		if(!((String) valor).matches("[0-9]+"))
            throw new InvalidValueException("Unicamente se aceptan caracteres numericos en este campo");
	}

}
