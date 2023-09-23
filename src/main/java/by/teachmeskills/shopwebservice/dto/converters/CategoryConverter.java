package by.teachmeskills.shopwebservice.dto.converters;

import by.teachmeskills.shopwebservice.domain.Category;
import by.teachmeskills.shopwebservice.dto.CategoryDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CategoryConverter {
    private final ProductConverter productConverter;

    public CategoryConverter(ProductConverter productConverter) {
        this.productConverter = productConverter;
    }

    public CategoryDto toDto(Category category) {
        return Optional.ofNullable(category).map(c -> CategoryDto.builder()
                        .id(c.getId())
                        .name(c.getName())
                        .products(Optional.ofNullable(c.getProducts()).map(products -> products.stream()
                                .map(productConverter::toDto).toList()).orElse(List.of()))
                        .build())
                .orElse(null);
    }

    public Category fromDto(CategoryDto categoryDto) {
        return Optional.ofNullable(categoryDto).map(cd -> Category.builder()
                        .name(cd.getName())
                        .build())
                .orElse(null);
    }
}
