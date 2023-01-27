package com.storkfit.reportsback;

import com.storkfit.reportsback.mapper.ReportMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ReportsBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReportsBackApplication.class, args);
    }

    @Bean
    public ReportMapper reportMapper() {
        return ReportMapper.INSTANCE;
    }
}
