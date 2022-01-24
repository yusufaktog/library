package com.aktog.library.service;

import com.aktog.library.dto.BookDto;
import com.aktog.library.dto.ReaderDto;
import com.aktog.library.dto.converter.ReaderDtoConverter;
import com.aktog.library.dto.request.create.CreateReaderRequest;
import com.aktog.library.dto.request.update.UpdateReaderRequest;
import com.aktog.library.entity.Book;
import com.aktog.library.entity.Reader;
import com.aktog.library.repository.ReaderRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class ReaderService {
    private final ReaderDtoConverter readerDtoConverter;
    private final ReaderRepository readerRepository;

    public ReaderService(ReaderDtoConverter readerDtoConverter, ReaderRepository readerRepository) {
        this.readerDtoConverter = readerDtoConverter;
        this.readerRepository = readerRepository;

    }

    public ReaderDto getReaderById(String id) {
        return readerDtoConverter.convert(findByReaderId(id));
    }

    public Reader findByReaderId(String id) {
        return readerRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Reader id: " + id + "not found"));

    }

    public String deleteReaderByID(String id) {
        return "Reader id: " + id + " deleted";
    }

    public ReaderDto createReader(CreateReaderRequest request) {
        Reader reader = new Reader(
                request.getName(),
                request.getEmail(),
                request.getGender(),
                request.getDateOfBirth()
        );
        return readerDtoConverter.convert(readerRepository.save(reader));
    }

    public List<ReaderDto> getAllBookDtoList() {
        return readerDtoConverter.convert(getAllBookList());
    }

    public List<Reader> getAllBookList() {
        return readerRepository.findAll();
    }

    public ReaderDto updateReader(String readerId, UpdateReaderRequest request) {
        Reader reader = findByReaderId(readerId);
        Reader updatedReader = new Reader(
                readerId,
                request.getName(),
                request.getEmail(),
                request.getGender(),
                reader.getDateOfBirth(),
                reader.getFavoriteBooks(),
                reader.getFriends()
        );
        return readerDtoConverter.convert(readerRepository.save(updatedReader));
    }
}