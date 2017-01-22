package com.xafero.toaster.model.impl;

import com.xafero.toaster.model.source.FieldSource;

public class FieldImpl implements FieldSource {

	private String name;
	private String type;
	private String body;

	public FieldImpl() {
		name = "unknown";
		type = "any";
	}

	@Override
	public FieldSource setName(String name) {
		this.name = name;
		return this;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public FieldSource setType(String type) {
		this.type = type;
		return this;
	}

	@Override
	public FieldSource setLiteralInitializer(String body) {
		this.body = body;
		return this;
	}

	@Override
	public String toString() {
		String bodyTxt = body == null ? ";" : String.format(" = %s;", body);
		return String.format("%s : %s%s", name, type, bodyTxt);
	}
}