package ru.itgirl.library_project.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itgirl.library_project.dto.AuthorCreateDto;
import ru.itgirl.library_project.dto.AuthorDto;
import ru.itgirl.library_project.dto.AuthorUpdateDto;
import ru.itgirl.library_project.service.AuthorService;

@RestController
@RequiredArgsConstructor
public class AuthorController {
private final AuthorService authorService;


@GetMapping("/author/{id}")
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

@PostMapping("/author/create")
AuthorDto createAuthor(@RequestBody AuthorCreateDto authorCreateDto) {
return authorService.createAuthor(authorCreateDto);
}

@PutMapping("/author/update")
AuthorDto updateAuthor(@RequestBody AuthorUpdateDto authorUpdateDto) {
return authorService.updateAuthor(authorUpdateDto);
}

@DeleteMapping("/author/delete/{id}")
void deleteAuthor(@PathVariable("id") Long id) {
authorService.deleteAuthor(id);
}
}


//@Controller
//@RequiredArgsConstructor
//public class AuthorController {
    //private final AuthorService authorService;

    //@GetMapping("/authors")
    //String getAuthorsView(Model model) {
        //model.addAttribute("authors", authorService.getAllAuthors());
        //return "authors";
    //}
//}

