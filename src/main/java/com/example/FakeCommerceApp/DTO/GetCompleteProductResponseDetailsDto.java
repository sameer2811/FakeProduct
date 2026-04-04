package com.example.FakeCommerceApp.DTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class GetCompleteProductResponseDetailsDto extends GetProductResponseDto {
    private String categoryName;
}
