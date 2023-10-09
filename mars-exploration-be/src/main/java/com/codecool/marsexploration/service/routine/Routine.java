package com.codecool.marsexploration.service.routine;

import com.codecool.marsexploration.model.Context;

import java.io.IOException;

public interface Routine {
    void move(Context context) throws IOException;
}
