/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author
 */
public class MainApp 
{
    /*
    *we instantiate our gui member of the MainApp class
    */
    private static GuiImpl gui;
    public static void main( String[] args )
    {
        /*
         *instantiation of our services implementations.
        */
        Lookup lookup = Lookup.GET_INSTANCE();
        gui =  new GuiImpl();
        TimerImplementation timer = new TimerImplementation();
        /*
        * setup the listener for the lookup 
        * in our case it is the "console logger"
        *
        *and also the listener for the timer
        * which is the "GUI"
        */
        
        lookup.addListener(new ConsoleLogger());
        timer.addListener(gui);
        /*
        *registering our services 
        */
        lookup.register(TimerService.class, timer);
        /*
        * creation of the GUI
        */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                gui.setVisible(true);
            }
        });
    }
}