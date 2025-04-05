package edu.kis.powp.jobs2d.drivers.command;

import edu.kis.powp.jobs2d.AbstractDriver;

public class ComplexCommandFactory {
    public static ComplexCommand square(AbstractDriver driver) {
        ComplexCommand complexCommand = new ComplexCommand();

        complexCommand.AddCommand(new SetPositionCommand(0,0,driver));
        complexCommand.AddCommand(new OperateToCommand(100,0,driver));
        complexCommand.AddCommand(new OperateToCommand(100,100,driver));
        complexCommand.AddCommand(new OperateToCommand(0,100,driver));
        complexCommand.AddCommand(new OperateToCommand(0,0,driver));

        return complexCommand;
    }

    public static ComplexCommand hexagon(AbstractDriver driver) {
        ComplexCommand complexCommand = new ComplexCommand();

        int size = 100;

        int x1 = size, y1 = 0;
        int x2 = size / 2, y2 = (int) (Math.sqrt(3) / 2 * size);
        int x3 = -size / 2, y3 = (int) (Math.sqrt(3) / 2 * size);
        int x4 = -size, y4 = 0;
        int x5 = -size / 2, y5 = (int) (-Math.sqrt(3) / 2 * size);
        int x6 = size / 2, y6 = (int) (-Math.sqrt(3) / 2 * size);

        complexCommand.AddCommand(new SetPositionCommand(x1, y1, driver));

        complexCommand.AddCommand(new OperateToCommand(x2, y2, driver));
        complexCommand.AddCommand(new OperateToCommand(x3, y3, driver));
        complexCommand.AddCommand(new OperateToCommand(x4, y4, driver));
        complexCommand.AddCommand(new OperateToCommand(x5, y5, driver));
        complexCommand.AddCommand(new OperateToCommand(x6, y6, driver));
        complexCommand.AddCommand(new OperateToCommand(x1, y1, driver));

        return complexCommand;
    }
}