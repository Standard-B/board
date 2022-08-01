package hello.board.controller;

import hello.board.dto.PageRequestDTO;
import hello.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
@Log4j2
@RequiredArgsConstructor
public class SampleController {

    private final BoardService service;

    @GetMapping("/")
    public String index() {

        return "layout/basic";
    }

    @GetMapping("/list")
    public String list(PageRequestDTO pageRequestDTO, Model model) {

        log.info("list........" + pageRequestDTO);

        model.addAttribute("result", service.getList(pageRequestDTO));
        return "content/list";
    }
}
