package ru.itgirl.library_project.service;

import ru.itgirl.library_project.dto.AuthorCreateDto;
import ru.itgirl.library_project.dto.AuthorDto;

import java.util.List;

public interface AuthorService {
    AuthorDto getAuthorById(Long id);
    AuthorDto getByNameV4(String name);
    AuthorDto getByNameV5(String name);

    AuthorDto createAuthor(AuthorCreateDto authorCreateDto);
}

