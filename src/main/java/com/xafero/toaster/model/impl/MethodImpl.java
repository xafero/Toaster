package com.xafero.toaster.model.impl;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringJoiner;

import com.xafero.toaster.model.source.MethodSource;

public class MethodImpl implements MethodSource {

	private final Map<String, String> params;

	private String name;
	private String type;
	private String body;

	public MethodImpl() {
		name = "unknown";
		type = "void";
		params = new LinkedHashMap<>();
	}

	@Override
	public MethodSource setName(String name) {
		this.name = name;
		return this;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public MethodImpl setReturnType(String type) {
		this.type = type;
		return this;
	}

	@Override
	public String getReturnType() {
		return type;
	}

	@Override
	public MethodImpl setBody(String body) {
		this.body = body;
		return this;
	}

	@Override
	public String getBody() {
		return body;
	}

	@Override
	public void addParameter(String type, String name) {
		params.put(name, type);
	}

	@Override
	public String toString() {
		StringJoiner bld = new StringJoiner(", ");
		for (Entry<String, String> e : params.entrySet())
			bld.add(String.format("%s : %s", e.getKey(), e.getValue()));
		String bodyTxt = body == null ? ";" : String.format(" { %n   %s %n  }", body);
		return String.format("%s(%s) : %s%s", name, bld, type, bodyTxt);
	}
}