package ru.itgirl.library_project.service;

import org.springframework.data.jpa.repository.Query;
import ru.itgirl.library_project.dto.BookDto;
import ru.itgirl.library_project.model.Book;

import java.util.Optional;

public interface BookService {
    BookDto getByNameV1(String name);
    BookDto getByNameV2(String name);
    BookDto getByNameV3(String name);

}
