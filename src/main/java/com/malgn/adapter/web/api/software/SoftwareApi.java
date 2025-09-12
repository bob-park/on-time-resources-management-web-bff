package com.malgn.adapter.web.api.software;

import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.malgn.application.software.model.SoftwareRegisterRequest;
import com.malgn.application.software.model.SoftwareResult;
import com.malgn.application.software.model.SoftwareSearchRequest;
import com.malgn.application.software.provided.SoftwareFinder;
import com.malgn.application.software.provided.SoftwareRegister;

@RequiredArgsConstructor
@RestController
@RequestMapping("software")
public class SoftwareApi {

    private final SoftwareRegister softwareRegister;
    private final SoftwareFinder softwareFinder;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "")
    public SoftwareResult register(@RequestBody SoftwareRegisterRequest registerRequest) {
        return softwareRegister.register(registerRequest);
    }

    @GetMapping(path = "")
    public Page<SoftwareResult> getSoftware(SoftwareSearchRequest searchRequest, Pageable pageable) {
        return softwareFinder.getSoftware(searchRequest, pageable);
    }

}
