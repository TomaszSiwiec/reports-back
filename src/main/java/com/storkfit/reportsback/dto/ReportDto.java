package com.storkfit.reportsback.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReportDto {
    private String id;
    private String userId;
    private LocalDateTime creationDateTime;
    private Double insertedBodyFat;
    private Double calculatedBodyFat;
    private Double weight;
    private Double chest;
    private Double biceps;
    private Double waist;
    private Double hip;
    private Double thigh;
    private Double calf;
    private String additionalInformation;
    private List<String> attachmentsLinks;
}
