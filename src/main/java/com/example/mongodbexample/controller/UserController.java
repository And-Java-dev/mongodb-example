package com.example.mongodbexample.controller;

import com.example.mongodbexample.model.Book;
import com.example.mongodbexample.model.User;
import com.example.mongodbexample.repository.BookRepository;
import com.example.mongodbexample.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    private final UserRepository userRepository;
    private final BookRepository bookRepository;

    public UserController(UserRepository userRepository, BookRepository bookRepository) {
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
    }

    @GetMapping("/")
    public String main(ModelMap modelMap){
        modelMap.addAttribute("users",userRepository.findAll());
        return "index";
    }

    @PostMapping("/add/user")
    public String addUser(@ModelAttribute User user){
        Book book = user.getBook();
        bookRepository.save(book);
        userRepository.save(user);
        return "redirect:/";
    }


}
