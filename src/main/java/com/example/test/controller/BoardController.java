package com.example.test.controller;

import com.example.test.dto.BoardCreateRequestDto;
import com.example.test.dto.BoardListResponseDto;
import com.example.test.dto.BoardResponseDto;
import com.example.test.dto.BoardUpdateRequestDto;
import com.example.test.entity.Board;
import com.example.test.repository.BoardRepository;
import com.example.test.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;
    @PostMapping
    public Long create(@RequestBody BoardCreateRequestDto requestDto) {
        return boardService.create(requestDto);
    }

    @PutMapping("/{id}")
    public Long update(@PathVariable Long id, @RequestBody BoardUpdateRequestDto requestDto) {
        return boardService.update(id, requestDto);
    }

    @GetMapping("/{id}")
    public BoardResponseDto searchById(@PathVariable Long id) {
        return boardService.searchById(id);
    }

    @GetMapping
    public List<BoardListResponseDto> searchAllDesc() {

        return boardService.searchAllDesc();
    }



//    //페이지네이션
//    @GetMapping("/paged")
//    public List<BoardListResponseDto> searchAllDescPaged(@RequestParam(defaultValue = "0") int page,
//                                                         @RequestParam(defaultValue = "10") int size) {
//        PageRequest pageRequest = PageRequest.of(page, size);
//        Page<BoardListResponseDto> boardPage = boardService.searchAllDescPaged(pageRequest);
//        return boardPage.getContent().stream()
//                .map(BoardListResponseDto::new)
//                .collect(Collectors.toList());
//    }


}
