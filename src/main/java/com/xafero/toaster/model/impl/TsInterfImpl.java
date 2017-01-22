package com.xafero.toaster.model.impl;

import com.xafero.toaster.model.source.PropertySource;
import com.xafero.toaster.model.source.TsInterfaceSource;

public class TsInterfImpl extends TsClassImpl implements TsInterfaceSource {

	public TsInterfImpl() {
		name = "SomeInterface";
		kind = "interface";
	}

	@Override
	public PropertySource addProperty(String type, String name) {
		PropertySource prop = super.addProperty(type, name);
		prop.removeField();
		prop.getAccessor().setBody(null);
		prop.getMutator().setBody(null);
		return prop;
	}
}