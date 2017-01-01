package com.xafero.toaster.model.source;

public interface MethodSource extends MemberSource<MethodSource> {

	MethodSource setBody(String body);

	String getBody();

	MethodSource setReturnType(String type);

	String getReturnType();

}