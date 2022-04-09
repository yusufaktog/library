package com.aktog.library.controller;


import com.aktog.library.dto.AuthorDto;
import com.aktog.library.dto.request.create.CreateAuthorRequest;
import com.aktog.library.dto.request.update.UpdateAuthorRequest;
import com.aktog.library.service.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/author")
public class AuthorController {
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public ResponseEntity<List<AuthorDto>> getAllAuthors() {
        return ResponseEntity.ok(new ArrayList<>(authorService.getAllAuthorDtoList()));
    }

    @GetMapping("/{authorId}")
    public ResponseEntity<AuthorDto> getAuthorById(@PathVariable String authorId) {
        return ResponseEntity.ok(authorService.getAuthorById(authorId));
    }

    @PostMapping
    public ResponseEntity<AuthorDto> createAuthor(@Valid @RequestBody CreateAuthorRequest request) {
        return new ResponseEntity<>(authorService.createAuthor(request), HttpStatus.CREATED);
    }

    @DeleteMapping("/{authorId}")
    public ResponseEntity<String> deleteAuthor(@PathVariable String authorId) {
        return new ResponseEntity<>(authorService.deleteAuthorById(authorId),HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{authorId}")
    public ResponseEntity<AuthorDto> updateAuthor(@PathVariable String authorId, @Valid @RequestBody UpdateAuthorRequest request) {
        return ResponseEntity.ok(authorService.updateAuthor(authorId, request));
    }
}