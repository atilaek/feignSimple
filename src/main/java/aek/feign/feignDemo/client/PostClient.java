package aek.feign.feignDemo.client;

import aek.feign.feignDemo.model.Post;
import feign.RequestLine;

import java.util.List;

public interface PostClient {
    /*
    @RequestLine("GET /{isbn}")
    BookResource findByIsbn(@Param("isbn") String isbn);


    @RequestLine("POST")
    @Headers("Content-Type: application/json")
    void create(Book book);
*/
    @RequestLine("GET /posts")
    List<Post> findAll();
}
