package com.aktog.library.dto.converter;

import com.aktog.library.dto.BookDto;
import com.aktog.library.dto.ReaderDto;
import com.aktog.library.entity.Book;
import com.aktog.library.entity.Reader;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class ReaderDtoConverter extends DtoConverterHelper {
    public ReaderDto convert(Reader from) {
        return new ReaderDto(
                from.getId(),
                from.getName(),
                from.getEmail(),
                from.getGender(),
                from.getDateOfBirth(),
                getBookDtoList(new ArrayList<>(Objects.requireNonNull(from.getFavoriteBooks()))),
                getFriendDtoList(new ArrayList<>(Objects.requireNonNull(from.getFriends())))

        );

    }

    public List<ReaderDto> convert(List<Reader> from) {
        return from.stream().map(this::convert).collect(Collectors.toList());
    }


}