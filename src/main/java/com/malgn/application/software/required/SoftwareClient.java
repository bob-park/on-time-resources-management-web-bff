package com.malgn.application.software.required;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.malgn.application.software.model.SoftwareRegisterRequest;
import com.malgn.application.software.model.SoftwareResult;
import com.malgn.application.software.model.SoftwareSearchRequest;

public interface SoftwareClient {

    SoftwareResult register(SoftwareRegisterRequest registerRequest);

    Page<SoftwareResult> getAll(SoftwareSearchRequest searchRequest, Pageable pageable);
}
