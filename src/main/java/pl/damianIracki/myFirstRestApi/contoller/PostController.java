package pl.damianIracki.myFirstRestApi.contoller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.damianIracki.myFirstRestApi.model.Post;
import pl.damianIracki.myFirstRestApi.service.PostService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/posts")
    public List<Post> getPosts(){
       return postService.getPosts();
    }

    @GetMapping("/posts/{id}")
    public Post getSinglePost(@PathVariable long id){
        return postService.findById(id);
    }
}
