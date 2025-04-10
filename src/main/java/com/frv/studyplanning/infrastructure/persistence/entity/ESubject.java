package com.frv.studyplanning.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalTime;
import java.util.List;

@Data
@Entity
public class ESubject {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String subject;
	private Boolean done = false;
	private LocalTime start_time;
	private LocalTime end_time;
	@OneToMany(mappedBy="subject", orphanRemoval=true )
	private List<ETopic> topics;
}
