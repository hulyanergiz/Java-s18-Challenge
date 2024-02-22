package com.workintech.library.dto;


public record BookResponse(long id, String name, String categoryName, AuthorResponse authorResponse) {
}
