package pl.damianIracki.myFirstRestApi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pl.damianIracki.myFirstRestApi.contoller.dto.PostDto;
import pl.damianIracki.myFirstRestApi.model.Comment;
import pl.damianIracki.myFirstRestApi.model.Post;
import pl.damianIracki.myFirstRestApi.repository.CommentRepository;
import pl.damianIracki.myFirstRestApi.repository.PostRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {

    private static final int PAGE_SIZE = 20;
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    public List<Post> getPosts(int page, Sort.Direction sort){
        return postRepository.findAllPosts(
                PageRequest.of(page, PAGE_SIZE,
                        Sort.by(sort, "id")
                )
        );
    }


    public Post findById(long id) {
        return postRepository.findById(id)
                .orElseThrow();
    }


    public List<Post> getPostsWithComments(int page, Sort.Direction sort) {
        List<Post> allPosts = postRepository.findAllPosts(PageRequest.of(page, PAGE_SIZE,
                Sort.by(sort, "id")
        ));     //getting paged posts
        List<Long> ids = allPosts.stream()
                .map(Post::getId)
                .collect(Collectors.toList());      //getting id of paged posts
        List<Comment> comments = commentRepository.findAllByPostIdIn(ids);      //getting all posts by postId (ids is list of posts ids)
        allPosts.forEach(post -> post.setComment(extractComments(comments, post.getId())));     //iterating allPosts and extracting theirs comments
        return allPosts;
    }

    private List<Comment> extractComments(List<Comment> comments, long id) {
        return comments.stream()
                .filter(comment -> comment.getPostId() == id)
                .collect(Collectors.toList());
    }
}
