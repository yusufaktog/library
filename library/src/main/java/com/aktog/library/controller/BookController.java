package com.aktog.library.controller;

import com.aktog.library.dto.BookDto;
import com.aktog.library.dto.request.create.CreateBookRequest;
import com.aktog.library.dto.request.update.UpdateBookRequest;
import com.aktog.library.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/book")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    @GetMapping
    public ResponseEntity<List<BookDto>> getAllBooks(){
        return ResponseEntity.ok(new ArrayList<>(bookService.getAllBookDtoList()));
    }
    @GetMapping("/{bookId}")
    public ResponseEntity<BookDto> getBookById(@PathVariable String bookId){
        return ResponseEntity.ok(bookService.getBookById(bookId));
    }
    @PostMapping("/{authorId}")
    public ResponseEntity<BookDto> createBook(@PathVariable String authorId,@Valid @RequestBody CreateBookRequest request){
        return new ResponseEntity<>(bookService.createBook(authorId,request), HttpStatus.CREATED);
    }
    @DeleteMapping("/{bookId}")
    public ResponseEntity<String> deleteAuthor(@PathVariable String bookId){
        return new ResponseEntity<>(bookService.deleteBookById(bookId),HttpStatus.NO_CONTENT);
    }
    @PutMapping("/{bookId}")
    public ResponseEntity<BookDto> updateBook(@PathVariable String bookId, @Valid @RequestBody UpdateBookRequest request){
        return ResponseEntity.ok(bookService.updateBook(bookId,request));
    }
}