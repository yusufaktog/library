package com.aktog.library.service;

import com.aktog.library.dto.AuthorDto;
import com.aktog.library.dto.BookDto;
import com.aktog.library.dto.converter.AuthorDtoConverter;
import com.aktog.library.dto.converter.BookDtoConverter;
import com.aktog.library.dto.request.create.CreateBookRequest;
import com.aktog.library.dto.request.update.UpdateAuthorRequest;
import com.aktog.library.dto.request.update.UpdateBookRequest;
import com.aktog.library.entity.Author;
import com.aktog.library.entity.Book;
import com.aktog.library.repository.BookRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class BookService {
    private final BookDtoConverter bookDtoConverter;
    private final BookRepository bookRepository;
    private final AuthorService authorService;

    public BookService(BookRepository bookRepository, BookDtoConverter bookDtoConverter, AuthorService authorService) {
        this.bookDtoConverter = bookDtoConverter;
        this.bookRepository = bookRepository;

        this.authorService = authorService;
    }

    public BookDto getBookById(String id) {
        return bookDtoConverter.convert(findByBookId(id));
    }

    public Book findByBookId(String id) {
        return bookRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Book id: " + id + "not found"));

    }

    public String deleteBookById(String id) {
        return "Book id: " + id + " deleted";
    }

    public BookDto createBook(String authorId, CreateBookRequest request) {
        Author author = authorService.findByAuthorId(authorId);
        Book book = new Book(
                request.getTitle(),
                request.getContent(),
                request.getReleaseDate(),
                request.getLanguage(),
                request.getGenres(),
                request.getImageUrl(),
                request.getRate(),
                author

        );
        return bookDtoConverter.convert(bookRepository.save(book));
    }

    public List<BookDto> getAllBookDtoList() {
        return bookDtoConverter.convert(getAllBookList());
    }

    public List<Book> getAllBookList() {
        return bookRepository.findAll();
    }

    public BookDto updateBook(String bookId, UpdateBookRequest request) {
        Book book = findByBookId(bookId);

        Book updatedBook = new Book(
                bookId,
                request.getTitle(),
                book.getContent(),
                request.getBookmark(),
                book.getReleaseDate(),
                book.getLanguage(),
                book.getGenres(),
                request.getImageUrl(),
                request.getRate(),
                book.getAuthor()

        );
        return bookDtoConverter.convert(bookRepository.save(updatedBook));

    }

}

