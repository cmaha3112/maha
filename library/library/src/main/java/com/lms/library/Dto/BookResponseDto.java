package com.lms.library.Dto;

import lombok.Data;

@Data
public class BookResponseDto {
    private Integer id;
    private String bookName;
    private String bookAuthor;
    private String bookNo;
    private String bookType;
}
