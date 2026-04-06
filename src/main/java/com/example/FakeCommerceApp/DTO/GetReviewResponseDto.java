package com.example.FakeCommerceApp.DTO;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetReviewResponseDto {
    private Long id;
    private String comment;
    private Integer rating;
    private Long productId;
    private LocalDateTime createdAt;
}
