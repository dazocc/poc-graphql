package br.com.dazo.pocgraphql.forum;

import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;

import java.util.Collection;

@Controller
@AllArgsConstructor
public class ForumController {

    PostService postService;

    CommentService commentService;

    @PreAuthorize("hasRole('USER')")
    @QueryMapping
    public Post postById(@Argument String id){
        return postService.postById(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @MutationMapping
    public Collection<Post> createPost(@Argument String content){
        return postService.createPost(content);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @MutationMapping
    public Collection<Comment> createComment(@Argument String content, @Argument String postId){
        return commentService.createComment(content, postId);
    }

    @SchemaMapping
    public Collection<Comment> comments(Post post){
        return commentService.findByPost(post.id());
    }

}
