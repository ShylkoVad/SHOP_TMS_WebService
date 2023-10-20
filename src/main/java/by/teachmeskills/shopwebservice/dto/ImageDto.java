package by.teachmeskills.shopwebservice.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImageDto {

    private int id;

    @NotBlank(message = "Поле должно быть заполнено!")
    @Size(min = 3, message = "Путь к картинке не может содержать меньше 3 символов.")
    private String imagePath;

    @NotNull(message = "Поле должно быть заполнено!")
    @Min(value = 0, message = "Значение 0 - второстепенное изображение.")
    @Max(value = 1, message = "Значение 1 - главное изображение.")
    private int primaryImage;
}
