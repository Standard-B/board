package hello.board.service;

import hello.board.dto.BoardDTO;
import hello.board.dto.PageRequestDTO;
import hello.board.dto.PageResultDTO;
import hello.board.entity.Board;
import hello.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
@Log4j2
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardRepository repository;

    @Override
    public Long register(BoardDTO dto) {
        Board entity = dtoToEntity(dto);

        repository.save(entity);

        return entity.getId();
    }

    @Override
    public PageResultDTO<BoardDTO, Board> getList(PageRequestDTO requestDTO) {

        Pageable pageable = requestDTO.getPageable(Sort.by("id").descending());

        Page<Board> result = repository.findAll(pageable);

        Function<Board, BoardDTO> fn = (entity -> entityToDto(entity));

        return new PageResultDTO<>(result, fn);
    }

}
