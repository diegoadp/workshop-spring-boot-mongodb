package br.com.diegoadp.workshopmongo.services;

import br.com.diegoadp.workshopmongo.domain.Post;
import br.com.diegoadp.workshopmongo.repository.PostRepository;
import br.com.diegoadp.workshopmongo.services.exception.ObjectNotFoundException;
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
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto nao encontrado"));
    }

    public List<Post> findByTitle(String text) {
        return repository.searchTitle(text);
//        return repository.findByTitleContainingIgnoreCase(text);
    }

}
