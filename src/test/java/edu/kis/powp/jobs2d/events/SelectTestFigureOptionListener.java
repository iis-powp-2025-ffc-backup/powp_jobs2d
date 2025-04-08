package edu.kis.powp.jobs2d.events;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.drivers.command.CircleFactory;
import edu.kis.powp.jobs2d.drivers.command.RectangleFactory;
import edu.kis.powp.jobs2d.magicpresets.FiguresJoe;

import static edu.kis.powp.jobs2d.events.Figure.*;

public class SelectTestFigureOptionListener implements ActionListener {

	private DriverManager driverManager;
	private Figure figure;

	public SelectTestFigureOptionListener(DriverManager driverManager, Figure figure) {
		this.driverManager = driverManager;
		this.figure = Figure.valueOf(figure.name());

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(figure == FIGURE_JOE_1) {
			FiguresJoe.figureScript1(driverManager.getCurrentDriver());
		}
		else if(figure == RECTANGLE) {
			RectangleFactory.create(driverManager.getCurrentDriver(), 0, 0, 100, 100).execute();
		}
		else if(figure == CIRCLE) {
			CircleFactory.create(driverManager.getCurrentDriver(), 0,0,100).execute();
		}



	}
}
