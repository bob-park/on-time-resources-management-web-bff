package com.malgn.application.software.provided;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.malgn.application.software.model.SoftwareResult;
import com.malgn.application.software.model.SoftwareSearchRequest;

public interface SoftwareFinder {

    Page<SoftwareResult> getSoftware(SoftwareSearchRequest request, Pageable pageable);

}
