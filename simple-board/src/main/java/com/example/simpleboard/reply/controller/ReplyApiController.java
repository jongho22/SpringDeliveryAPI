package com.example.simpleboard.reply.controller;

import com.example.simpleboard.crud.CRUDAbstractApiController;
import com.example.simpleboard.reply.db.ReplyEntity;
import com.example.simpleboard.reply.model.ReplyDto;
import com.example.simpleboard.reply.model.ReplyRequest;
import com.example.simpleboard.reply.service.ReplyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reply")
@RequiredArgsConstructor
public class ReplyApiController extends CRUDAbstractApiController<ReplyDto, ReplyEntity> {

//    private final ReplyService replyService;
//
//    @PostMapping("")
//    public ReplyEntity create(
//            @Valid
//            @RequestBody ReplyRequest replyRequest
//    ){
//        return replyService.create(replyRequest);
//    }
}
