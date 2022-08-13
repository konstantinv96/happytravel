package bg.softuni.happytravel.repository;

import bg.softuni.happytravel.model.Comment;
import bg.softuni.happytravel.model.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
        Optional<List<Comment>> findAllByOffer(Offer offer);
}
