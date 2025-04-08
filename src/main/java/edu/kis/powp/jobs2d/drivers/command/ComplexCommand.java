package edu.kis.powp.jobs2d.drivers.command;

import java.util.List;

public class ComplexCommand implements DriverCommand {

    List<DriverCommand> commands;

    ComplexCommand(List<DriverCommand> commands) {
        this.commands = commands;
    }

    @Override
    public void execute() {
        this.commands.forEach(DriverCommand::execute);
    }
}
