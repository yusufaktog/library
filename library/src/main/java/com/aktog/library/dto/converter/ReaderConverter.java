package com.aktog.library.dto.converter;

import com.aktog.library.dto.BookDto;
import com.aktog.library.dto.ReaderDto;
import com.aktog.library.entity.Book;
import com.aktog.library.entity.Reader;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ReaderConverter extends DtoConverterHelper{
    public ReaderDto convert(Reader from) {
        return new ReaderDto(
                from.getId(),
                from.getName(),
                from.getEmail(),
                from.getGender(),
                from.getDateOfBirth(),
                getFavoriteBookList(new ArrayList<>(from.getFavoriteBooks())),
                new ArrayList<>()

        );

    }


}