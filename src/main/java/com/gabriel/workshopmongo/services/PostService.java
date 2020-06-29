package com.gabriel.workshopmongo.services;

import com.gabriel.workshopmongo.domain.Post;
import com.gabriel.workshopmongo.repository.PostRepository;
import com.gabriel.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public Post findById(String id) {
        Optional<Post> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!"));
    }

    public List<Post> findByTitle(String text) {
        return repository.searchTitle(text);
    }

}
