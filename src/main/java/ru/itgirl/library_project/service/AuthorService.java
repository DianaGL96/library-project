package ru.itgirl.library_project.service;

import ru.itgirl.library_project.dto.AuthorCreateDto;
import ru.itgirl.library_project.dto.AuthorDto;
import ru.itgirl.library_project.dto.AuthorUpdateDto;

public interface AuthorService {
    AuthorDto getAuthorById(Long id);
    AuthorDto getByNameV4(String name);
    AuthorDto getByNameV5(String name);

    AuthorDto createAuthor(AuthorCreateDto authorCreateDto);
    AuthorDto updateAuthor (AuthorUpdateDto authorUpdateDto);

    void deleteAuthor (Long id);
}

