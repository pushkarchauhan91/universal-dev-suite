package com.company.controller;

import com.company.service.PlatformReportService;
import com.company.service.ReportService;
import com.company.service.VirtualReportService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reports")
public class ReportController {

    private final ReportService reportService;
    private final PlatformReportService platformReportService;
    private final VirtualReportService virtualReportService;

    public ReportController(ReportService reportService, PlatformReportService platformReportService, VirtualReportService virtualReportService) {
        this.reportService = reportService;
        this.platformReportService = platformReportService;
        this.virtualReportService = virtualReportService;
    }

    @PostMapping("/{region}")
    public ResponseEntity<String> generateReport(@PathVariable String region) {
        reportService.generateReportForRegion(region);
        return ResponseEntity.ok("✅ report started for region: " + region);
    }

    @PostMapping("/platform/{region}")
    public ResponseEntity<String> generateReportPlatform(@PathVariable String region) {
        platformReportService.generateReportForRegion(region);
        return ResponseEntity.ok("✅ Platform report started for region: " + region);
    }

    @PostMapping("/virtual/{region}")
    public ResponseEntity<String> generateReportVirtual(@PathVariable String region) {
        virtualReportService.generateReportForRegion(region);
        return ResponseEntity.ok("✅ Virtual report started for region: " + region);
    }

}