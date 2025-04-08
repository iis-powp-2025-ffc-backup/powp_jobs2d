package edu.kis.powp.jobs2d.drivers.command;

import edu.kis.powp.jobs2d.Job2dDriver;

public class TestFigure {
    public TestFigure(){}

    public static void Test1(Job2dDriver driver) {
        driver.setPosition(-120, -120);
        driver.operateTo(120, -120);
        driver.operateTo(120, 120);
        driver.operateTo(-120, 120);
        driver.operateTo(-120, -120);
        driver.operateTo(120, 120);
        driver.setPosition(120, -120);
        driver.operateTo(-120, 120);
    }
}
