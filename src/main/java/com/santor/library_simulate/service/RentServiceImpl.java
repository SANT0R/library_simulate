package com.santor.library_simulate.service;

import com.santor.library_simulate.dao.RentRepository;
import com.santor.library_simulate.dto.RentDTO;
import com.santor.library_simulate.exception.ApiRequestException;
import com.santor.library_simulate.mapper.RentMapper;
import com.santor.library_simulate.model.Book;
import com.santor.library_simulate.model.Rent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

/*
OK
public static final Response.Status OK
200 OK, see HTTP/1.1 documentation.
CREATED
public static final Response.Status CREATED
201 Created, see HTTP/1.1 documentation.
ACCEPTED
public static final Response.Status ACCEPTED
202 Accepted, see HTTP/1.1 documentation.
NO_CONTENT
public static final Response.Status NO_CONTENT
204 No Content, see HTTP/1.1 documentation.
RESET_CONTENT
public static final Response.Status RESET_CONTENT
205 Reset Content, see HTTP/1.1 documentation.
Since:
2.0
PARTIAL_CONTENT
public static final Response.Status PARTIAL_CONTENT
206 Reset Content, see HTTP/1.1 documentation.
Since:
2.0
MOVED_PERMANENTLY
public static final Response.Status MOVED_PERMANENTLY
301 Moved Permanently, see HTTP/1.1 documentation.
FOUND
public static final Response.Status FOUND
302 Found, see HTTP/1.1 documentation.
Since:
2.0
SEE_OTHER
public static final Response.Status SEE_OTHER
303 See Other, see HTTP/1.1 documentation.
NOT_MODIFIED
public static final Response.Status NOT_MODIFIED
304 Not Modified, see HTTP/1.1 documentation.
USE_PROXY
public static final Response.Status USE_PROXY
305 Use Proxy, see HTTP/1.1 documentation.
Since:
2.0
TEMPORARY_REDIRECT
public static final Response.Status TEMPORARY_REDIRECT
307 Temporary Redirect, see HTTP/1.1 documentation.
BAD_REQUEST
public static final Response.Status BAD_REQUEST
400 Bad Request, see HTTP/1.1 documentation.
UNAUTHORIZED
public static final Response.Status UNAUTHORIZED
401 Unauthorized, see HTTP/1.1 documentation.
PAYMENT_REQUIRED
public static final Response.Status PAYMENT_REQUIRED
402 Payment Required, see HTTP/1.1 documentation.
Since:
2.0
FORBIDDEN
public static final Response.Status FORBIDDEN
403 Forbidden, see HTTP/1.1 documentation.
NOT_FOUND
public static final Response.Status NOT_FOUND
404 Not Found, see HTTP/1.1 documentation.
METHOD_NOT_ALLOWED
public static final Response.Status METHOD_NOT_ALLOWED
405 Method Not Allowed, see HTTP/1.1 documentation.
Since:
2.0
NOT_ACCEPTABLE
public static final Response.Status NOT_ACCEPTABLE
406 Not Acceptable, see HTTP/1.1 documentation.
PROXY_AUTHENTICATION_REQUIRED
public static final Response.Status PROXY_AUTHENTICATION_REQUIRED
407 Proxy Authentication Required, see HTTP/1.1 documentation.
Since:
2.0
REQUEST_TIMEOUT
public static final Response.Status REQUEST_TIMEOUT
408 Request Timeout, see HTTP/1.1 documentation.
Since:
2.0
CONFLICT
public static final Response.Status CONFLICT
409 Conflict, see HTTP/1.1 documentation.
GONE
public static final Response.Status GONE
410 Gone, see HTTP/1.1 documentation.
LENGTH_REQUIRED
public static final Response.Status LENGTH_REQUIRED
411 Length Required, see HTTP/1.1 documentation.
Since:
2.0
PRECONDITION_FAILED
public static final Response.Status PRECONDITION_FAILED
412 Precondition Failed, see HTTP/1.1 documentation.
REQUEST_ENTITY_TOO_LARGE
public static final Response.Status REQUEST_ENTITY_TOO_LARGE
413 Request Entity Too Large, see HTTP/1.1 documentation.
Since:
2.0
REQUEST_URI_TOO_LONG
public static final Response.Status REQUEST_URI_TOO_LONG
414 Request-URI Too Long, see HTTP/1.1 documentation.
Since:
2.0
UNSUPPORTED_MEDIA_TYPE
public static final Response.Status UNSUPPORTED_MEDIA_TYPE
415 Unsupported Media Type, see HTTP/1.1 documentation.
REQUESTED_RANGE_NOT_SATISFIABLE
public static final Response.Status REQUESTED_RANGE_NOT_SATISFIABLE
416 Requested Range Not Satisfiable, see HTTP/1.1 documentation.
Since:
2.0
EXPECTATION_FAILED
public static final Response.Status EXPECTATION_FAILED
417 Expectation Failed, see HTTP/1.1 documentation.
Since:
2.0
INTERNAL_SERVER_ERROR
public static final Response.Status INTERNAL_SERVER_ERROR
500 Internal Server Error, see HTTP/1.1 documentation.
NOT_IMPLEMENTED
public static final Response.Status NOT_IMPLEMENTED
501 Not Implemented, see HTTP/1.1 documentation.
Since:
2.0
BAD_GATEWAY
public static final Response.Status BAD_GATEWAY
502 Bad Gateway, see HTTP/1.1 documentation.
Since:
2.0
SERVICE_UNAVAILABLE
public static final Response.Status SERVICE_UNAVAILABLE
503 Service Unavailable, see HTTP/1.1 documentation.
GATEWAY_TIMEOUT
public static final Response.Status GATEWAY_TIMEOUT
504 Gateway Timeout, see HTTP/1.1 documentation.
Since:
2.0
HTTP_VERSION_NOT_SUPPORTED
public static final Response.Status HTTP_VERSION_NOT_SUPPORTED
505 HTTP Version Not Supported, see HTTP/1.1 documentation.
Since:
2.0
Method Detail
values
public static Response.Status[] values()
Returns an array containing the constants of this enum type, in the order they are declared. This method may be used to iterate over the constants as follows:
for (Response.Status c : Response.Status.values())
    System.out.println(c);
Returns:
an array containing the constants of this enum type, in the order they are declared
valueOf
public static Response.Status valueOf(String name)
Returns the enum constant of this type with the specified name. The string must match exactly an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.)
Parameters:
name - the name of the enum constant to be returned.
Returns:
the enum constant with the specified name
Throws:
IllegalArgumentException - if this enum type has no constant with the specified name
NullPointerException - if the argument is null
getFamily
public Response.Status.Family getFamily()
Get the class of status code.
Specified by:
getFamily in interface Response.StatusType
Returns:
the class of status code.
getStatusCode
public int getStatusCode()
Get the associated status code.
Specified by:
getStatusCode in interface Response.StatusType
Returns:
the status code.
getReasonPhrase
public String getReasonPhrase()
Get the reason phrase.
Specified by:
getReasonPhrase in interface Response.StatusType
Returns:
the reason phrase.
toString
public String toString()
Get the reason phrase.
Overrides:
toString in class Enum<Response.Status>
Returns:
the reason phrase.
fromStatusCode
public static Response.Status fromStatusCode(int statusCode)
Convert a numerical status code into the corresponding Status.
Parameters:
statusCode - the numerical status code.
Returns:
the matching Status or null is no matching Status is defined.
 */
