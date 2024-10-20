package com.lms.library.Service;

import com.lms.library.Dto.BookRequestDto;
import com.lms.library.Dto.BookResponseDto;
import com.lms.library.Model.Book;
import com.lms.library.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;
    public String addBook(BookRequestDto bookRequestDto) {
       Book book=new Book();
       book.setBookName(bookRequestDto.getBookName());
       book.setBookAuthor(bookRequestDto.getBookAuthor());
       book.setBookType(bookRequestDto.getBookType());
       book.setBookNo(bookRequestDto.getBookNo());
       bookRepository.save(book);
       return "book added Successfully";
    }


    public String updateBook(BookRequestDto bookRequestDto) {
     Book book=bookRepository.findById(bookRequestDto.getId()).orElseThrow();
     book.setBookName(bookRequestDto.getBookName());
     book.setBookAuthor(bookRequestDto.getBookAuthor());
     book.setBookType(bookRequestDto.getBookType());
     book.setBookNo(bookRequestDto.getBookNo());
     bookRepository.save(book);
     return "book Updated Successfully";
    }

    public String deleteBook(Integer id) {
        bookRepository.deleteById(id);
        return "Book deleted successfully";
    }

    public List<BookResponseDto> getBooks() {
        List<Book> book=bookRepository.findAll();
        List<BookResponseDto> allbooks=new ArrayList<>();
        book.forEach(books->allbooks.add(convertoResponseDto(books)));
        return allbooks;


    }

    private BookResponseDto convertoResponseDto(Book books) {
        BookResponseDto responseDto=new BookResponseDto();
        responseDto.setId(books.getId());
        responseDto.setBookAuthor(books.getBookAuthor());
        responseDto.setBookName(books.getBookName());
        responseDto.setBookType(books.getBookType());
        responseDto.setBookNo(books.getBookNo());
        return responseDto;
    }
    

    public BookResponseDto getById(Integer id) {
      Book book= bookRepository.findById(id).orElseThrow();
        return convertoResponseDto(book);
    }
}
