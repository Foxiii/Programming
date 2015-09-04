import javax.swing.*;

/**
 * Class SimpleIO - class for input of simple input types
 * via simple dialog box and output of strings
 * 
 */

public class SimpleIO
{
    // instance variables
    static final String STRING_TITLE = "String eingeben";
    static final String CHAR_TITLE = "char eingeben";
    static final String INT_TITLE = "int eingeben";
    static final String BOOLEAN_TITLE = "true oder false eingeben";
    static final String FLOAT_TITLE = "float eingeben";
    static final String DOUBLE_TITLE = "double eingeben";
    static final String TRUE = "Richtig";
    static final String FALSE = "Falsch";
    static final String EMPTY_STRING = "";
    
    /**
     ** String input from the user via a simple dialog.
     ** @param prompt the message string to be displayed inside dialog    
     ** @return String input from the user.
     **/
    public static String getString(String prompt)
    {
        Object[] commentArray = {prompt, EMPTY_STRING, EMPTY_STRING};
        Object[] options = { "OK" };

        boolean validResponse = false;

        String result = null;

        while(!validResponse) 
        {
            final JOptionPane optionPane = new JOptionPane(commentArray,
                                                JOptionPane.QUESTION_MESSAGE,
                                                JOptionPane.OK_CANCEL_OPTION,
                                                null,
                                                options, 
                                                options[0]);
            
            optionPane.setWantsInput(true);
            JDialog dialog = optionPane.createDialog(null, STRING_TITLE);

            dialog.pack();
            dialog.setVisible(true);
            
            Object response = optionPane.getInputValue();
            
            if(response != JOptionPane.UNINITIALIZED_VALUE) 
            {
                result = (String)response;
                validResponse = true;
            }      
            else 
            {
                commentArray[1] = "Invalid entry : " + result;
                commentArray[2] = "Enter a valid String";
            }
        }
        return result;
    }


    /**
     ** char input from the user via a simple dialog.
     ** @param prompt the message string to be displayed inside dialog  
     ** @return char input from the user.
     **/
    public static char getChar(String prompt)
    {
        char response ='-';

        String result = null;

        Object[] commentArray = {prompt, EMPTY_STRING, EMPTY_STRING};
        Object[] options = { "OK" };

        boolean validResponse = false;

        while(!validResponse) 
        {
            final JOptionPane optionPane = new JOptionPane(commentArray,
                                                JOptionPane.QUESTION_MESSAGE,
                                                JOptionPane.OK_CANCEL_OPTION,
                                                null,
                                                options, 
                                                options[0]);
            
            optionPane.setWantsInput(true);
            JDialog dialog = optionPane.createDialog(null, CHAR_TITLE);

            dialog.pack();
            dialog.setVisible(true);
            
            Object input = optionPane.getInputValue();
            if(input != JOptionPane.UNINITIALIZED_VALUE) 
            {
                result = (String)input;
                if(result != null && result.length() == 1) 
                {
                     response = result.charAt(0);
                     validResponse = true;
                }
                else 
                { 
                     commentArray[1] = "Invalid entry : " + result;
                     commentArray[2] = "Enter a single character"; 
                }
            }
            else 
            { 
                commentArray[1] = "Invalid entry : " + result;
                commentArray[2] = "Enter a single character"; 
            }
        }
        return response;
    }



    /**
     ** boolean selection from the user via a simple dialog.  
     ** @param  prompt message to appear in dialog
     ** @param  trueText message to appear on true "button"
     ** @param  falseText message to appear on "false" button
     ** @return boolean selection from the user
     **/
    public static boolean getBoolean(String prompt, String trueText, String falseText)
    {
        Object[] commentArray = {prompt, EMPTY_STRING};
        boolean validResponse = false;
        int result = -1;

        while(!validResponse)
        {
            Object[] options = {trueText, falseText};
            result = JOptionPane.showOptionDialog(null,
                                         commentArray,
                                         BOOLEAN_TITLE,
                                         JOptionPane.YES_NO_OPTION,
                                         JOptionPane.QUESTION_MESSAGE,
                                         null,     //don't use a custom Icon
                                         options,  //the titles of buttons
                                         TRUE );  //the title of the default button
            
            // check true or false buttons pressed
            if(result == 0 || result == 1)
                validResponse = true;
            else
                commentArray[1] = "Incorrect selection : Choose true or false buttons";
        }
        return (result == 0);
    }


    /**
     ** boolean selection from the user via a simple dialog.
     ** @param  prompt message to appear in dialog
     ** @return boolean selection from the user
     **/
    public static boolean getBoolean(String prompt)
    {
        return getBoolean(prompt, TRUE, FALSE);
    }


