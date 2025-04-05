package edu.kis.powp.jobs2d.drivers.adapter;
import edu.kis.legacy.drawer.panel.DrawPanelController;
import edu.kis.legacy.drawer.shape.ILine;
import edu.kis.powp.jobs2d.Job2dDriver;

public class LineDrawerAdapter  implements Job2dDriver {
    private int startX = 0, startY = 0;
    private final DrawPanelController drawPanelController;
    private final ILine line;

    public LineDrawerAdapter(DrawPanelController drawPanelController, ILine chosenLineType) {
        super();
        this.drawPanelController = drawPanelController;
        this.line = chosenLineType;
    }

    @Override
    public void setPosition(int x, int y) {
        this.startX = x;
        this.startY = y;
    }

    @Override
    public void operateTo(int x, int y) {
        line.setStartCoordinates(this.startX, this.startY);
        line.setEndCoordinates(x, y);
        this.setPosition(x,y);
        drawPanelController.drawLine(line);
    }

    @Override
    public String toString() {
        return "LineDrawerAdapter - " + line.getClass().getName();
    }
}