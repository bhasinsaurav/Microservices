package com.eazybytes.accounts.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

import java.time.LocalDate;

@MappedSuperclass
@Data
public class BaseEntity {

    @Column(updatable = false)
    private LocalDate ceratedAt;

    @Column(updatable = false)
    private String createdBy;

    @Column(insertable = false)
    private LocalDate updatedAt;

    @Column(insertable = false)
    private String updatedBy;
}
