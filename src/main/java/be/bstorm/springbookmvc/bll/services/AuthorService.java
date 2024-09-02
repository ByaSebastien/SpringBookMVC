package be.bstorm.springbookmvc.bll.services;

import be.bstorm.springbookmvc.dl.entities.Author;

import java.util.List;

public interface AuthorService {

    List<Author> findAll();
}
