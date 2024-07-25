package ru.itgirl.library_project.service;

import org.springframework.data.jpa.repository.Query;
import ru.itgirl.library_project.dto.AuthorCreateDto;
import ru.itgirl.library_project.dto.AuthorDto;
import ru.itgirl.library_project.dto.BookCreateDto;
import ru.itgirl.library_project.dto.BookDto;
import ru.itgirl.library_project.model.Book;

import java.util.Optional;

public interface BookService {
    BookDto getByNameV1(String name);
    BookDto getByNameV2(String name);
    BookDto getByNameV3(String name);

    BookDto createBook(BookCreateDto bookCreateDto);

}
