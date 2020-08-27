package com.santor.library_simulate.controller;

import com.santor.library_simulate.dto.ClientDTO;
import com.santor.library_simulate.model.Client;
import com.santor.library_simulate.service.ClientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value="post")
@RequiredArgsConstructor
@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    ClientService clientService;

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


    @ApiOperation(value = "Get all client")
    @GetMapping("/")

    public List<ClientDTO> getAll() {

        return clientService.getAll();
    }

    @ApiOperation(value = "Get clients by id")
    @PostMapping("/getAllById")
    public List<ClientDTO> getAllById(@RequestBody Iterable<Long> ids) {

        return clientService.getAllById(ids);
    }

    @ApiOperation(value = "Get a client by id")
    @PostMapping("/getById")
    public ClientDTO getById(@RequestParam Long id) {

        return clientService.getById(id);
    }


    @ApiOperation(value = "Get clients by name")
    @PostMapping("/getByName")
    public List<ClientDTO> getByName(@RequestParam String fullName) {

        return clientService.getByName(fullName);
    }


    @ApiOperation(value = "Delete a client by name")
    @PostMapping("/deleteById")
    public String deleteByName(@RequestParam String fullName) {

        clientService.deleteByName(fullName);

        return "done";
    }


    @ApiOperation(value = "Delete all client")
    @PostMapping("/deleteAll")
    public String deleteAll() {

        clientService.deleteAll();
        return "done";
    }

    @ApiOperation(value = "Delete clients by id")
    @PostMapping("/deleteAllById")
    public String deleteAllById(@RequestParam Iterable<Long> ids) {

        clientService.deleteAllById(ids);
        return "done";
    }

    @ApiOperation(value = "Delete a client by id")
    @PostMapping("/deleteById")
    public String deleteById(@RequestParam Long id) {

        clientService.deleteById(id);

        return "done";
    }

    @ApiOperation(value = "Update a client")
    @PostMapping("/update")
    public String update(@RequestBody Client client) {

        clientService.update(client);

        return "done";
    }

    @ApiOperation(value = "Add a client")
    @PostMapping("/add")
    public String add(@RequestBody Client client) {

        clientService.add(client);

        return "done";
    }


}