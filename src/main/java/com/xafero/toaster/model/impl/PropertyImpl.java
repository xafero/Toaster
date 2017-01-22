package com.xafero.toaster.model.impl;

import java.util.StringJoiner;

import com.xafero.toaster.model.source.FieldSource;
import com.xafero.toaster.model.source.MethodSource;
import com.xafero.toaster.model.source.PropertySource;

public class PropertyImpl implements PropertySource {

	private String type;
	private String name;
	private FieldSource field;
	private MethodSource accessor;
	private MethodSource mutator;

	public PropertyImpl(String type, String name) {
		this.type = type;
		this.name = name;
		String fName = toField(name);
		field = (new FieldImpl()).setName(fName).setType(type);
		accessor = createAccessor();
		mutator = (new MethodImpl()).setName("set " + name).setReturnType(null).setBody("this." + fName + " = value;");
		mutator.addParameter(type, "value");
	}

	private String toField(String text) {
		return "_" + text.substring(0, 1).toLowerCase() + text.substring(1);
	}

	@Override
	public PropertySource setName(String name) {
		this.name = name;
		return this;
	}

	@Override
	public String getName() {
		return name;
	}

	public PropertySource setType(String type) {
		this.type = type;
		return this;
	}

	public String getType() {
		return type;
	}

	@Override
	public MethodSource createAccessor() {
		String fName = toField(name);
		accessor = (new MethodImpl()).setName("get " + name).setReturnType(type).setBody("return this." + fName + ";");
		return accessor;
	}

	@Override
	public MethodSource getAccessor() {
		return accessor;
	}

	@Override
	public MethodSource getMutator() {
		return mutator;
	}

	@Override
	public PropertySource removeAccessor() {
		this.accessor = null;
		return this;
	}

	@Override
	public PropertySource removeField() {
		this.field = null;
		return this;
	}

	@Override
	public PropertySource removeMutator() {
		this.mutator = null;
		return this;
	}

	@Override
	public String toString() {
		StringJoiner join = new StringJoiner(String.format("%n"));
		if (field != null)
			join.add("  " + field.toString());
		if (accessor != null)
			join.add("  " + accessor.toString());
		if (mutator != null)
			join.add("  " + mutator.toString());
		return join.toString();
	}
}