   /**
    ** returns integer input from the user via a simple dialog.
    ** @param prompt the message string to be displayed inside dialog
    ** @return the input integer
    **/
    public static int getInt(String prompt)
    {
        Object[] commentArray = {prompt, EMPTY_STRING, EMPTY_STRING};
        Object[] options = { "OK" };

        boolean validResponse = false;

        int response = 0;
        while(!validResponse) 
        {
            final JOptionPane optionPane = new JOptionPane(commentArray,
                                                JOptionPane.QUESTION_MESSAGE,
                                                JOptionPane.OK_CANCEL_OPTION,
                                                null,
                                                options, 
                                                options[0]);
            
            optionPane.setWantsInput(true);
            JDialog dialog = optionPane.createDialog(null, INT_TITLE);

            dialog.pack();
            dialog.setVisible(true);
            
            String result = (String)optionPane.getInputValue();

            try 
            {
                //workaround for BlueJ bug - misses first exception after compilation
                response = Integer.parseInt(result);
                response = Integer.parseInt(result);
                validResponse = true;      
            } 
            catch(NumberFormatException exception) 
            {
                if(result.equals("uninitializedValue"))
                        result = "";    
                commentArray[1] = "Invalid int: " + result;
                commentArray[2] = "Enter a valid integer";
            }
        }
        return response;
    }


   /**
    ** returns a float input from the user via a simple dialog.
    ** @param prompt the message string to be displayed inside dialog
    ** @return the input float
    **/
    public static float getFloat(String prompt)
    {
        Object[] options = { "OK" };
        Object[] commentArray = {prompt, EMPTY_STRING, EMPTY_STRING};

        boolean validResponse = false;

        float response = 0.0f;

        while(!validResponse) 
        {
            final JOptionPane optionPane = new JOptionPane(commentArray,
                                                JOptionPane.QUESTION_MESSAGE,
                                                JOptionPane.OK_CANCEL_OPTION,
                                                null,
                                                options, 
                                                options[0]);
            
            optionPane.setWantsInput(true);
            JDialog dialog = optionPane.createDialog(null, FLOAT_TITLE);

            dialog.pack();
            dialog.setVisible(true);
            
            String result = (String)optionPane.getInputValue();
            
            // convert String to float
            try 
            {
                // workaround for BlueJ bug - misses first exception after recompilation?
                response = Float.valueOf(result).floatValue();
                response = Float.valueOf(result).floatValue();
                validResponse = true;      
            } 
            catch(NumberFormatException exception) 
            {
                commentArray[1] = "Invalid float: " + result;
                commentArray[2] = "Enter a valid float";
            }
        }
        return response;
    }

   /**
    ** returns a double input from the user via a simple dialog.
    ** @param prompt the message string to be displayed inside dialog
    ** @return the input double
    **/
    public static double getDouble(String prompt)
    {
        Object[] options = { "OK" };
        Object[] commentArray = {prompt, EMPTY_STRING, EMPTY_STRING};

        boolean validResponse = false;

        double response = 0.0d;

        while(!validResponse) 
        {
            final JOptionPane optionPane = new JOptionPane(commentArray,
                                                JOptionPane.QUESTION_MESSAGE,
                                                JOptionPane.OK_CANCEL_OPTION,
                                                null,
                                                options, 
                                                options[0]);
            
            optionPane.setWantsInput(true);
            JDialog dialog = optionPane.createDialog(null, DOUBLE_TITLE);

            dialog.pack();
            dialog.setVisible(true);
            
            String result = (String)optionPane.getInputValue();
            
            // convert String to double
            try 
            {
                // workaround for BlueJ bug - misses first exception after recompilation?
                response = Double.valueOf(result).doubleValue();
                response = Double.valueOf(result).doubleValue();
                validResponse = true;      
            } 
            catch(NumberFormatException exception) 
            {
                commentArray[1] = "Invalid double: " + result;
                commentArray[2] = "Enter a valid double";
            }
        }
        return response;
    }

    /** prints the string "content" in a window with the title "title"
     ** @param content the string to be displayed
     ** @param title the title of the display window
     **/
    public static void output (String content, String title) {
        JOptionPane.showMessageDialog (null,content,title,JOptionPane.PLAIN_MESSAGE); 
    }
        
   /** prints the string "content" in a window with the title "title" and ends the program afterwards
    ** @param content the string to be displayed
    ** @param title the title of the display window
    **/
    public static void outputEnd (String content, String title) {
        JOptionPane.showMessageDialog (null,content,title,JOptionPane.PLAIN_MESSAGE); 
        System.exit(0);
    }
    
}
