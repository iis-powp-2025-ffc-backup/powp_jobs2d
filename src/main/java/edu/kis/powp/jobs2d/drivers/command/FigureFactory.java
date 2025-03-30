package edu.kis.powp.jobs2d.drivers.command;

import edu.kis.powp.jobs2d.drivers.DriverManager;

public class FigureFactory {
    private int x;
    private int y;
    private final DriverManager driverManager;

    public FigureFactory(DriverManager driverManager, int x, int y) {
        this.driverManager = driverManager;
        this.x = x;
        this.y = y;
    }

    public ComplexCommand getRectangleCommand( int x, int y) {
        ComplexCommand complexCommand = new ComplexCommand();
        complexCommand.addCommand(new SetPositionCommand(driverManager.getCurrentDriver(), x, y));
        complexCommand.addCommand(new OperateToCommand(driverManager.getCurrentDriver(), x + 100, y));
        complexCommand.addCommand(new OperateToCommand(driverManager.getCurrentDriver(), x + 100, y + 100));
        complexCommand.addCommand(new OperateToCommand(driverManager.getCurrentDriver(), x, y + 100));
        complexCommand.addCommand(new OperateToCommand(driverManager.getCurrentDriver(), x, y));
        return complexCommand;
    }

    public ComplexCommand getTriangleCommand( int x, int y) {
        ComplexCommand complexCommand = new ComplexCommand();
        complexCommand.addCommand(new SetPositionCommand(driverManager.getCurrentDriver(), x, y));
        complexCommand.addCommand(new OperateToCommand(driverManager.getCurrentDriver(), x + 100, y));
        complexCommand.addCommand(new OperateToCommand(driverManager.getCurrentDriver(), x + 50, y + 100));
        complexCommand.addCommand(new OperateToCommand(driverManager.getCurrentDriver(), x, y));
        return complexCommand;
    }
}
