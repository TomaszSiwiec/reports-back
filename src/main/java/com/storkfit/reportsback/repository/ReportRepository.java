package com.storkfit.reportsback.repository;

import com.storkfit.reportsback.document.ReportDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportRepository extends MongoRepository<ReportDocument, String> {
}
