package com.xafero.toaster.model.source;

import com.xafero.toaster.model.Packaged;

public interface PackagedSource<T> extends Packaged {

	T setPackage(String name);

}