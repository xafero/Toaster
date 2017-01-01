package com.xafero.toaster;

import com.xafero.toaster.model.impl.TsClassImpl;
import com.xafero.toaster.model.source.TsClassSource;
import com.xafero.toaster.model.source.TsSource;

public class Toaster {

	public static <T extends TsSource> T create(Class<T> type) {
		if (type == TsClassSource.class)
			return type.cast(new TsClassImpl());
		throw new UnsupportedOperationException(type.getName() + " ?!");
	}
}