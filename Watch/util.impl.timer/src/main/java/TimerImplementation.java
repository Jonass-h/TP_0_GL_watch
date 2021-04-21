/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author younes
 */
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

public class TimerImplementation implements TimerService{

    Set<TimerListener> observers = null;
    Integer lastHours;
    Integer lastMinutes;
    Integer lastSeconds;
    Timer tt = new Timer() ;
    
    
    public TimerImplementation(){
        observers=new HashSet<>();
        //OnSecondElapsed();
        
        TimerTask t = new TimerTask() {			
			@Override
			public void run() {
                            
        
                            lastHours = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
                            lastMinutes = Calendar.getInstance().get(Calendar.MINUTE);
                            lastSeconds = Calendar.getInstance().get(Calendar.SECOND);
			
                        oneSecondElapsed();
			}
		}; 
		tt.scheduleAtFixedRate(t, 0, 1000);
    }
    /*
     * observer methods
    */
    public void addListener(TimerListener service){
    observers.add(service) ;
    }
    
    
    public void removeListener(TimerListener service){
    observers.remove(service) ;
    
    }

    // usefull methods
    public Integer getLastHours() {
        return lastHours;
    }

    public Integer getLastMinutes() {
        return lastMinutes;
    }

    public Integer getLastSeconds() {
        return lastSeconds;
    }

    public void oneSecondElapsed() {
               for (TimerListener l: observers) {
			l.update();
	}
     }   
}