package by.teachmeskills.shopwebservice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private int id;

    @NotBlank(message = "Поле должно быть заполнено!")
    @Size(min = 3, message = "Имя не может содержать меньше 3 символов.")
    private String name;

    @NotBlank(message = "Поле должно быть заполнено!")
    @Size(min = 3, message = "Фамилия не может содержать меньше 3 символов.")
    private String surname;

    @Past
    private LocalDate birthday;
    private double balance;

    @Email(message = "Неверный формат email.")
    @NotBlank(message = "Поле должно быть заполнено!")
    private String email;

    @Pattern(regexp = "\\S+", message = "Пароль не должен содержать пробелы!")
    @NotBlank(message = "Поле должно быть заполнено!")
    private String password;
    private List<OrderDto> orders;
    private List<RoleDto> roles;
}
