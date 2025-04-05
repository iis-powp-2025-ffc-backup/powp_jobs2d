package edu.kis.powp.jobs2d.drivers.command;

import edu.kis.powp.jobs2d.Job2dDriver;

public class OperateToCommand implements DriverCommand {
    private final int x, y;
    private final Job2dDriver driver;
    public OperateToCommand(int x, int y, Job2dDriver driver) {
        this.driver = driver;
        this.x = x;
        this.y = y;

    }

    @Override
    public void execute(){
        System.out.println("operate " + x + " " + y);
        driver.operateTo(x,y);
    }
}
