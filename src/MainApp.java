import packages.weather.mvc.controller.WeatherController;
import packages.weather.mvc.model.WeatherModel;
import packages.weather.mvc.views.WeatherView;

/**
 * Created by Mihai on 11/23/2014.
 * this is the main function which puts the program in execution
 */
public class MainApp {


    public static void main(String[] args) {

        //instantiate the MVC elements: model, controller, view
        WeatherModel model = new WeatherModel();
        WeatherController controller = new WeatherController();
        WeatherView view = new WeatherView();

        //add the view to the model
        model.addListener(view);

        //add the model and controller to the view
        view.addModel(model);
        view.addController(controller);

        //add the view and the model to the controller
        controller.addView(view);
        controller.addModel(model);

        //make view visible
        view.setVisible(true);


    }

}
