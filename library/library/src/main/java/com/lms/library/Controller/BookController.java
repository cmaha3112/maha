package com.lms.library.Controller;

import com.lms.library.Dto.BookRequestDto;
import com.lms.library.Dto.BookResponseDto;
import com.lms.library.Service.BookService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    BookService bookService;

    @PostMapping("/addBook")
    public ResponseEntity<String> addBook(@RequestBody BookRequestDto book){
        return ResponseEntity.ok(bookService.addBook(book));

    }

    @PutMapping("/updateBook")
    public ResponseEntity<String> updateBook(@RequestBody BookRequestDto book){
        return ResponseEntity.ok(bookService.updateBook(book));
    }
    @GetMapping("/getBooks")
    public ResponseEntity<List<BookResponseDto>> getBooks(){
        return ResponseEntity.ok(bookService.getBooks());
    }
    @GetMapping("/getById")
    public ResponseEntity<BookResponseDto> getById(@RequestParam Integer id){
        return ResponseEntity.ok(bookService.getById(id));
    }

    @DeleteMapping("/deleteBook")
    public ResponseEntity<String> deleteBook(@RequestParam Integer id){
        return ResponseEntity.ok(bookService.deleteBook(id));
    }

}
