package com.hillel;

import lombok.Data;
import lombok.extern.log4j.Log4j2;

@Data
@Log4j2
public class TextPrompt {
    private String text;


    public TextPrompt(String text) {
        this.text = text;
        log.debug(this.toString());
    }
}


