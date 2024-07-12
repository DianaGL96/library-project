package ru.itgirl.library_project.service;

import ru.itgirl.library_project.dto.AuthorDto;

public interface AuthorService {
    AuthorDto getAuthorById(Long id);
    AuthorDto getByNameV4(String name);
    AuthorDto getByNameV5(String name);
}
