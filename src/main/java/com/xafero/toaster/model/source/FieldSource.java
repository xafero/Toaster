package com.xafero.toaster.model.source;

public interface FieldSource extends MemberSource<FieldSource> {

	FieldSource setType(String type);

	String getType();

	FieldSource setLiteralInitializer(String value);

}