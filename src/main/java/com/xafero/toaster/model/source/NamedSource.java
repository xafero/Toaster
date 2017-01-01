package com.xafero.toaster.model.source;

import com.xafero.toaster.model.Named;

public interface NamedSource<T> extends Named {

	T setName(String name);

}