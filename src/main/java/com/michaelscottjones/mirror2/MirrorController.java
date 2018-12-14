package com.michaelscottjones.mirror2;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class MirrorController {
    @GetMapping("/")
    public String index() {
        return "index";
    }
}
