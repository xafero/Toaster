package com.xafero.toaster.model.impl;

import com.xafero.toaster.model.source.TsInterfaceSource;

public class TsInterfImpl extends TsClassImpl implements TsInterfaceSource {

	public TsInterfImpl() {
		name = "SomeInterface";
		kind = "interface";
	}
}