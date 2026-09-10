package com.lms.enrollmentservice.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EnrollmentRequest {

    @NotNull(message = "User ID is mandatory")
    @Positive(message = "User ID must be positive")
    private Long userId;

    @NotNull(message = "Course ID is mandatory")
    @Positive(message = "Course ID must be positive")
    private Long courseId;
}