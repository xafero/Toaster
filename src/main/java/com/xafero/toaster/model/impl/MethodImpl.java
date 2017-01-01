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

	public MethodSource setName(String name) {
		this.name = name;
		return this;
	}

	public String getName() {
		return name;
	}

	public MethodImpl setType(String type) {
		this.type = type;
		return this;
	}

	public String getType() {
		return type;
	}

	@Override
	public void setBody(String body) {
		this.body = body;
	}

	@Override
	public String getBody() {
		return body;
	}

	public void addParam(String name, String type) {
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