package com.aktog.library.dto.converter;

import com.aktog.library.dto.AuthorDto;
import com.aktog.library.dto.BookDto;

import com.aktog.library.entity.Author;
import com.aktog.library.entity.Book;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookDtoConverter {
    private final AuthorDtoConverter authorDtoConverter;

    public BookDtoConverter(AuthorDtoConverter authorDtoConverter) {
        this.authorDtoConverter = authorDtoConverter;
    }

    public BookDto convert(Book from){
        return new BookDto(
                from.getId(),
                from.getBookmark(),
                from.getTitle(),
                from.getContent(),
                from.getReleaseDate(),
                from.getGenres(),
                from.getLanguage(),
                from.getImageUrl(),
                from.getRate(),
                authorDtoConverter.convert(from.getAuthor())

        );
    }
    public List<BookDto> convert(List<Book> from){
        return from.stream().map(this::convert).collect(Collectors.toList());
    }
}