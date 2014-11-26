package packages.weather.mvc.model;

import packages.weather.mvc.interfaces.IModelListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mihai on 11/23/2014.
 */
public class WeatherModel {


    private List<IModelListener> wheatherListeners;
    private double temperature;
    private double pressure;


    public WeatherModel()
    {
        temperature=0;
        pressure=0;

    }


    public void addListener(IModelListener listener)
    {

        if (wheatherListeners == null)
        {
            wheatherListeners=new ArrayList<IModelListener>();
        }
        wheatherListeners.add(listener);
    }


    private void notifyListeners()
    {
        if(wheatherListeners != null && !wheatherListeners.isEmpty() )
        {
            for(IModelListener listener : wheatherListeners)
                listener.onUpdate();
        }

    }

    public String getTemperature()
    {
        return String.valueOf(temperature);
    }

    public String getPressure()
    {
        return String.valueOf(pressure);
    }



    public void setWheatherValues(double temperature, double pressure)
    {
        this.temperature=temperature - 273.15;
        this.pressure= pressure;

        notifyListeners();

    }

}
