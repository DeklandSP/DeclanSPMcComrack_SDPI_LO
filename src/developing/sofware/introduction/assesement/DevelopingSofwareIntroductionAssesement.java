
package developing.sofware.introduction.assesement;

/**
 *
 * @author Declan S P McCormack
 * 
 * Description:
 * This program has 2 main tasks it must do.
 * The first task is to take in a users forename and Surname and create a username using the forenames initial and the surname.
 * The second task is to take in a number and work out the factorial for that number.
 * 
 * Date:03/11/21
 */

//importing Scanner tool.
import java.util.Scanner;

public class DevelopingSofwareIntroductionAssesement 
{
    
    //Admin login variable.
    public static String adminUser = "";
        
    public static void main(String[] args) 
    {
        //asks for adminUserName
        System.out.print("Admin user required: ");
        
        //setting up scanner tool.
        Scanner userInput = new Scanner(System.in);
                
        //user inputs there admin login
        adminUser = userInput.nextLine();
                        
        //welcomes admin user.
        System.out.println("Welcome " + adminUser);
        System.out.println();
        
        //Calls the menu function after the adminUser has successfully logged in.
        menu();
    }
    
public static void menu()
{
    //declaring menu variables
    int choice;
            
    //setting up scanner tool.
    Scanner userInput = new Scanner(System.in);
            
    /*starting a do while loop so that the code that displays the options and allows the user to input those options is done at least once. 
    and so it will run untill the user enters the choice 3.*/
    do 
    {
        //prompt user for what they would like to do within the menu
        System.out.println("""
        1) Generate a username
        2) Work out the factorial of a number.
        3) Quit application.
        """);
                    
        //making the userInput take a variable from choice.
        choice = userInput.nextInt();
                                
        //setting up switch menu to let user call what operation they would like to do.
        switch(choice)
        {
                                        
            //This case will allow the user to input their forename and surname and generate a username from it.
            case 1 -> 
            {
                //calls the getFullname Function.
                getFullname();
                break;
            }
                                        
            // This case will allow the user to work out the factorial of a number they want.
            case 2 -> 
            {
                //calls the calculateFactorial function.
                calculateFactorial();
                break;
            }
                                        
            //This case will allow the user to quit the application.
            case 3 ->
            {
                System.out.println("Thank you for using the application. Goodbye!");
                break;
            }
                                        
            //this will tell the user to input a valid option
            default -> 
            {
                System.out.println("You must select options 1 - 3 only");
            }
        }    
    //ending of do while loop.                            
    }while(choice != 3);
            
    //closes scanner tool.
    userInput.close();
}
    
//this function asks the admin to enter the fullname of the individual they would like to make a username for.
public static void getFullname()
{
    //declaring variables to take in users fullname.
    String fullname = "";
            
    //setting up scanner tool.
    Scanner userInput = new Scanner(System.in);
                    
    //telling user what option they have selected.
    System.out.println(adminUser + " - you have selected option 1 - Generating a Username \n");
                            
    //asking admin for the fullname of the user that they would like to generate a fullname for.
    System.out.print("Please enter the fullname of the user you wish to generate a username for: ");
                                    
    //allow for admin to input the fullname.
    fullname = userInput.nextLine();
                                            
    //call the createUsername Function
    generateUsername(fullname);                                               
}
    
/*this function will take the fullname from the getFullname and use it in order to create a username. 
It does this by taking the first name and only using its first initial and then concatenates it with the 
last name in order to generate the username.*/
public static void generateUsername(String fullname)
{
    //creating variables to create username for the admin.
    String firstLetter;
    int pos;
    String lastName;
    String userName;
            
    /*assigning the first letter of the fullname to first letter variable to hold for userName creation. 
    0 is the starting position since I want it to start from the beginning,
    1 is for how many character I want to take and since I only want an inital I only take 1. */
    firstLetter = fullname.substring(0,1);
                    
    //assigning where the space is after the firstname to pos variable. The lastIndexOf looks for the last location a space occurs meaning that this will skip any middle names inputted.
    pos = fullname.lastIndexOf(" ");
                            
    //assign the lastname of the fullname to the lastname variable to use for userName creation. Adding a + 1 will move the position over by one so it won't keep the space in the last name variable.
    lastName = fullname.substring(pos + 1);
                                    
    //create the userName variable using the firstLetter variable and lastName variable.
    userName = firstLetter + lastName;
                                           
    System.out.println();
                                            
    //prints out the username that we created for the admin.
    System.out.println(adminUser + " - the username is: " +userName);
                                                            
    System.out.println();
}
    
/*This function allows the admin to input a number and recieve the factorial of that number back.*/
public static void calculateFactorial()
{
    //declaring variables required for calculating factorial number.
    int number = 0;
    int factorial = 1;
            
    //setting up scanner tool.
    Scanner userInput = new Scanner(System.in);
                    
    //tells the admin what option they have selected.
    System.out.println(adminUser + " - you have selected option 2 - Calculating a Factorial \n");
                            
    //ask admin what number they would like to work out the factorial too.
    System.out.print("Please enter the number you would like to calculate the factorial of: ");
                                    
    //allows for user to input the number. hasNextInt statement makes sure that the value the user is inputing is a integer otherwise it will proceed to
    if ( userInput.hasNextInt())
    {
        number = userInput.nextInt();
                                            
        //if statement to check if the number that was inputted is above zero.
        if(number > 0)
        {
                                                        
            // Start of for loop. This loop will make the count equal to the number and then it will times that number with the numbers that came before it until it has worked out the factorial of said number.
            for(int count = number; count > 0; count--)
            {
                                                            
                //if statement here to check if the count is greater than zero,
                if (count > 0)
                {
                    //process to work out factorial number is done here.
                    factorial = factorial * count;
            
                    // additional if else satement here to make sure that an additional asterix sign is not printed out once the number one is reached.
                    if(count == 1)
                    {
                        System.out.print(count);
                    }
            
                    else
                    {   
                        System.out.print(count + "x");
                    }
                                                                    
                }//end of second if statement.
                                                            
            }// end of for loop.
                                                        
        //prints out the factorial.
        System.out.print("=" + factorial);
                                                           
        System.out.println();
                                                           
        }// end of first if statement.
        
        //else statment reminds admin that the number they enter must enter a number greater than zero.
        else
        {
        System.out.println("Enter a positive whole number greater than 0");
        }     
    }
    
    //else statment reminds admin that the number they enter must enter a number greater than zero.
    else
    {
        System.out.println("Enter a whole number");
    }     
}
}