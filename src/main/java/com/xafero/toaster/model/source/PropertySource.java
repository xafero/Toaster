package com.xafero.toaster.model.source;

public interface PropertySource extends MemberSource<PropertySource>, NamedSource<PropertySource> {

	MethodSource createAccessor();

	MethodSource getAccessor();

	MethodSource getMutator();

	PropertySource removeAccessor();

	PropertySource removeField();

	PropertySource removeMutator();

}