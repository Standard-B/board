package hello.board.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
@Log4j2
public class SampleController {

    @GetMapping({"/", "/list"})
    public String list() {

        log.info("list.....");
        return "content/list";

    }

    @GetMapping("/write")
    public String write() {

        log.info("write.....");
        return "content/write";
    }

    @GetMapping("/read")
    public String read() {

        log.info("read.....");
        return "content/read";
    }

    @GetMapping("/update")
    public String update() {

        log.info("update.....");
        return "content/update";
    }
}
