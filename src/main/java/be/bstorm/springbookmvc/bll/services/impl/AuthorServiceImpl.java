package be.bstorm.springbookmvc.bll.services.impl;

import be.bstorm.springbookmvc.bll.services.AuthorService;
import be.bstorm.springbookmvc.dal.repositories.AuthorRepository;
import be.bstorm.springbookmvc.dl.entities.Author;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }
}
