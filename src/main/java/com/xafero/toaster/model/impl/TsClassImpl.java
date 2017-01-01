package com.xafero.toaster.model.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.StringJoiner;

import com.xafero.toaster.model.source.MemberSource;
import com.xafero.toaster.model.source.MethodSource;
import com.xafero.toaster.model.source.TsClassSource;
import com.xafero.toaster.model.source.TsSource;

public class TsClassImpl implements TsClassSource {

	private String pkg;
	private String name;
	private String kind;
	private List<MemberSource<?>> members;

	public TsClassImpl() {
		pkg = "SomePackage";
		name = "SomeClass";
		kind = "class";
		members = new LinkedList<>();
	}

	public MethodSource addMethod() {
		MethodImpl inst;
		members.add(inst = new MethodImpl());
		return inst;
	}

	@Override
	public TsSource setName(String name) {
		this.name = name;
		return this;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public TsSource setPackage(String pkg) {
		this.pkg = pkg;
		return this;
	}

	@Override
	public String getPackage() {
		return pkg;
	}

	@Override
	public String toString() {
		StringJoiner join = new StringJoiner(String.format("%n"));
		join.add("namespace " + pkg + " {");
		join.add(" export " + kind + " " + name + " {");
		writeBody(join);
		join.add(" }");
		join.add("}");
		return join.toString();
	}

	protected void writeBody(StringJoiner join) {
		for (MemberSource<?> member : members)
			join.add("  " + member);
	}
}