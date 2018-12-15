package com.michaelscottjones.mirror2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

public class MirrorController {
    @GetMapping("/")
    public String index() {
        return "index";
    }
}