@Service
public class RentServiceImpl implements RentService {

    @Autowired
    RentRepository entityRepository;
    private RentMapper entityMapper;

    @Override
    public void add(Rent rent) {

        int pageSum = 0;
        for (Book book : rent.getBooks()) {
            pageSum += book.getPage();

            List<Long> bookIds = new ArrayList<>();

            for (Long id : bookIds) {
                if (book.getId()==null){

                    throw new ApiRequestException(book.getFullName()+
                            " adlı kitap bulunamadığı için kiralama işlemi tamamlanamadı.", HttpStatus.METHOD_NOT_ALLOWED);
                }
                if (book.getId().equals(id)) {

                    throw new ApiRequestException(book.getFullName()+
                            " kitabından birden fazla eklediğiniz için kiralama işlemi tamamlanamadı.", HttpStatus.METHOD_NOT_ALLOWED);

                }
                if (book.getStock()==0){

                    throw new ApiRequestException(book.getFullName()+
                            " kitabı stokta bulunmadığı için kiralama işlemi tamamlanamadı.", HttpStatus.NOT_FOUND);
                }
                else {
                    book.setStock(book.getStock()-1);
                }
            }
            bookIds.add(book.getId());
        }


        rent.setFinishDate(rent.getStartDate().plusDays(pageSum/5));

        entityRepository.save(rent);
    }

    @Override
    public void update(Rent rent) {

        Rent entity = entityRepository.getOne(rent.getId());
        if (entity.getId() != null) {

            entityRepository.save(rent);

        }
        else {

            throw new ApiRequestException(rent.getId()+
                    " id numaralı kira bulunamadığı için işleminiz tamamlanamadı.", HttpStatus.METHOD_NOT_ALLOWED);

        }

    }

    @Override
    public List<RentDTO> getAll() {


        return entityMapper.toDTOList(entityRepository.findAll());
    }



    @Override
    public RentDTO getById(Long id) {

        try {

            Rent entity = entityRepository.getOne(id);
            return entityMapper.toDTO (entity);
        }
        catch (EntityNotFoundException e){

            throw new ApiRequestException(id+
                    " id numaralı kira bulunamadığı için işleminiz tamamlanamadı.", HttpStatus.METHOD_NOT_ALLOWED);

        }

    }


    @Override
    public void deleteAll() {

        entityRepository.deleteAll();

    }

    @Override
    public void deleteById(Long id) {

        try {

            Rent entity = entityRepository.getOne(id);
            entityRepository.delete(entity);
        }
        catch (EntityNotFoundException e){

            throw new ApiRequestException(id+
                    " id numaralı kira bulunamadığı için işleminiz tamamlanamadı.", HttpStatus.METHOD_NOT_ALLOWED);

        }


    }


}