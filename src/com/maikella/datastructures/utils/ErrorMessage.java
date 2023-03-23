package com.maikella.datastructures.utils;

public enum ErrorMessage {

	NEGATIVE_NUMBER("error: invalid input. please enter a positive integer"),
	ONLY_NUMBERS("error: invalid value! only numbers are allowed"),
	ONLY_YES_OR_NO("error: please enter a valid value: \"y\" for yes or \"n\" for no"),
	ELEMENT_NOT_EXIST("error: the element does not exist"),
	ILLEGAL_INDEX("error: the index is greater than the size of the array");

	private final String message;

	ErrorMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}