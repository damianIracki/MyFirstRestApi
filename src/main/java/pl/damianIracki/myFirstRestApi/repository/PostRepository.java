package pl.damianIracki.myFirstRestApi.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.damianIracki.myFirstRestApi.model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {


}
