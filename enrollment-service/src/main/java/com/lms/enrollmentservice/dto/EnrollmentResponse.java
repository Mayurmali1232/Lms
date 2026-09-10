package com.lms.enrollmentservice.dto;

import com.lms.enrollmentservice.entity.EnrollmentStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EnrollmentResponse {
    private Long id;
    private Long userId;
    private Long courseId;
    private EnrollmentStatus status;
    private Instant enrolledAt;
    private Instant completedAt;
}