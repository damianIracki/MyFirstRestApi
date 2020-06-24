package pl.damianIracki.myFirstRestApi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import pl.damianIracki.myFirstRestApi.model.Post;
import pl.damianIracki.myFirstRestApi.repository.PostRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private static final int PAGE_SIZE = 20;
    private final PostRepository postRepository;


    public List<Post> getPosts(int page){
        return postRepository.findAllPosts(PageRequest.of(page, PAGE_SIZE));
    }


    public Post findById(long id) {
        return postRepository.findById(id)
                .orElseThrow();
    }
}
