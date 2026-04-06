package com.example.FakeCommerceApp.DTO;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetReviewDto {
    private Long id;
    private String comment;
    private Integer rating;
    private Long productId;
    private LocalDateTime createdAt;
}
