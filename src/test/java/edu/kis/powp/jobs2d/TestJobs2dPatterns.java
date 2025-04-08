package edu.kis.powp.jobs2d;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

import edu.kis.powp.jobs2d.drivers.command.CircleFactory;
import edu.kis.powp.jobs2d.drivers.command.RectangleFactory;
import edu.kis.legacy.drawer.panel.DefaultDrawerFrame;
import edu.kis.legacy.drawer.panel.DrawPanelController;
import edu.kis.legacy.drawer.shape.LineFactory;
import edu.kis.powp.appbase.Application;
import edu.kis.powp.jobs2d.drivers.adapter.FiguresJaneAdapter;
import edu.kis.powp.jobs2d.drivers.adapter.LineDrawerAdapter;
import edu.kis.powp.jobs2d.drivers.adapter.MyAdapter;
import edu.kis.powp.jobs2d.drivers.command.DriverCommand;
import edu.kis.powp.jobs2d.events.Figure;
import edu.kis.powp.jobs2d.events.SelectChangeVisibleOptionListener;
import edu.kis.powp.jobs2d.events.SelectTestFigureOptionListener;
import edu.kis.powp.jobs2d.features.DrawerFeature;
import edu.kis.powp.jobs2d.features.DriverFeature;
import java.awt.event.ActionListener;

public class TestJobs2dPatterns {
	private final static Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	/**
	 * Setup test concerning preset figures in context.
	 * 
	 * @param application Application context.
	 */
	private static void setupPresetTests(Application application) {

		application.addTest("Figure Joe 1",new SelectTestFigureOptionListener(
				DriverFeature.getDriverManager(), Figure.FIGURE_JOE_1));
		application.addTest("Rectangle",new SelectTestFigureOptionListener(
				DriverFeature.getDriverManager(), Figure.RECTANGLE));
		application.addTest("Circle",new SelectTestFigureOptionListener(
				DriverFeature.getDriverManager(), Figure.CIRCLE));


	}



	/**
	 * Setup driver manager, and set default driver for application.
	 * 
	 * @param application Application context.
	 */
	private static void setupDrivers(Application application) {
		Job2dDriver loggerDriver = new LoggerDriver();
		DriverFeature.addDriver("Logger Driver", loggerDriver);
		DriverFeature.getDriverManager().setCurrentDriver(loggerDriver);

		Job2dDriver testDriver = new MyAdapter(DrawerFeature.getDrawerController());

		DriverFeature.addDriver("Buggy Simulator", testDriver);

		// Nowe sterowniki z różnymi typami linii
		Job2dDriver basicLineDriver = new LineDrawerAdapter(LineFactory.getBasicLine());
		Job2dDriver dottedLineDriver = new LineDrawerAdapter(LineFactory.getDottedLine());
		Job2dDriver specialLineDriver = new LineDrawerAdapter(LineFactory.getSpecialLine());

		DriverFeature.addDriver("Basic Line Driver", basicLineDriver);
		DriverFeature.addDriver("Dotted Line Driver", dottedLineDriver);
		DriverFeature.addDriver("Special Line Driver", specialLineDriver);

		// Ustawienie domyślnego sterownika
		DriverFeature.getDriverManager().setCurrentDriver(basicLineDriver);

		DriverFeature.updateDriverInfo();
	}

	/**
	 * Auxiliary routines to enable using Buggy Simulator.
	 * 
	 * @param application Application context.
	 */
	private static void setupDefaultDrawerVisibilityManagement(Application application) {
		DefaultDrawerFrame defaultDrawerWindow = DefaultDrawerFrame.getDefaultDrawerFrame();
		application.addComponentMenuElementWithCheckBox(DrawPanelController.class, "Default Drawer Visibility",
				new SelectChangeVisibleOptionListener(defaultDrawerWindow), true);
		defaultDrawerWindow.setVisible(true);
	}

	/**
	 * Setup menu for adjusting logging settings.
	 * 
	 * @param application Application context.
	 */
	private static void setupLogger(Application application) {
		application.addComponentMenu(Logger.class, "Logger", 0);
		application.addComponentMenuElement(Logger.class, "Clear log",
				(ActionEvent e) -> application.flushLoggerOutput());
		application.addComponentMenuElement(Logger.class, "Fine level", (ActionEvent e) -> logger.setLevel(Level.FINE));
		application.addComponentMenuElement(Logger.class, "Info level", (ActionEvent e) -> logger.setLevel(Level.INFO));
		application.addComponentMenuElement(Logger.class, "Warning level",
				(ActionEvent e) -> logger.setLevel(Level.WARNING));
		application.addComponentMenuElement(Logger.class, "Severe level",
				(ActionEvent e) -> logger.setLevel(Level.SEVERE));
		application.addComponentMenuElement(Logger.class, "OFF logging", (ActionEvent e) -> logger.setLevel(Level.OFF));
	}

	private static void setupLineDrawerMenu(Application application) {
		application.addComponentMenu(LineDrawerAdapter.class, "Line Drawer Options", 0);

		application.addComponentMenuElement(LineDrawerAdapter.class, "Use Basic Line",
				(ActionEvent e) -> DriverFeature.getDriverManager().setCurrentDriver(new LineDrawerAdapter(LineFactory.getBasicLine())));

		application.addComponentMenuElement(LineDrawerAdapter.class, "Use Dotted Line",
				(ActionEvent e) -> DriverFeature.getDriverManager().setCurrentDriver(new LineDrawerAdapter(LineFactory.getDottedLine())));

		application.addComponentMenuElement(LineDrawerAdapter.class, "Use Special Line",
				(ActionEvent e) -> DriverFeature.getDriverManager().setCurrentDriver(new LineDrawerAdapter(LineFactory.getSpecialLine())));
	}


	private static void setupFiguresJaneTest(Application application) {
		Job2dDriver currentDriver = DriverFeature.getDriverManager().getCurrentDriver();
		FiguresJaneAdapter adapter = new FiguresJaneAdapter(currentDriver);

		application.addTest("FiguresJane Demo", (ActionEvent e) -> {
			adapter.drawFiguresJane();
		});
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				Application app = new Application("2d jobs Visio");
				DrawerFeature.setupDrawerPlugin(app);
				setupDefaultDrawerVisibilityManagement(app);

				DriverFeature.setupDriverPlugin(app);
				setupDrivers(app);
				setupPresetTests(app);
				setupLogger(app);
				setupLineDrawerMenu(app);
				setupFiguresJaneTest(app);

				app.setVisibility(true);
			}
		});
	}

}
