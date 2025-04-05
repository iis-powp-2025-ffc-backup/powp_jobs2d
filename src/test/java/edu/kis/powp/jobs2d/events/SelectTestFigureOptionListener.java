package edu.kis.powp.jobs2d.events;
import edu.kis.powp.jobs2d.drivers.adapter.AbstractDriverAdapter;
import edu.kis.powp.jobs2d.magicpresets.FiguresJane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.magicpresets.FiguresJoe;
import edu.kis.powp.jobs2d.drivers.command.ComplexCommandFactory;
public class SelectTestFigureOptionListener implements ActionListener {

	private final DriverManager driverManager;

	public SelectTestFigureOptionListener(DriverManager driverManager) {
		this.driverManager = driverManager;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()){
			case "Figure Joe 1":
				FiguresJoe.figureScript1(driverManager.getCurrentDriver());
				break;
			case "Figure Joe 2":
				FiguresJoe.figureScript2(driverManager.getCurrentDriver());
				break;
			case "Figure Jane":
				AbstractDriverAdapter driver = new AbstractDriverAdapter(driverManager.getCurrentDriver());
				FiguresJane.figureScript(driver);
				break;
			case "Square":
				AbstractDriverAdapter driverSquare = new AbstractDriverAdapter(driverManager.getCurrentDriver());
				ComplexCommandFactory.square(driverSquare).execute();
				break;
			case "Hexagon":
				AbstractDriverAdapter driverHexagon = new AbstractDriverAdapter(driverManager.getCurrentDriver());
				ComplexCommandFactory.hexagon(driverHexagon).execute();
				break;
		}

	}
}
