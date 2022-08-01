package hello.board.service;

import hello.board.dto.BoardDTO;
import hello.board.dto.PageRequestDTO;
import hello.board.dto.PageResultDTO;
import hello.board.entity.Board;

public interface BoardService {

    Long register(BoardDTO dto);

    PageResultDTO<BoardDTO, Board> getList(PageRequestDTO requestDTO);

    default Board dtoToEntity(BoardDTO dto) {

        Board entity = Board.builder()
                .id(dto.getId())
                .title(dto.getTitle())
                .content(dto.getContent())
                .writer(dto.getWriter())
                .build();

        return entity;
    }

    default BoardDTO entityToDto(Board entity) {

        BoardDTO dto = BoardDTO.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .content(entity.getContent())
                .writer(entity.getWriter())
                .regData(entity.getRegDate())
                .modDate(entity.getModDate())
                .build();

        return dto;
    }
}
