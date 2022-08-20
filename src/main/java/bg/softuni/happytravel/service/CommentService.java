package bg.softuni.happytravel.service;


import bg.softuni.happytravel.exceptions.OfferNotFoundException;
import bg.softuni.happytravel.model.Comment;
import bg.softuni.happytravel.model.Offer;
import bg.softuni.happytravel.model.UserEntity;
import bg.softuni.happytravel.model.dto.CommentCreationDTO;
import bg.softuni.happytravel.model.views.CommentDisplayView;
import bg.softuni.happytravel.repository.CommentRepository;
import bg.softuni.happytravel.repository.OfferRepository;
import bg.softuni.happytravel.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService {

    private final OfferRepository offerRepository;
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;

    public CommentService(OfferRepository offerRepository,
                          CommentRepository commentRepository, UserRepository userRepository) {

        this.offerRepository = offerRepository;
        this.commentRepository = commentRepository;
        this.userRepository = userRepository;
    }

    public List<CommentDisplayView> getAllCommentsForOffer(Long offerId){

            Offer offer = offerRepository.findById(offerId).orElseThrow(OfferNotFoundException::new);

            List<Comment> comments = commentRepository.findAllByOffer(offer).get();
            return  comments.stream().map(comment -> new CommentDisplayView(comment.getId() , comment.getAuthor().getFullName(),
            comment.getText())).collect(Collectors.toList());
    }

    public CommentDisplayView createComment(CommentCreationDTO commentDTO) {

        UserEntity author = userRepository.findByUsername(commentDTO.getUsername()).get();

        Comment comment = createNewComment(commentDTO, author);

        commentRepository.save(comment);

        return new CommentDisplayView(comment.getId(),author.getFullName(),comment.getText());
        //
    }

    private Comment createNewComment(CommentCreationDTO commentDTO, UserEntity author) {
        Comment comment = new Comment();
        comment.setCreated(LocalDateTime.now());
        comment.setOffer(offerRepository.getById(commentDTO.getOfferId()));
        comment.setAuthor(author);
        comment.setApproved(true);
        comment.setText(commentDTO.getMessage());
        return comment;
    }
}
