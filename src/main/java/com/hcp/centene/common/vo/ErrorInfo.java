package com.hcp.centene.common.vo;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
@Builder
public class ErrorInfo {
	 private String errorCode;
	 private String errorMessage;

}
