package packages.weather.mvc.views;


import packages.weather.mvc.interfaces.IController;
import packages.weather.mvc.interfaces.IModelListener;
import packages.weather.mvc.interfaces.IView;
import packages.weather.mvc.model.WeatherModel;
import packages.weather.mvc.utils.UpdateAction;

import javax.swing.*;

/**
 * * Created by Mihai on 11/23/2014.
 * The WeatherView implements the MVCs view class
 */
public class WeatherView extends JFrame implements IView, IModelListener {

    private static final long serialVersionUID = -5758555454500685115L;

    //the view components
    private JTextField tfTemperature = new JTextField(10);
    private JTextField tfPressure = new JTextField(10);

    private JButton btnUpdate = new JButton("Update Values");

    private IController mController;
    private WeatherModel mModel;

    /**
     * The WeatherView constructor initializes the view components and it layouts them
     */
    public WeatherView(){

        tfTemperature.setEditable(false);
        tfPressure.setEditable(false);

        // Layout the components.
        JPanel content = new JPanel();
        content.setLayout(new BoxLayout(content,BoxLayout.Y_AXIS));
        content.add(new JLabel("WEATHER IN BUCHAREST"));
        content.add(new JLabel("    "));
        content.add(new JLabel("    "));

        content.add(new JLabel("Temperature:"));
        content.add(tfTemperature);
        content.add(new JLabel("Pressure:"));
        content.add(tfPressure);

        content.add(btnUpdate);

        // Finalize layout
        this.setContentPane(content);
        this.pack();

        this.setTitle("Weather App");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    /**
     * This method adds a model reference to the view
     * @param model The WeatherModel
     */

    public void addModel(WeatherModel model) {
        mModel = model;
        tfTemperature.setText(model.getTemperature());
        tfPressure.setText(model.getPressure());

    }

    /**
     * This methods sets the event listener for this view- the controller
     * @param controller The WeatherController
     */

    public void addController(IController controller) {
        if (btnUpdate.getAction() == null)
            btnUpdate.setAction(new UpdateAction());
        btnUpdate.setText("Update");
        btnUpdate.setActionCommand(IController.ACTION_UPDATE);
        btnUpdate.addActionListener(controller);

    }

    /**
     * updates the view when changes to the model have been made
     */

    @Override
    public void onUpdate() {

        tfTemperature.setText(mModel.getTemperature());
        tfPressure.setText(mModel.getPressure());


    }

    /**
     * This function displays and Error or a Message
     * @param errorStatus if true the message displayed comes from an error
     * @param message The message to be displayed
     */

    @Override
    public void onMessage(boolean errorStatus, String message) {

        if (errorStatus) {
            JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, message, "Weather MVC", JOptionPane.INFORMATION_MESSAGE);
        }

    }
}
