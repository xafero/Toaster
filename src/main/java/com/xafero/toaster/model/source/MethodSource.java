package com.xafero.toaster.model.source;

public interface MethodSource extends MemberSource<MethodSource> {

	void setBody(String body);

	String getBody();

}