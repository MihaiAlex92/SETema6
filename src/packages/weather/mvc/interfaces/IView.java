package packages.weather.mvc.interfaces;

/**
 * Created by Mihai on 11/23/2014.
 */
public interface IView {

     /**
     * This function receives messages from the controller
     * @param errorValue when <code>true</code>, the message represents an error;
     * @param message the message which needs to be displayed
     */
    public void onMessage(boolean errorValue, String message);
}
