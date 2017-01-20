package com.xafero.toaster.model.impl;

import com.xafero.toaster.model.source.AnnotationSource;

public class AnnotImpl implements AnnotationSource {

	private String name;
	private String value;

	public AnnotImpl(String name) {
		this.name = name;
	}

	@Override
	public AnnotationSource setStringValue(String value) {
		this.value = value;
		return this;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getStringValue() {
		return value;
	}
}