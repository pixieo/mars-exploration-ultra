package com.codecool.marsexploration.service.phase;

import com.codecool.marsexploration.model.Context;

import java.io.IOException;

public interface Phase {
    void perform(Context context) throws IOException;
}
