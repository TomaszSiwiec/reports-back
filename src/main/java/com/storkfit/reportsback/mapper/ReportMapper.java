package com.storkfit.reportsback.mapper;

import com.storkfit.reportsback.document.ReportDocument;
import com.storkfit.reportsback.dto.ReportDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ReportMapper {

    ReportMapper INSTANCE = Mappers.getMapper(ReportMapper.class);

    ReportDocument toDocument(ReportDto reportDto);

    ReportDto toDto(ReportDocument reportDocument);
}
