package com.codecool.marsexploration.service.phase;

import com.codecool.marsexploration.model.Context;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Log implements Phase{
    @Override
    public void perform(Context context) throws IOException {
        FileWriter writer = new FileWriter(context.getLogFile(), true);

        if(context.hasOutcomeBeenReached()){
            writer.write("STEP: " + context.getStepNumber() + "; EVENT: outcome;" + " OUTCOME " + context.getExplorationOutcome());
            System.out.println("STEP: " + context.getStepNumber() + "; EVENT: outcome;" + " OUTCOME " + context.getExplorationOutcome());
        } else {
            List<String> events = Arrays.asList(
                    "STEP: " + context.getStepNumber() + "; EVENT: " + "position;" + "UNIT: " + context.getRover().getId() + "; POSITION: " + context.getRover().getPosition()
            );

            for (String event : events) {
                writer.write(event);
                writer.write("\n");
                System.out.println(event);
            }
        }
        writer.flush();
        writer.close();
    }
}
