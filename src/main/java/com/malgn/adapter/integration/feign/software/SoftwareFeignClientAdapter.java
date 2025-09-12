package com.malgn.adapter.integration.feign.software;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.malgn.application.software.model.SoftwareRegisterRequest;
import com.malgn.application.software.model.SoftwareResult;
import com.malgn.application.software.model.SoftwareSearchRequest;
import com.malgn.application.software.required.SoftwareClient;

@Slf4j
@RequiredArgsConstructor
@Component
public class SoftwareFeignClientAdapter implements SoftwareClient {

    private final SoftwareFeignClient softwareClient;

    @Override
    public SoftwareResult register(SoftwareRegisterRequest registerRequest) {
        return softwareClient.registerSoftware(registerRequest);
    }

    @Override
    public Page<SoftwareResult> getAll(SoftwareSearchRequest searchRequest, Pageable pageable) {
        return softwareClient.getSoftware(searchRequest, pageable).toPage();
    }
}
