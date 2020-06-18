package pl.damianIracki.myFirstRestApi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.damianIracki.myFirstRestApi.model.Post;
import pl.damianIracki.myFirstRestApi.repository.PostRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;


    public List<Post> getPosts(){
        return postRepository.findAll();
    }


    public Post findById(long id) {
        return postRepository.findById(id)
                .orElseThrow();
    }
}
