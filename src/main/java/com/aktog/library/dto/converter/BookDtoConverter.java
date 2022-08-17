package com.aktog.library.dto.converter;

import com.aktog.library.dto.BookDto;

import com.aktog.library.entity.Book;
import com.aktog.library.repository.AuthorRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class BookDtoConverter {

    public BookDto convert(Book from){
        return new BookDto(
                from.getId(),
                from.getBookmark(),
                from.getContent(),
                from.getTitle(),
                from.getReleaseDate(),
                from.getGenres(),
                from.getLanguage(),
                from.getImageUrl(),
                from.getRate(),
                Objects.requireNonNull(from.getAuthor().getId())

        );
    }
    public List<BookDto> convert(List<Book> from){
        return from.stream().map(this::convert).collect(Collectors.toList());
    }
}