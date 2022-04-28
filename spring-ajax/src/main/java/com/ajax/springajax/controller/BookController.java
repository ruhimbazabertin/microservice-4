package com.ajax.springajax.controller;

import com.ajax.springajax.dto.Book;
import com.ajax.springajax.dto.ServiceResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@ResponseBody
public class BookController {
    List<Book> bookStore = new ArrayList<Book>();
    @PostMapping("/createBook")
    public ResponseEntity<Object> addBook(@RequestBody Book book){
    bookStore.add(book);
    ServiceResponse<Book> response = new ServiceResponse<Book>("success", book);
    return  new ResponseEntity<Object>(response,HttpStatus.OK);
    }
    @GetMapping("/all")
    public ResponseEntity<Object> getAllBook(){
        ServiceResponse<List<Book>> response = new ServiceResponse<>("success", bookStore);
        return  new ResponseEntity<Object>(HttpStatus.OK);
    }
    @GetMapping("/getTime")
    public String findTime(){
    Date date = new Date();
    return String.valueOf(date);
    }
}
