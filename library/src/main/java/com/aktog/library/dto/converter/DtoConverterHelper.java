package com.aktog.library.dto.converter;

import com.aktog.library.dto.BookDto;
import com.aktog.library.dto.summarizeddto.SummarizedBookDto;
import com.aktog.library.entity.Author;
import com.aktog.library.entity.Book;

import java.util.List;
import java.util.stream.Collectors;

public class DtoConverterHelper {

    protected List<SummarizedBookDto> getFavoriteBookList(List<Book> favoriteBooks) {

        return favoriteBooks.stream().map(
                f -> new SummarizedBookDto(
                        f.getId(),
                        f.getTitle(),
                        f.getLanguage(),
                        f.getRate()
                        )
        ).collect(Collectors.toList());
    }

}