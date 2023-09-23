package by.teachmeskills.shopwebservice.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Min;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private int id;

    @PastOrPresent
    private LocalDateTime createdAt;

    private List<ProductDto> products;

    @NotNull(message = "Поле должно быть заполнено!")
    @Min(value = 0)
    private double price;

    @NotNull(message = "Поле должно быть заполнено!")
    private int userId;
}
