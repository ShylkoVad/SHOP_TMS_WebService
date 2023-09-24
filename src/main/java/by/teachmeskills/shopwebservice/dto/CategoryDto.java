package by.teachmeskills.shopwebservice.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {
    private int id;

    @NotBlank(message = "Поле должно быть заполнено!")
    private String name;

    private List<ProductDto> products;
}