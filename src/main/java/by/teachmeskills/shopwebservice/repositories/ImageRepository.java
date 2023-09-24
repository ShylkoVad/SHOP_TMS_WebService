package by.teachmeskills.shopwebservice.repositories;

import by.teachmeskills.shopwebservice.domain.Image;

import java.util.List;

public interface ImageRepository {
    Image findById(int id);

    List<Image> findAll();

    Image createOrUpdate(Image image);

    void delete(int id);
}
