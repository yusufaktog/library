package com.aktog.library.controller;

import com.aktog.library.dto.ReaderDto;
import com.aktog.library.dto.request.create.CreateReaderRequest;
import com.aktog.library.dto.request.update.UpdateReaderRequest;
import com.aktog.library.service.ReaderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/reader")
public class ReaderController {
    private final ReaderService readerService;

    public ReaderController(ReaderService readerService) {
        this.readerService = readerService;
    }

    @GetMapping
    public ResponseEntity<List<ReaderDto>> getAllReaders() {
        return ResponseEntity.ok(new ArrayList<>(readerService.getAllReaderDtoList()));
    }

    @GetMapping("/{readerId}")
    public ResponseEntity<ReaderDto> getReaderById(@PathVariable String readerId) {
        return ResponseEntity.ok(readerService.getReaderById(readerId));
    }

    @PostMapping
    public ResponseEntity<ReaderDto> createReader(@Valid @RequestBody CreateReaderRequest request) {
        return new ResponseEntity<>(readerService.createReader(request), HttpStatus.CREATED);
    }

    @DeleteMapping("/{readerId}")
    public ResponseEntity<String> deleteReader(@PathVariable String readerId) {
        return new ResponseEntity<>(readerService.deleteReaderById(readerId),HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{readerId}")
    public ResponseEntity<ReaderDto> updateReader(@PathVariable String readerId, @Valid @RequestBody UpdateReaderRequest request) {

        return ResponseEntity.ok(readerService.updateReader(readerId, request));
    }
}