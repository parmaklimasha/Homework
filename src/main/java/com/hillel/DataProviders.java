package com.hillel;


import io.github.sskorol.core.DataSupplier;
import one.util.streamex.StreamEx;


import java.util.List;
import java.util.stream.Stream;

public class DataProviders {
    @DataSupplier(name = "getData")
    public List<TextPrompt> getData() {
        return StreamEx.of(
                new TextPrompt("456"),
                new TextPrompt("automation testing"),
                new TextPrompt(":)"))
                .toList();
    }

    @DataSupplier(name = "getEmptyData")
    public List<TextPrompt> getEmptyData() {
        return StreamEx.of(
                new TextPrompt(""))
                .toList();
    }

    @DataSupplier(name = "getTextForFrame")
    public List<TextPrompt> getTextForFrame(){
        return StreamEx.of(
                new TextPrompt("I did it!"))
                .toList();
    }
}
