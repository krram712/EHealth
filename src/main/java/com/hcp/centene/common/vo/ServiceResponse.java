package com.hcp.centene.common.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;
import lombok.Data;

@Data
public class ServiceResponse<T> {
	private ErrorInfo errorInfo;
	
	@JsonInclude(NON_EMPTY)
	private T data;
	

}
