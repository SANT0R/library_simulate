package com.santor.library_simulate.service;


import com.santor.library_simulate.dao.BookRepository;
import com.santor.library_simulate.dto.BookDTO;
import com.santor.library_simulate.exception.ApiRequestException;
import com.santor.library_simulate.mapper.BookMapper;
import com.santor.library_simulate.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository entityRepository;


    private BookMapper entityMapper;


    @Override
    public void add(BookDTO book) {

        entityRepository.save(entityMapper.toEntity(book));

    }

    @Override
    public void update(BookDTO book) {

        Book entity = entityRepository.getOne(book.getId());
        if (entity.getId() != null) {

            entityRepository.save(entityMapper.toEntity(book));

        }
        else {

            throw new ApiRequestException(
                    "Your operation could not be completed because the book number " + entity.getId() +" id could not be found.",
                    HttpStatus.METHOD_NOT_ALLOWED);
        }

    }

    @Override
    public List<BookDTO> getAll(Boolean atStock) {

        List<Book> books;

        books = entityRepository.findAll();
        if (atStock) {
            books.removeIf(book -> book.getStock() == 0);
        }
        return entityMapper.toDTOList(books);
    }



    @Override
    public BookDTO getById(Long id) {

        Book entity = entityRepository.getOne(id);

        if (entity != null){

            return entityMapper.toDTO (entity);
        }
        else {

            throw new ApiRequestException(
                    "Your operation could not be completed because the book number " + id +" id could not be found.",
                    HttpStatus.METHOD_NOT_ALLOWED);
        }

    }

    @Override
    public List<BookDTO> getByName(String fullName) {

        List<Book> books = entityRepository.findByFullNameContains(fullName);

        return entityMapper.toDTOList (books);

    }

    @Override
    public void deleteByName(String fullName) {


        Book entity = entityRepository.findByFullName(fullName);

        if (entity != null){

            entityRepository.delete(entity);
        }
        else {

            throw new ApiRequestException(
                    "Your operation could not be completed because the book named " + fullName +" could not be found.",
                    HttpStatus.METHOD_NOT_ALLOWED);
        }

    }

    @Override
    public void deleteAll() {

        entityRepository.deleteAll();

    }

    @Override
    public void deleteById(Long id) {

        Book entity = entityRepository.getOne(id);

        if (entity != null){

            entityRepository.delete(entity);
        }
        else {

            throw new ApiRequestException(
                    "Your operation could not be completed because the book number " + id +" id could not be found.",
                    HttpStatus.METHOD_NOT_ALLOWED);
        }


    }


}