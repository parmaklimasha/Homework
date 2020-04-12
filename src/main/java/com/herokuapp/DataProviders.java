package com.herokuapp;


import io.github.sskorol.core.DataSupplier;
import one.util.streamex.StreamEx;


import java.util.List;

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
}
