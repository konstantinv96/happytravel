package bg.softuni.happytravel.web.rest;


import bg.softuni.happytravel.model.dto.CommentCreationDTO;
import bg.softuni.happytravel.model.dto.CommentMessageDTO;
import bg.softuni.happytravel.model.views.CommentDisplayView;
import bg.softuni.happytravel.service.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CommentRestController {
    CommentService commentService;

    public CommentRestController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/{offerId}/comments")
    public ResponseEntity<List<CommentDisplayView>> getComments(@PathVariable("offerId") Long offerId){

            return ResponseEntity.ok(commentService.getAllCommentsForOffer(offerId));
    }


    @PostMapping(value = "/{offerId}/comments" , consumes = "application/json", produces = "application/json")
    public ResponseEntity<CommentDisplayView> createComment(@PathVariable("offerId") Long offerId,
                                                           @AuthenticationPrincipal UserDetails userDetails,
                                                           @RequestBody CommentMessageDTO commentDto){

        CommentCreationDTO commentCreationDTO = new CommentCreationDTO(userDetails.getUsername(),
                offerId,commentDto.getMessage());

        CommentDisplayView comment = commentService.createComment(commentCreationDTO);

        return ResponseEntity.created(URI.create(String.format("/api/%d/comments/%d", offerId , comment.getId())))
                .body(comment);

    }
}
