package com.malgn.application.software.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@NoArgsConstructor
public class SoftwareSearchRequest {

    private Long teamId;
    private String name;
    private SoftwareStatus status;
}
