package com.example.test.service;

import com.example.test.dto.BoardCreateRequestDto;
import com.example.test.dto.BoardListResponseDto;
import com.example.test.dto.BoardResponseDto;
import com.example.test.dto.BoardUpdateRequestDto;
import com.example.test.entity.Board;
import com.example.test.entity.Member;
import com.example.test.error.ErrorCode;
import com.example.test.error.exception.ForbiddenException;
import com.example.test.error.exception.NotFoundException;
import com.example.test.repository.BoardRepository;
import com.example.test.repository.MemberRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.net.ContentHandler;
import java.util.List;
import java.util.stream.Collectors;

import static com.example.test.error.ErrorCode.FORBIDDEN_EXCEPTION;
import static com.example.test.error.ErrorCode.NOT_EXIST_POST;

@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;
    @Transactional
    public Long create(BoardCreateRequestDto requestDto) {
       Member member = memberRepository.findById(requestDto.getMember_id())
               .orElseThrow(() -> new NotFoundException(ErrorCode.NOT_EXIST_USER, ErrorCode.NOT_EXIST_USER.getMessage()));
       Board board = requestDto.toEntity(member);
       boardRepository.save(board);
       return board.getId();
    }
    @Transactional
    public Long update(Long id, BoardUpdateRequestDto requestDto) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(ErrorCode.NOT_EXIST_POST, ErrorCode.NOT_EXIST_POST.getMessage()));
        board.update(requestDto.getTitle(),
                requestDto.getContent());
        return id;
    }
    @Transactional(readOnly = true)
    public BoardResponseDto searchById(Long board_id) {
        Board board = boardRepository.findById(board_id)
                .orElseThrow(()
                        -> new NotFoundException(ErrorCode.NOT_EXIST_POST, ErrorCode.NOT_EXIST_POST.getMessage()));
        return new BoardResponseDto(board);
    }
    @Transactional(readOnly = true)
    public List<BoardListResponseDto> searchAllDesc() {
        return boardRepository.findAllByOrderByIdDesc().stream()
                .map(BoardListResponseDto::new)
                .collect(Collectors.toList());
    }
    @Transactional
    public void delete(Long id) {
        Board board = boardRepository.findById(id)
                .orElseThrow(()->
                new NotFoundException(ErrorCode.NOT_EXIST_POST, ErrorCode.NOT_EXIST_POST.getMessage()));
        boardRepository.delete(board);
    }
//페이지네이션
    @Transactional(readOnly = true)
    public Page<BoardListResponseDto> searchAllDescPaged(PageRequest pageRequest) {
        Page<Board> boardPage = boardRepository.findAll(pageRequest);
        return new PageImpl<>(boardPage
                .getContent().stream()
                .map(BoardListResponseDto::new)
                .collect(Collectors.toList()), pageRequest, boardPage
                .getTotalElements());
        }
    }
