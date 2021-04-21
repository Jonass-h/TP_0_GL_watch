/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author younes
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

    /*
    * Note :
    * our implementaion of the lookup doesn't respect the "Single Responsability" principle
    * and we let as it is because we've followed the given class diagram.
    * we can get rid of this problem by using the deligation design pattern to let our lookup
    * deligate the observal task to other class.
    */
public class Lookup {
    
        /*
        *properties
        */
	static private Lookup INSTANCE = null ;
                static private Object lock = new Object() ;
	Set<LookupChangeListener> listeners = new HashSet<LookupChangeListener>() ;; 
	private Map<Class, Object> services = new HashMap<Class, Object>() ;
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        /*
        * methods
        */
	private Lookup() {
                    System.out.println(" \n -- lookup created !! -- \n");
	}
	static public Lookup GET_INSTANCE () {
                        if(INSTANCE==null){
                            synchronized(lock){
                                if(INSTANCE==null){
                                    INSTANCE=new Lookup();
                                }
                            }
                        }
	        return INSTANCE ; 
	}
	public <T> void register (
			Class<? super T> service,
			T instance) {
		services.put(service, instance) ;
                /*
                this loop is used to notify all registred listeners
                */
		for (LookupChangeListener l : listeners)
			l.newServiceIsRegistred(service, instance);
	}
        	public <T> void unregister (
			Class<? super T> service) {
		services.remove(service) ;
                /*
                this loop is used to notify all registred listeners
                */
		for (LookupChangeListener l : listeners)
			l.newServiceIsRegistred(service, instance);
	}
	
	public <T> T get(Class<T> service) {
		T instance = (T) (services.get(service)) ;
                /*
                this loop is also used to notify all registred listeners
                */
		for (LookupChangeListener l : listeners)
			l.newServiceIsRequested(service, instance);
		return instance ; 
	}
	public void addListener (LookupChangeListener l) {
		listeners.add(l) ;
	}
	public void removeListener (LookupChangeListener l) {
		listeners.remove(l) ;
	}
}

