package com.xafero.toaster.model.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.StringJoiner;

import com.xafero.toaster.model.source.TsEnumSource;

public class TsEnumImpl extends TsClassImpl implements TsEnumSource {

	private final List<String> constants;

	public TsEnumImpl() {
		name = "SomeEnum";
		kind = "enum";
		constants = new LinkedList<>();
	}

	@Override
	public void addEnumConstant(String txt) {
		constants.add(txt);
	}

	@Override
	protected void writeBody(StringJoiner join) {
		StringJoiner cj = new StringJoiner(String.format(",%n"));
		for (String constant : constants)
			cj.add("  " + constant);
		join.add(cj.toString());
	}
}