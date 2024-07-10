package com.example.simpleboard.post.service;

import com.example.simpleboard.post.db.PostEntity;
import com.example.simpleboard.post.db.PostRepository;
import com.example.simpleboard.post.model.PostRequest;
import com.example.simpleboard.post.model.PostViewRequest;
import com.example.simpleboard.reply.service.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final ReplyService replyService;

    public PostEntity create(
            PostRequest postRequest
    ){
        var entity = PostEntity.builder()
                .boardId(1L)
                .userName(postRequest.getUserName())
                .password(postRequest.getPassword())
                .email(postRequest.getEmail())
                .status("REGISTERED")
                .title(postRequest.getTitle())
                .content(postRequest.getContent())
                .postedAt(LocalDateTime.now())
                .build();

        return postRepository.save(entity);
    }

    /*
    1. 게시글이 있는가 체크.
    2. 비밀번호가 맞는지 체크.
     */
    public PostEntity view(
            PostViewRequest postViewRequest
    ){
        return postRepository.findFirstByIdAndStatusOrderByIdDesc(postViewRequest.getPostId(), "REGISTERED")
            .map( it -> {
                    // 비밀번호가 동일하지 않을때
                    if(!it.getPassword().equals(postViewRequest.getPassword())) {
                        var format = "패스워드가 맞지 않습니다. %s != %s";
                        throw new RuntimeException(String.format(format, it.getPassword(), postViewRequest.getPassword()));
                    }
                    // 게시글에 달린 댓글도 같이 반환
                    var replyList = replyService.findAllByPostId(it.getId());
                    it.setReplyList(replyList);

                    // 비밀번호가 동일하면 바로 객체 반환
                    return it;
                }
            ).orElseThrow(
                    () -> {
                        return new RuntimeException("해당 게시글이 존재 하지 않습니다. : " + postViewRequest.getPostId());
                    }
                );
    }

    public List<PostEntity> all() {
        return postRepository.findAll();
    }

    public void delete(
            PostViewRequest postViewRequest
    ) {
        postRepository.findById(postViewRequest.getPostId())
            .map( it -> {
                        // 비밀번호가 동일하지 않을때
                        if(!it.getPassword().equals(postViewRequest.getPassword())) {
                            var format = "패스워드가 맞지 않습니다. %s != %s";
                            throw new RuntimeException(String.format(format, it.getPassword(), it.getPassword()));
                        }

                        // 삭제 상태로 변환
                        it.setStatus("DELETED");
                        postRepository.save(it);

                        // 비밀번호가 동일하면 바로 객체 반환
                        return it;
                    }
            ).orElseThrow(
                    () -> {
                        return new RuntimeException("해당 게시글이 존재 하지 않습니다. : " + postViewRequest.getPostId());
                    }
            );
    }
}
