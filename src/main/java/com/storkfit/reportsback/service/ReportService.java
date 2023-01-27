package com.storkfit.reportsback.service;

import com.storkfit.reportsback.ReportNotFoundException;
import com.storkfit.reportsback.document.ReportDocument;
import com.storkfit.reportsback.dto.ReportDto;
import com.storkfit.reportsback.enums.Gender;
import com.storkfit.reportsback.mapper.ReportMapper;
import com.storkfit.reportsback.repository.ReportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReportService {

    private final ReportRepository repository;
    private final ReportMapper mapper;

    public List<ReportDto> getAllReports() {
        // TODO: after security implementation add sorting by userId
        List<ReportDocument> documents = repository.findAll();
        return documents.stream()
                .map(doc -> mapper.toDto(doc))
                .collect(Collectors.toList());
    }

    public ReportDto getReport(String id) {
        ReportDocument document = repository.findById(id).orElseThrow(() -> new ReportNotFoundException());
        return mapper.toDto(document);
    }

    public ReportDto create(ReportDto reportDto) {
        // TODO: get gender from user profile
        UUID uuid = UUID.randomUUID();
        Gender gender = Gender.MALE;
        ReportDocument newReport = mapper.toDocument(reportDto);
        newReport.setId(String.valueOf(uuid));
        newReport.setCreationDateTime(LocalDateTime.now());
        newReport.setCalculatedBodyFat(
                calculateBodyFat(gender, reportDto.getWaist(), reportDto.getWeight())
        );

        ReportDocument saved = repository.save(newReport);
        return mapper.toDto(saved);
    }

    private Double calculateBodyFat(Gender gender, Double waist, Double weight) {
        Double paramA = calculateParemeterA(waist);
        Double paramB = calculateParemeterB(paramA);
        Double paramC = calculateParemeterC(weight);
        Double paramD = gender == Gender.MALE ?
                calculateParemeterDForMen(paramB, paramC) :
                calculateParemeterDForWomen(paramB, paramC);
        Double paramE = calculateParemeterE(weight);
        return Math.round((paramD / paramE * 100) * 100.0)/100.0;
    }

    private Double calculateParemeterA(Double waist) {
        return 4.15 * waist;
    }

    private Double calculateParemeterB(Double parameterA) {
        return parameterA / 2.54;
    }

    private Double calculateParemeterC(Double weight) {
        return 0.082 * weight * 2.2;
    }

    private Double calculateParemeterDForMen(Double parameterB, Double parameterC) {
        return parameterB - parameterC - 98.42;
    }

    private Double calculateParemeterDForWomen(Double parameterB, Double parameterC) {
        return parameterB - parameterC - 76.76;
    }

    private Double calculateParemeterE(Double weight) {
        return weight * 2.2;
    }
}
