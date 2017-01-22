package com.xafero.toaster.model.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.StringJoiner;

import com.xafero.toaster.model.source.AnnotationSource;
import com.xafero.toaster.model.source.AnnotationTargetSource;
import com.xafero.toaster.model.source.FieldSource;
import com.xafero.toaster.model.source.MemberSource;
import com.xafero.toaster.model.source.MethodSource;
import com.xafero.toaster.model.source.PropertySource;
import com.xafero.toaster.model.source.TsClassSource;
import com.xafero.toaster.model.source.TsSource;

public class TsClassImpl implements TsClassSource, AnnotationTargetSource {

	private String pkg;
	protected String name;
	protected String kind;
	private List<MemberSource<?>> members;
	private List<AnnotationSource> annots;

	public TsClassImpl() {
		pkg = "SomePackage";
		name = "SomeClass";
		kind = "class";
		members = new LinkedList<>();
		annots = new LinkedList<>();
	}

	@Override
	public PropertySource addProperty(String type, String name) {
		PropertyImpl inst;
		members.add(inst = new PropertyImpl(type, name));
		return inst;
	}

	@Override
	public MethodSource addMethod() {
		MethodImpl inst;
		members.add(inst = new MethodImpl());
		return inst;
	}

	@Override
	public FieldSource addField() {
		FieldImpl inst;
		members.add(inst = new FieldImpl());
		return inst;
	}

	@Override
	public AnnotationSource addAnnotation(String className) {
		AnnotImpl inst;
		annots.add(inst = new AnnotImpl(className));
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
		if (!annots.isEmpty()) {
			join.add("static annotations: { [name: string]: string; } = { ");
			StringJoiner anno = new StringJoiner(String.format(",%n "));
			for (AnnotationSource annots : annots)
				anno.add(String.format("'%s':'%s'", annots.getName(), annots.getStringValue()));
			join.add(anno + " }; ");
		}
		for (MemberSource<?> member : members)
			join.add("  " + member);
	}
}