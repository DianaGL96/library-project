package ru.itgirl.library_project.service;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.itgirl.library_project.dto.*;
import ru.itgirl.library_project.model.Author;
import ru.itgirl.library_project.model.Book;
import ru.itgirl.library_project.model.Genre;
import ru.itgirl.library_project.repository.AuthorRepository;
import ru.itgirl.library_project.repository.BookRepository;
import ru.itgirl.library_project.repository.GenreRepository;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    public final BookRepository bookRepository;
    private final GenreRepository genreRepository;
    private final AuthorRepository authorRepository;

    @Override
    public BookDto getByNameV1(String name) {
        Book book = bookRepository.findBookByName(name).orElseThrow();
        return convertEntityToDto(book);
    }


    @Override
    public BookDto getByNameV2(String name) {
        Book book = bookRepository.findBookByNameBySql(name).orElseThrow();
        return convertEntityToDto(book);
    }


    @Override
    public BookDto getByNameV3(String name) {
        Specification<Book> specification = Specification.where(new Specification<Book>() {
            @Override
            public Predicate toPredicate(Root<Book> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return cb.equal(root.get("name"), name);
            }
        });
        Book book = bookRepository.findOne(specification).orElseThrow();
        return convertEntityToDto(book);
    }

    @Override
    public BookDto createBook(BookCreateDto bookCreateDto) {
        Book book = bookRepository.save(convertDtoToEntity(bookCreateDto));
        return convertEntityToDto(book);
    }

    private Book convertDtoToEntity(BookCreateDto bookCreateDto) {
        Genre genre = genreRepository.findByName(bookCreateDto.getGenre())
                .orElseThrow(() -> new RuntimeException("Genre not found"));
        return Book.builder()
                .name(bookCreateDto.getName())
                .genre(genre)
                .build();
    }

    private BookDto convertEntityToDto(Book book) {
        return BookDto.builder()
                .id(book.getId())
                .name(book.getName())
                .genre(book.getGenre().getName())
                .build();

    }

    @Override
    public BookDto updateBook(BookUpdateDto bookUpdateDto) {
        Book book = bookRepository.findById(bookUpdateDto.getId()).orElseThrow();
        book.setName(bookUpdateDto.getName());
        //book.setGenre(bookUpdateDto.getGenre());
        Genre genre = genreRepository.findByName(bookUpdateDto.getGenre())
                .orElseThrow(() -> new RuntimeException("Genre not found"));
        book.setGenre(genre);
        Book savedBook = bookRepository.save(book);
        BookDto bookDto = convertEntityToDto(savedBook);
        return bookDto;
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }


}