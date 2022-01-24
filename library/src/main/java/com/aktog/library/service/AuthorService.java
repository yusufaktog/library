package com.aktog.library.service;

import com.aktog.library.dto.AuthorDto;
import com.aktog.library.dto.converter.AuthorDtoConverter;
import com.aktog.library.dto.request.create.CreateAuthorRequest;
import com.aktog.library.dto.request.update.UpdateAuthorRequest;
import com.aktog.library.entity.Author;
import com.aktog.library.repository.AuthorRepository;
import javassist.NotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;
    private final AuthorDtoConverter authorDtoConverter;

    public AuthorService(AuthorRepository authorRepository, AuthorDtoConverter authorDtoConverter) {
        this.authorRepository = authorRepository;
        this.authorDtoConverter = authorDtoConverter;
    }

    public AuthorDto getAuthorById(String id) {
        return authorDtoConverter.convert(findByAuthorId(id));
    }

    public Author findByAuthorId(String id) {
        return authorRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Author id: " + id + "not found"));
    }

    public String deleteAuthorById(String id) {
        findByAuthorId(id);
        return "Author id: " + id + " deleted";
    }

    public AuthorDto createAuthor(CreateAuthorRequest request) {
        Author author = new Author(
                request.getName(),
                request.getEmail(),
                request.getDateOfBirth(),
                request.getGender()

        );
        return authorDtoConverter.convert(authorRepository.save(author));
    }
    public List<AuthorDto> getAllAuthorDtoList() {
        return authorDtoConverter.convert(getAllAuthorList());
    }

    public List<Author> getAllAuthorList() {
        return authorRepository.findAll();
    }

    public AuthorDto updateAuthor(String id, UpdateAuthorRequest request){
        Author author = findByAuthorId(id);
        Author updatedAuthor = new Author(
                author.getId(),
                request.getName(),
                request.getEmail(),
                author.getDateOfBirth(),
                request.getGender(),
                request.getBooks()

        );
        return authorDtoConverter.convert(authorRepository.save(updatedAuthor));
    }


}