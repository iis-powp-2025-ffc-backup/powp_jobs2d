package edu.kis.powp.jobs2d.drivers.command;

import edu.kis.powp.jobs2d.Job2dDriver;

import java.util.Arrays;

public class RectangleFactory {
    public static DriverCommand create(Job2dDriver driver, int x, int y, int width, int height) {
        return new ComplexCommand(Arrays.asList(
                new SetPositionCommand(driver, x, y),
                new OperateToCommand(driver, x + width, y),
                new OperateToCommand(driver, x + width, y + height),
                new OperateToCommand(driver, x, y + height),
                new OperateToCommand(driver, x, y)
        ));
    }


}
