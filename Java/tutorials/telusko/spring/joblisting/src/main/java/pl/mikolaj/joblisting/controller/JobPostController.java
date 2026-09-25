package pl.mikolaj.joblisting.controller;

import io.swagger.v3.oas.annotations.Hidden;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.*;
import pl.mikolaj.joblisting.model.Post;
import pl.mikolaj.joblisting.repo.PostRepository;
import pl.mikolaj.joblisting.repo.SearchRepository;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class JobPostController {

    private final PostRepository postRepository;
    private final SearchRepository searchRepository;

    public JobPostController(
            PostRepository postRepository,
            SearchRepository searchRepository
    ) {
        this.postRepository = postRepository;
        this.searchRepository = searchRepository;
    }

    @Hidden
    @RequestMapping(value = "/")
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }

    @GetMapping("/api/posts")
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @GetMapping("/api/posts/{id}")
    public Post getPost(@PathVariable String id) {
        return postRepository.findById(id).orElse(null);
    }

    @GetMapping("/api/posts/search/{text}")
    public List<Post> searchPosts(@PathVariable String text) {
        return searchRepository.findByText(text);
    }

    @PostMapping("/api/posts")
    public Post createPost(@RequestBody Post post) {
        return postRepository.save(post);
    }

    @PutMapping("/api/posts/{id}")
    public Post updatePost(@PathVariable String id, @RequestBody Post post) {
        post.setId(id);
        return postRepository.save(post);
    }

    @DeleteMapping("/api/posts/{id}")
    public void deletePost(@PathVariable String id) {
        postRepository.deleteById(id);
    }
}
