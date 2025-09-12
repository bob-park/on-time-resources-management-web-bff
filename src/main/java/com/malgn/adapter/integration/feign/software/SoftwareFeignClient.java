package com.malgn.adapter.integration.feign.software;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.malgn.application.software.model.SoftwareRegisterRequest;
import com.malgn.application.software.model.SoftwareResult;
import com.malgn.application.software.model.SoftwareSearchRequest;
import com.malgn.common.model.SimplePageImpl;

@FeignClient(name = "on-time-resources-management-api", contextId = "on-time-resources-management-api-software", path = "api/v1/software")
public interface SoftwareFeignClient {

    @PostMapping(path = "")
    SoftwareResult registerSoftware(@RequestBody SoftwareRegisterRequest registerRequest);

    @GetMapping(path ="")
    SimplePageImpl<SoftwareResult> getSoftware(@SpringQueryMap SoftwareSearchRequest searchRequest, Pageable pageable);
}
