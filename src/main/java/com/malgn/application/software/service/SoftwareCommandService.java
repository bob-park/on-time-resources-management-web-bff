package com.malgn.application.software.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

import com.malgn.application.software.model.SoftwareRegisterRequest;
import com.malgn.application.software.model.SoftwareResult;
import com.malgn.application.software.provided.SoftwareRegister;
import com.malgn.application.software.required.SoftwareClient;

@Slf4j
@RequiredArgsConstructor
@Service
public class SoftwareCommandService implements SoftwareRegister {

    private final SoftwareClient softwareClient;

    @Override
    public SoftwareResult register(SoftwareRegisterRequest registerRequest) {
        return softwareClient.register(registerRequest);
    }
}
