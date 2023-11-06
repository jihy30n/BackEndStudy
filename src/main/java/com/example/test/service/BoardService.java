package com.example.test.service;

import com.example.test.dto.BoardCreateRequestDto;
import com.example.test.dto.BoardListResponseDto;
import com.example.test.dto.BoardResponseDto;
import com.example.test.dto.BoardUpdateRequestDto;
import com.example.test.entity.BoardEntity;
import com.example.test.entity.MemberEntity;
import com.example.test.error.ErrorCode;
import com.example.test.error.exception.NotFoundException;
import com.example.test.repository.BoardRepository;
import com.example.test.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;
    @Transactional
    public Long create(BoardCreateRequestDto requestDto) {
       MemberEntity member = memberRepository.findById(requestDto.getMember_id())
               .orElseThrow(() -> new NotFoundException(ErrorCode.NOT_EXIST_USER.getMessage(), ErrorCode.NOT_EXIST_USER));
       BoardEntity boardEntity = requestDto.toEntity(member);
       boardRepository.save(boardEntity);
       return boardEntity.getId();
    }
    @Transactional
    public Long update(Long id, BoardUpdateRequestDto requestDto) {
        BoardEntity boardEntity = boardRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(ErrorCode.NOT_EXIST_POST.getMessage(), ErrorCode.NOT_EXIST_POST));
        boardEntity.update(requestDto.getTitle(),
                requestDto.getContent());
        return id;
    }
    @Transactional(readOnly = true)
    public BoardResponseDto searchById(Long board_id) {
        BoardEntity boardEntity = boardRepository.findById(board_id)
                .orElseThrow(()
                        -> new NotFoundException(ErrorCode.NOT_EXIST_POST.getMessage(), ErrorCode.NOT_EXIST_POST));
        return new BoardResponseDto(boardEntity);
    }
    @Transactional(readOnly = true)
    public List<BoardListResponseDto> searchAllDesc() {
        return boardRepository.findAllByOrderByIdDesc().stream()
                .map(BoardListResponseDto::new)
                .collect(Collectors.toList());
    }
    @Transactional
    public void delete(Long id) {
        BoardEntity boardEntity = boardRepository.findById(id)
                .orElseThrow(()->
                new NotFoundException(ErrorCode.NOT_EXIST_POST.getMessage(), ErrorCode.NOT_EXIST_POST));
        boardRepository.delete(boardEntity);
    }
//페이지네이션
    @Transactional(readOnly = true)
    public Page<BoardListResponseDto> searchAllDescPaged(PageRequest pageRequest) {
        Page<BoardEntity> boardPage = boardRepository.findAll(pageRequest);
        return new PageImpl<>(boardPage
                .getContent().stream()
                .map(BoardListResponseDto::new)
                .collect(Collectors.toList()), pageRequest, boardPage
                .getTotalElements());
        }
    }
