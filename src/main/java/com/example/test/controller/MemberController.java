package com.example.test.controller;


import com.example.test.dto.MemberCreateRequestDto;
import com.example.test.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/member")
public class MemberController {
    private final MemberService memberService;

    @PostMapping
    public Long create(@RequestBody MemberCreateRequestDto requestDto){
        return memberService.create(requestDto);
    }


}
