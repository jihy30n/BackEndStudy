package com.example.test.service;

import com.example.test.dto.MemberCreateRequestDto;
import com.example.test.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public Long create(MemberCreateRequestDto requestDto) {

        return memberRepository.save(requestDto.toEntity()).getId();
    }


}
