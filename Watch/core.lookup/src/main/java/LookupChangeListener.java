/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author younes
 */
public interface LookupChangeListener {

    public void newServiceIsRegistred(Class service, Object instance);
    public void newServiceIsRequested(Class service, Object returnedInstance);
    
}
