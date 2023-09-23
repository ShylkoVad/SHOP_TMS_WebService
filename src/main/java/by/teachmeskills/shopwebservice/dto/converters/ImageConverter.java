package by.teachmeskills.shopwebservice.dto.converters;

import by.teachmeskills.shopwebservice.domain.Image;
import by.teachmeskills.shopwebservice.dto.ImageDto;
import org.springframework.stereotype.Component;

@Component
public class ImageConverter {
    public ImageDto toDto(Image image) {
        return ImageDto.builder()
                .id(image.getId())
                .imagePath(image.getImagePath())
                .primaryImage(image.getPrimaryImage())
                .build();
    }

    public Image fromDto(ImageDto imageDto) {
        return Image.builder()
                .imagePath(imageDto.getImagePath())
                .primaryImage(imageDto.getPrimaryImage())
                .build();
    }
}
