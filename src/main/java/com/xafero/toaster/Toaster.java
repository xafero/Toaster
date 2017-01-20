package com.xafero.toaster;

import com.xafero.toaster.model.impl.TsClassImpl;
import com.xafero.toaster.model.impl.TsEnumImpl;
import com.xafero.toaster.model.impl.TsInterfImpl;
import com.xafero.toaster.model.source.TsClassSource;
import com.xafero.toaster.model.source.TsEnumSource;
import com.xafero.toaster.model.source.TsInterfaceSource;
import com.xafero.toaster.model.source.TsSource;

public class Toaster {

	public static <T extends TsSource> T create(Class<T> type) {
		if (type == TsClassSource.class)
			return type.cast(new TsClassImpl());
		if (type == TsInterfaceSource.class)
			return type.cast(new TsInterfImpl());
		if (type == TsEnumSource.class)
			return type.cast(new TsEnumImpl());
		throw new UnsupportedOperationException(type.getName() + " ?!");
	}
}