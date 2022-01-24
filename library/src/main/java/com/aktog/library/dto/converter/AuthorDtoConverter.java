package com.aktog.library.dto.converter;

import com.aktog.library.dto.AuthorDto;
import com.aktog.library.entity.Author;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class AuthorDtoConverter extends DtoConverterHelper {
    public AuthorDto convert(Author from) {
        return new AuthorDto(
                from.getId(),
                from.getName(),
                from.getEmail(),
                from.getDateOfBirth(),
                from.getGender(),
                getBookDtoList(new ArrayList<>(Objects.requireNonNull(from.getBooks())))
        );
    }
    public List<AuthorDto> convert(List<Author> from){
        return from.stream().map(this::convert).collect(Collectors.toList());
    }

}