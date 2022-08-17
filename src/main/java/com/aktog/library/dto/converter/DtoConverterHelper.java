package com.aktog.library.dto.converter;

import com.aktog.library.dto.BookDto;
import com.aktog.library.dto.ReaderDto;
import com.aktog.library.entity.Book;
import com.aktog.library.entity.Reader;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class DtoConverterHelper {

    protected List<BookDto> getBookDtoList(List<Book> favoriteBooks) {

        return favoriteBooks.stream().map(
                book -> new BookDto(
                        book.getId(),
                        book.getBookmark(),
                        book.getContent(),
                        book.getTitle(),
                        book.getReleaseDate(),
                        book.getGenres(),
                        book.getImageUrl(),
                        book.getLanguage(),
                        book.getRate(),
                        Objects.requireNonNull(book.getAuthor().getId())
                )
        ).collect(Collectors.toList());
    }

    protected List<ReaderDto> getFriendDtoList(List<Reader> friends) {

        return friends.stream().map(
                f -> new ReaderDto(
                        f.getId(),
                        f.getName(),
                        f.getEmail(),
                        f.getGender(),
                        f.getDateOfBirth()
                )
        ).collect(Collectors.toList());
    }


}