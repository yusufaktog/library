package com.aktog.library.dto.converter;

import com.aktog.library.dto.BookDto;
import com.aktog.library.dto.ReaderDto;
import com.aktog.library.entity.Book;
import com.aktog.library.entity.Reader;

import java.util.List;
import java.util.stream.Collectors;

public class DtoConverterHelper {

    protected List<BookDto> getBookDtoList(List<Book> favoriteBooks) {

        return favoriteBooks.stream().map(
                f -> new BookDto(
                        f.getId(),
                        f.getBookmark(),
                        f.getContent(),
                        f.getTitle(),
                        f.getReleaseDate(),
                        f.getGenres(),
                        f.getImageUrl(),
                        f.getLanguage(),
                        f.getRate()
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