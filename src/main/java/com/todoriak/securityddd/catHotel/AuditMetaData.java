package com.todoriak.securityddd.catHotel;


/*
    @author danatodoriak
    @project security-ddd
    @class AuditMetaData
    @version 1.0.0
    @since 15.04.2025 - 17.12
*/

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDate;

@Data
public class AuditMetaData {

    @CreatedDate
    private LocalDate createdAt;
    @CreatedBy
    private String createdBy;
    @LastModifiedDate
    private LocalDate lastModifiedAt;
    @LastModifiedBy
    private String lastModifiedBy;
}
