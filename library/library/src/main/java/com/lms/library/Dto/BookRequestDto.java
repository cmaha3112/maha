package com.lms.library.Dto;

import lombok.Data;

@Data
public class BookRequestDto {
    private Integer id;
    private String bookName;
    private String bookAuthor;
    private String bookNo;
    private String bookType;
}
