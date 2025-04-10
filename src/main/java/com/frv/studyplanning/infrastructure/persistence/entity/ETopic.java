package com.frv.studyplanning.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class ETopic {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String topic;
    private String source  = "Not described";
    @ManyToOne
    @JoinColumn(name = "subject_id")
    private ESubject subject;
}
