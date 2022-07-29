package hello.board.repository;

import hello.board.entity.Board;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BoardRepositoryTest {

    @Autowired BoardRepository boardRepository;

    @Test
    public void insertDummies() {

        IntStream.rangeClosed(1, 300).forEach(i -> {
            Board board = Board.builder()
                    .title("Title....." + i)
                    .content("Content......" + i)
                    .writer("user" + (i % 10))
                    .build();

            System.out.println(boardRepository.save(board));
        });
    }

}