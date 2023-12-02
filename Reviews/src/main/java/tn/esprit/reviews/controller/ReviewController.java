package tn.esprit.reviews.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.reviews.entity.Review;
import tn.esprit.reviews.service.IReview;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("review")
public class ReviewController {

    public IReview iReview;

    @PostMapping(value = "/addReview", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Review> addReview(@RequestBody Review review) {
        return new ResponseEntity<>(iReview.addReview(review), HttpStatus.CREATED);
    }

    @GetMapping("/getReviewById/{idReview}")
    public Review getReviewById(@PathVariable long idReview) {
        return iReview.getReviewById(idReview);
    }

    @PutMapping(value = "updateReview/{idReview}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Review> updateReview(@PathVariable Long idReview, @RequestBody Review updatedReview) {
        return new ResponseEntity<>(iReview.updateReview(idReview, updatedReview), HttpStatus.OK);
    }

    @DeleteMapping(value = "deleteReview/{idReview}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteReview(@PathVariable Long idReview) {
        iReview.deleteReview(idReview);
        return new ResponseEntity<>("Category with ID " + idReview + " deleted successfully", HttpStatus.OK);
    }

    @GetMapping("getAllReviews")
    public List<Review> getAllReview() {
        return iReview.getAllReviews();
    }
}