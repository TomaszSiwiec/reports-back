package com.storkfit.reportsback.controller;

import com.storkfit.reportsback.dto.ReportDto;
import com.storkfit.reportsback.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reports")
@RequiredArgsConstructor
public class ReportController {

    private final ReportService reportService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(reportService.getAllReports());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") String id) {
        return ResponseEntity.ok(reportService.getReport(id));
    }

    @PostMapping
    public ResponseEntity create(@RequestBody ReportDto reportDto) {
        reportService.create(reportDto);
        return new ResponseEntity(HttpStatus.CREATED);
    }
}
