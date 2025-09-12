package com.malgn.application.software.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.malgn.application.software.model.SoftwareResult;
import com.malgn.application.software.model.SoftwareSearchRequest;
import com.malgn.application.software.provided.SoftwareFinder;
import com.malgn.application.software.required.SoftwareClient;

@Slf4j
@RequiredArgsConstructor
@Service
public class SoftwareQueryService implements SoftwareFinder {

    private final SoftwareClient softwareClient;

    @Override
    public Page<SoftwareResult> getSoftware(SoftwareSearchRequest request, Pageable pageable) {
        return softwareClient.getAll(request, pageable);
    }
}
