package com.example.demo.dao

import com.fasterxml.jackson.annotation.JsonIgnore
import org.springframework.data.annotation.CreatedBy
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedBy
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.EntityListeners
import javax.persistence.MappedSuperclass

@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
abstract class BaseEntity {
    @JsonIgnore
    @Column(name = "created_at", nullable = false, columnDefinition = "TIMESTAMP")
    @CreatedDate
    var createdAt: LocalDateTime = LocalDateTime.now()

    @JsonIgnore
    @Column(nullable = false, length = 30)
    @CreatedBy
    var createdBy: String = ""

    @JsonIgnore
    @Column(name = "modified_at", nullable = false, columnDefinition = "TIMESTAMP")
    @LastModifiedDate
    var modifiedAt: LocalDateTime = LocalDateTime.now()

    @JsonIgnore
    @Column(nullable = false, length = 30)
    @LastModifiedBy
    var modifiedBy: String = ""
}