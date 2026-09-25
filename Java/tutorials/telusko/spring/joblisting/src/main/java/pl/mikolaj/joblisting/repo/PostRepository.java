package pl.mikolaj.joblisting.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import pl.mikolaj.joblisting.model.Post;

public interface PostRepository extends MongoRepository<Post, String> {
}
