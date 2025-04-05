package edu.kis.powp.jobs2d.drivers.command;

import java.util.ArrayList;
import java.util.List;

public class ComplexCommand implements DriverCommand{
    List<DriverCommand> commands;
    public ComplexCommand(){
        commands = new ArrayList<>();
    }
    public void AddCommand(DriverCommand command){
        commands.add(command);
    }
    @Override
    public void execute() {
        for (DriverCommand command: commands){
            command.execute();
        }
    }
}
