package com.santor.library_simulate.controller;

import com.santor.library_simulate.dto.ClientDTO;
import com.santor.library_simulate.exception.ApiRequestException;
import com.santor.library_simulate.model.Client;
import com.santor.library_simulate.service.ClientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ServerErrorException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Api(value="post")
@RequiredArgsConstructor
@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    ClientService entityService;

    @ApiResponses(value = {
            // 1xx Informational
            @ApiResponse(code = 100, message = "Continue"),
            @ApiResponse(code = 101, message = "Switching Protocols"),
            @ApiResponse(code = 102, message = "Processing (WebDAV)"),
            //2xx Success
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 201, message = "Created"),
            @ApiResponse(code = 202, message = "Accepted"),
            @ApiResponse(code = 203, message = "Non-Authoritative Information"),
            @ApiResponse(code = 204, message = "No Content"),
            @ApiResponse(code = 205, message = "Reset Content"),
            @ApiResponse(code = 206, message = "Partial Content"),
            @ApiResponse(code = 207, message = "Multi-Status (WebDAV)"),
            @ApiResponse(code = 208, message = "Already Reported (WebDAV)"),
            @ApiResponse(code = 226, message = "IM Used"),
            //3xx Redirection
            @ApiResponse(code = 300, message = "Multiple Choices"),
            @ApiResponse(code = 301, message = "Moved Permanently"),
            @ApiResponse(code = 302, message = "Found"),
            @ApiResponse(code = 303, message = "See Other"),
            @ApiResponse(code = 304, message = "Not Modified"),
            @ApiResponse(code = 305, message = "Use Proxy"),
            @ApiResponse(code = 306, message = "Unused"),
            @ApiResponse(code = 307, message = "Temporary Redirect"),
            @ApiResponse(code = 308, message = "Permanent Redirect (experimental)"),
            //4xx Client Error
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 405, message = "Method Not Allowed"),
            @ApiResponse(code = 406, message = "Not Acceptable"),
            @ApiResponse(code = 407, message = "Proxy Authentication Required"),
            @ApiResponse(code = 408, message = "Request Timeout"),
            @ApiResponse(code = 409, message = "Conflict"),
            @ApiResponse(code = 410, message = "Gone"),
            @ApiResponse(code = 411, message = "Length Required"),
            @ApiResponse(code = 412, message = "Precondition Failed"),
            @ApiResponse(code = 413, message = " Request Entity Too Large"),
            @ApiResponse(code = 414, message = "Request-URI Too Long"),
            @ApiResponse(code = 415, message = "Unsupported Media Type"),
            @ApiResponse(code = 416, message = "Requested Range Not Satisfiable"),
            @ApiResponse(code = 417, message = "Expectation Failed"),
            @ApiResponse(code = 418, message = "I'm a teapot (RFC 2324)"),
            @ApiResponse(code = 420, message = "Enhance Your Calm (Twitter)"),
            @ApiResponse(code = 422, message = "Unprocessable Entity (WebDAV)"),
            @ApiResponse(code = 423, message = "Locked (WebDAV)"),
            @ApiResponse(code = 424, message = "Failed Dependency (WebDAV)"),
            @ApiResponse(code = 425, message = "Reserved for WebDAV"),
            @ApiResponse(code = 426, message = "Upgrade Required"),
            @ApiResponse(code = 428, message = "Precondition Required"),
            @ApiResponse(code = 429, message = "Too Many Requests"),
            @ApiResponse(code = 431, message = "Request Header Fields Too Large"),
            @ApiResponse(code = 444, message = "No Response (Nginx)"),
            @ApiResponse(code = 449, message = "Retry With (Microsoft)"),
            @ApiResponse(code = 450, message = "Blocked by Windows Parental Controls (Microsoft)"),
            @ApiResponse(code = 451, message = "Unavailable For Legal Reasons"),
            @ApiResponse(code = 499, message = "Client Closed Request (Nginx)"),
            //5xx Server Error
            @ApiResponse(code = 500, message = "Internal Server Error"),
            @ApiResponse(code = 501, message = "Not Implemented"),
            @ApiResponse(code = 502, message = "Bad Gateway"),
            @ApiResponse(code = 503, message = "Service Unavailable"),
            @ApiResponse(code = 504, message = "Gateway Timeout"),
            @ApiResponse(code = 505, message = "HTTP Version Not Supported"),
            @ApiResponse(code = 506, message = "Variant Also Negotiates (Experimental)"),
            @ApiResponse(code = 507, message = "Insufficient Storage (WebDAV)"),
            @ApiResponse(code = 508, message = "Loop Detected (WebDAV)"),
            @ApiResponse(code = 509, message = "Bandwidth Limit Exceeded (Apache)"),
            @ApiResponse(code = 510, message = "Not Extended"),
            @ApiResponse(code = 511, message = "Network Authentication Required"),
            @ApiResponse(code = 598, message = "Network read timeout error"),
            @ApiResponse(code = 599, message = "Network connect timeout error"),

    }
    )



    @ApiOperation(value = "Get all clients")
    @GetMapping("/")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<ClientDTO>> getAll()  {

        try {

            List<ClientDTO> entityDTOList =entityService.getAll();

            if (entityDTOList.isEmpty()) {

                throw new ApiRequestException(
                        "No client found.",
                        HttpStatus.NOT_FOUND);

            } else {
                return ResponseEntity.ok(entityDTOList);

            }

        }
        catch (ServerErrorException e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }


    @ApiOperation(value = "Get a client by id")
    @GetMapping("/getById")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<ClientDTO> getById(@RequestParam Long id) {

        try {

            return ResponseEntity.ok(entityService.getById(id));

        }
        catch (ServerErrorException e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }


    @ApiOperation(value = "Get user")
    @PutMapping("/getMe")
    @PreAuthorize("hasRole('ROLE_CLIENT')")
    public ResponseEntity<ClientDTO> getMe(@RequestBody Client entity) {


        Object thisUser = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (thisUser instanceof UserDetails) {
            String username = ((UserDetails)thisUser).getUsername();

            if (username.equals(entity.getUserName())){

                return ResponseEntity.ok(entityService.getById(entity.getId()));
            }

            else {

                throw new ApiRequestException(
                        "Forbidden call ",
                        HttpStatus.FORBIDDEN);

            }
        } else {
            String username = thisUser.toString();

            if (username.equals(entity.getUserName())){

                return ResponseEntity.ok(entityService.getById(entity.getId()));
            }

            else {

                throw new ApiRequestException(
                        "Forbidden call ",
                        HttpStatus.FORBIDDEN);

            }
        }

    }


    @ApiOperation(value = "Get clients by name")
    @GetMapping("/getByName")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<ClientDTO>> getByName(@RequestParam String fullName) {

        try {

            return ResponseEntity.ok(entityService.getByName(fullName));

        }
        catch (ServerErrorException e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }


    @ApiOperation(value = "Delete a client by name")
    @DeleteMapping("/deleteByName")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> deleteByName(@RequestParam String fullName) {

        try {

            entityService.deleteByName(fullName);
            return ResponseEntity.ok().build();

        }
        catch (ServerErrorException e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }


    @ApiOperation(value = "Delete user")
    @PutMapping("/deleteMe")
    @PreAuthorize("hasRole('ROLE_CLIENT')")
    public ResponseEntity<URI> deleteMe(@RequestBody Client entity) {


        Object thisUser = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (thisUser instanceof UserDetails) {
            String username = ((UserDetails)thisUser).getUsername();

            if (username.equals(entity.getUserName())){

                entityService.deleteById(entity.getId());
                return ResponseEntity.ok().build();
            }

            else {

                throw new ApiRequestException(
                        "Forbidden call ",
                        HttpStatus.FORBIDDEN);

            }
        } else {
            String username = thisUser.toString();

            if (username.equals(entity.getUserName())){

                entityService.deleteById(entity.getId());
                return ResponseEntity.ok().build();
            }

            else {

                throw new ApiRequestException(
                        "Forbidden call ",
                        HttpStatus.FORBIDDEN);

            }
        }

    }





    @ApiOperation(value = "Delete all clients")
    @DeleteMapping("/deleteAll")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> deleteAll() {

        try {

            List<ClientDTO> entityDTOList =entityService.getAll();

            if (entityDTOList.isEmpty()) {

                throw new ApiRequestException(
                        "No client found.",
                        HttpStatus.NOT_FOUND);

            } else {
                entityService.deleteAll();
                return ResponseEntity.ok().build();

            }

        }
        catch (ServerErrorException e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }


    @ApiOperation(value = "Delete a client by id")
    @DeleteMapping("/deleteById")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?>  deleteById(@RequestParam Long id) {

        try {

            entityService.deleteById(id);
            return ResponseEntity.ok().build();

        }
        catch (ServerErrorException e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }


    @ApiOperation(value = "Update a client")
    @PutMapping("/update")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<URI> update(@RequestBody Client entity) {

        try {
            entityService.update(entity);
            String fullName = entity.getFullName();
            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{fullName}").buildAndExpand(fullName).toUri();

            return ResponseEntity.created(location).build();
        } catch (ServerErrorException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @ApiOperation(value = "Update user")
    @PutMapping("/updateMe")
    @PreAuthorize("hasRole('ROLE_CLIENT')")
    public ResponseEntity<URI> updateMe(@RequestBody Client entity) {


        Object thisUser = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (thisUser instanceof UserDetails) {
            String username = ((UserDetails)thisUser).getUsername();

            if (username.equals(entity.getUserName())){

                entityService.update(entity);
                URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{username}").buildAndExpand(username).toUri();

                return ResponseEntity.created(location).build();
            }

            else {

                throw new ApiRequestException(
                        "Forbidden call ",
                        HttpStatus.FORBIDDEN);

            }
        }
        else {
            String username = thisUser.toString();

            if (username.equals(entity.getUserName())){

                entityService.update(entity);
                URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{username}").buildAndExpand(username).toUri();

                return ResponseEntity.created(location).build();
            }

            else {

                throw new ApiRequestException(
                        "Forbidden call ",
                        HttpStatus.FORBIDDEN);

            }
        }

    }


    @ApiOperation(value = "Add a client")
    @PostMapping("/add")
    @PreAuthorize("permitAll()")
    public ResponseEntity<URI> add(@RequestBody Client entity) {

        try {
            entityService.add(entity);
            String fullName = entity.getFullName();
            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{fullName}").buildAndExpand(fullName).toUri();

            return ResponseEntity.created(location).build();
        } catch (ServerErrorException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}