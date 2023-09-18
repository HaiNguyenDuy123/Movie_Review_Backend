package dev.nguyenduyhai.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/reviews")
@CrossOrigin(origins = "*")
public class ReviewController {

    @Autowired
    private ReviewService service;

    @PostMapping() // Xử lý yêu cầu POST
    public ResponseEntity<Review> createReview(@RequestBody Map<String, String> payload) {
        // Xử lý logic để tạo đánh giá và lưu vào cơ sở dữ liệu
        Review newReview = service.createReview(payload.get("reviewBody"), payload.get("imdbId"));
        return new ResponseEntity<>(newReview, HttpStatus.OK);
    }
}
