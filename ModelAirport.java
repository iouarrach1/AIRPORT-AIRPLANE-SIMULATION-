import java.util.*;
import java.io.*;

public class ModelAirport {
    public static void main(String[] args) throws IOException
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter the name of the Airport: ");
        String name = keyboard.nextLine();
        Airport c= new Airport(name);
        System.out.printf("Please enter the name of the output file for Airport summary: ");
        String fileName = keyboard.nextLine();
        System.out.println("Please enter the number of minutes to allow new flights to move to the terminal: ");
        int min = keyboard.nextInt();
        c.initializeAirport();
        c.runAirport(min);
        c.generateAirportOutput(fileName);
        keyboard.close();
    }
}
