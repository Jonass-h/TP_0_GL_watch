/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author younes
 */
public class ConsoleLogger implements LookupChangeListener{
    
	public void newServiceIsRegistred(Class service, Object instance) {
		System.out.println("- service  : << "+service+" >> is registred with instance : << "+instance+" >> at time = "+java.time.LocalTime.now() );
	}
	public void newServiceIsRequested(Class service, Object returnedInstance) {
		System.out.println("- service  : << "+service+" >> is requested with returned_instance : << "+returnedInstance+" >> at time = "+java.time.LocalTime.now());
	}
}


