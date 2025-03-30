package edu.kis.powp.jobs2d.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.drivers.adapter.DriverAdapter;
import edu.kis.powp.jobs2d.drivers.command.ComplexCommand;
import edu.kis.powp.jobs2d.drivers.command.FigureFactory;
import edu.kis.powp.jobs2d.magicpresets.FiguresJane;
import edu.kis.powp.jobs2d.magicpresets.FiguresJoe;
import edu.kis.powp.jobs2d.TestJobs2dPatterns;

public class SelectTestFigureOptionListener implements ActionListener {

	private DriverManager driverManager;

	public SelectTestFigureOptionListener(DriverManager driverManager) {
		this.driverManager = driverManager;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			switch (e.getActionCommand()) {
				case TestJobs2dPatterns.FIGURE_JOE_1:
					FiguresJoe.figureScript1(driverManager.getCurrentDriver());
					break;
				case TestJobs2dPatterns.FIGURE_JOE_2:
					FiguresJoe.figureScript2(driverManager.getCurrentDriver());
					break;
				case TestJobs2dPatterns.FIGURE_JANE:
					FiguresJane.figureScript(new DriverAdapter(driverManager.getCurrentDriver()));
					break;
				case TestJobs2dPatterns.FIGURE_RECTANGLE: {
					FigureFactory factory = new FigureFactory(driverManager, 0, 0);
					ComplexCommand rectangle = factory.getRectangleCommand(100, 100);
					rectangle.execute();
					break;
				}
				case TestJobs2dPatterns.FIGURE_TRIANGLE: {
					FigureFactory factory = new FigureFactory(driverManager, 0, 0);
					ComplexCommand triangle = factory.getTriangleCommand(120, 120);
					triangle.execute();
					break;
				}
				default:
					System.err.println("Unknown figure type: " + e.getActionCommand());
					break;
			}
		} catch (IllegalArgumentException ex) {
			System.err.println("Unknown figure type: " + e.getActionCommand());
		}
	}
}
