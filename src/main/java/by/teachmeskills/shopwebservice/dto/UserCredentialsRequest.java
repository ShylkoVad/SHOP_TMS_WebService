package by.teachmeskills.shopwebservice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCredentialsRequest {
    @Email(message = "Неверный формат email.")
    @NotBlank(message = "Поле должно быть заполнено!")
    private String login;

    @Pattern(regexp = "\\S+", message = "Пароль не должен содержать пробелы!")
    @NotBlank(message = "Поле должно быть заполнено!")
    private String password;
}
