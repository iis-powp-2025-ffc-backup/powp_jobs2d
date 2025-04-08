package edu.kis.powp.jobs2d.drivers.adapter;

import edu.kis.legacy.drawer.shape.ILine;
import edu.kis.legacy.drawer.shape.LineFactory;
import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.features.DrawerFeature;

public class LineDrawerAdapter implements Job2dDriver {
    private int startX = 0, startY = 0;
    private ILine lineType;

    public LineDrawerAdapter(ILine lineType) {
        this.lineType = lineType;
    }

    @Override
    public void setPosition(int x, int y) {
        this.startX = x;
        this.startY = y;
    }

    @Override
    public void operateTo(int x, int y) {
        lineType.setStartCoordinates(this.startX, this.startY);
        lineType.setEndCoordinates(x, y);
        setPosition(x, y);
        DrawerFeature.getDrawerController().drawLine(lineType);
    }

    @Override
    public String toString() {
        return "Line Drawer Adapter (" + lineType.getClass().getSimpleName() + ")";
    }
}
