package com.example.test.service;

import com.example.test.dto.BoardCreateRequestDto;
import com.example.test.dto.BoardListResponseDto;
import com.example.test.dto.BoardResponseDto;
import com.example.test.dto.BoardUpdateRequestDto;
import com.example.test.entity.Board;
import com.example.test.error.ErrorCode;
import com.example.test.error.exception.NotFoundException;
import com.example.test.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.net.ContentHandler;
import java.util.List;
import java.util.stream.Collectors;

import static com.example.test.error.ErrorCode.NOT_EXIST_POST;

@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository boardRepository;
    @Transactional
    public Long create(BoardCreateRequestDto requestDto) {

        return boardRepository.save(requestDto.toEntity()).getId();
    }
    @Transactional
    public Long update(Long id, BoardUpdateRequestDto requestDto) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("게시글이 존재하지 않음."));

        board.update(requestDto.getTitle(),
                requestDto.getContent());

        return id;
    }
    @Transactional(readOnly = true)
    public BoardResponseDto searchById(Long board_id) {
        Board board = boardRepository.findById(board_id).orElseThrow(() -> new NotFoundException(ErrorCode.NOT_EXIST_POST, ErrorCode.NOT_EXIST_POST.getMessage()));
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
        Board board = boardRepository.findById(id).orElseThrow(()->
                new IllegalArgumentException("해당 게시글이 존재하지 않습니다."));
        boardRepository.delete(board);

    }
////페이지네이션
//    @Transactional(readOnly = true)
//    public Page<BoardListResponseDto> searchAllDescPaged(PageRequest pageRequest) {
//        Page<Board> boardPage = boardRepository.findAll(pageRequest);
//        return boardPage.map(BoardListResponseDto::new);
//}



}
