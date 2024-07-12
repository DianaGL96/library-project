package ru.itgirl.library_project.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.itgirl.library_project.dto.AuthorDto;
import ru.itgirl.library_project.dto.BookDto;
import ru.itgirl.library_project.dto.GenreDto;
import ru.itgirl.library_project.service.AuthorService;
import ru.itgirl.library_project.service.GenreService;

@RestController
@RequiredArgsConstructor
public class AuthorController {
    private final AuthorService authorService;

    @GetMapping("/author/all")
    AuthorDto getAuthorById(@PathVariable("id") Long id) {
        return authorService.getAuthorById(id);
    }

    @GetMapping("/author/v4")
    AuthorDto getAuthorByNameV4(@RequestParam("name") String name) {
        return authorService.getByNameV4(name);
    }

    @GetMapping("/author/v5")
    AuthorDto getAuthorByNameV5(@RequestParam("name") String name) {
        return authorService.getByNameV5(name);
    }
}
