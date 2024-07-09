package com.example.simpleboard.board.service;

import com.example.simpleboard.board.db.BoardRepository;
import com.example.simpleboard.board.db.BoradEntity;
import com.example.simpleboard.board.model.BoardRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public BoradEntity create(
        BoardRequest boardRequest
    ){
        var entity =  BoradEntity.builder()
                .boardName(boardRequest.getBoardName())
                .status("REGISTERED")
                .build();

        return boardRepository.save(entity);
    }
}
