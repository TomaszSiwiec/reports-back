package com.storkfit.reportsback.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReportDocument {
    @Id
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
