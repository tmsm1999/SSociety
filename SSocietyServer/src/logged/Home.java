package logged;

import java.io.Console;
import util.Help;
import util.Screen;

//-------------------------------------------------*Home*------------------------------------------------------
// This is the class that has the screens after an admin logs into the server.

public class Home
{
	// A Console object ('cons') will be used to read the user input.
	private static Console cons = System.console();
	private String loggedA;
	
	// The constructor of Home object receives the username (String) of the admin that logged in.
	
	public Home(String u)
	{
		loggedA = u;
	}
	
	//--------------------------------------------First Screen-------------------------------------------------
	// First Screen - this is the initial "screen" after the admin logs in.
	// Here, the admin can choose between 5 options that will display their respective screen.
	
	public void firstScreen()
	{
		int chosenOption = 0;
		
		// This loop is constantly displaying the options and waiting for input.
		// The only way to leave the loop is to insert a valid input.
		while(true)
		{
			System.out.println("SSociety Server");
			System.out.println();
			System.out.println("1 - Accounts Management");
			System.out.println("2 - Topics Management");
			System.out.println("3 - Network statistics");
			System.out.println("4 - Help");
			System.out.println("5 - Logout");
			System.out.println();
			
			// In case of input not being a number, the 'chosenOption' will be an invalid one (zero, in this case).
			try { chosenOption = Integer.parseInt(cons.readLine("Insert option number: ")); }
			catch(Exception e) { chosenOption = 0; }
			
			// If the input is 1, it leaves this screen and opens the Accounts Management Screen.
			if(chosenOption == 1)
				accountsScreen();
				
			// If the input is 2, it leaves this screen and opens the Topics Management Screen.
			else if(chosenOption == 2)
				topicsScreen();
			
			// If the input is 3, it leaves this screen and opens the Network Statistics Screen.
			else if(chosenOption == 3)
				statisticsScreen();
				
			// If the input is 4, it opens the help screen corresponding to the current one (First Screen).
			else if(chosenOption == 4)
				helpScreen("Home.firstScreen");
					
			// If the input is 5, the admin logs out, going to the very fist screen (SSocietyServer's first screen).
			else if(chosenOption == 5)
			{
				Screen.clear();
				System.out.println("You successfully logged out!"); //animation
				System.out.println("----------------------------");
				System.out.println();
				// By returning here, it will go back to 'loginScreen',
				//   that will return as well, and SSocietyServer's first screen will display.
				return;
			}
				
			// Else, if the input wasn't 1, 2, 3, 4 or 5, it is invalid (and it doesn't leave the while loop).
			else
			{
				Screen.clear();
				System.out.println("Invalid input!");
				System.out.println("---------------------------");
				cons.readPassword("Press Enter to continue...");
				Screen.clear();
			}
		}
	}

	//--------------------------------------Accounts Management Screen-----------------------------------------
	// Accounts Management Screen - this is the screen that displays when the admin wants to manage the network accounts.
	// Here, the admin can choose between 5 options that will display their respective screen.
	
	public void accountsScreen()
	{
		Screen.clear();
		
		int chosenOption = 0;
		
		// This loop is constantly displaying the options and waiting for input.
		// The only way to leave the loop is to insert a valid input.
		while(true)
		{
			System.out.println("Accounts Management");
			System.out.println();
			System.out.println("1 - Accounts creation");
			System.out.println("2 - Pending accounts validation");
			System.out.println("3 - Accounts banishment");
			System.out.println("4 - Help");
			System.out.println("5 - Back");
			System.out.println();
			
			// In case of input not being a number, the 'chosenOption' will be an invalid one (zero, in this case).
			try { chosenOption = Integer.parseInt(cons.readLine("Insert option number: ")); }
			catch(Exception e) { chosenOption = 0; }
			
			// If the input is 1, it leaves this screen and opens the Creation Screen (from 'AccountsManagement' class).
			if(chosenOption == 1)
				AccountsManagement.creationScreen();
			
			// If the input is 2, it leaves this screen and opens the Pending Screen (from 'AccountsManagement' class).
			else if(chosenOption == 2)
				AccountsManagement.pendingScreen();
			
			// If the input is 3, it leaves this screen and opens the Banishment Screen (from 'AccountsManagement' class).
			else if(chosenOption == 3)
				AccountsManagement.banishmentScreen(loggedA);
			
			// If the input is 4, it opens the help screen corresponding to the current one (Accounts Management Screen).
			else if(chosenOption == 4)
				helpScreen("Home.accountsScreen");
			
			// If the input is 5, it leaves this screen and goes back to the previous screen (First Screen).
			else if(chosenOption == 5)
			{
				Screen.clear();
				// By returning, it will go back to the First Screen.
				return;
			}
			
			// Else, if the input wasn't 1, 2, 3, 4 or 5, it is invalid (and it doesn't leave the while loop).
			else
			{
				Screen.clear();
				System.out.println("Invalid input!");
				System.out.println("---------------------------");
				cons.readPassword("Press Enter to continue...");
				Screen.clear();
			}
		}
	}
	
	//---------------------------------------Topics Management Screen------------------------------------------
	// Topics Management Screen - this is the screen that displays when the admin wants to manage the topics.
	// Here, the admin can choose between 5 options that will display their respective screen.
	
	public void topicsScreen()
	{
		Screen.clear();
		
		int chosenOption = 0;
		
		// This loop is constantly displaying the options and waiting for input.
		// The only way to leave the loop is to insert a valid input.
		while(true)
		{
			System.out.println("Topics Management");
			System.out.println();
			System.out.println("1 - Create a new topic");
			System.out.println("2 - Edit topics");
			System.out.println("3 - Delete topics");
			System.out.println("4 - Help");
			System.out.println("5 - Back");
			System.out.println();
			
			// In case of input not being a number, the 'chosenOption' will be an invalid one (zero, in this case).
			try { chosenOption = Integer.parseInt(cons.readLine("Insert option number: ")); }
			catch(Exception e) { chosenOption = 0; }
			
			// If the input is 1, it leaves this screen and opens the Creation Screen (from 'TopicsManagement' class).
			if(chosenOption == 1)
			{
				try { TopicsManagement.creationScreen(); }
				catch (Exception e) { }
			}
			
			// If the input is 2, it leaves this screen and opens the Edit Screen (from 'TopicsManagement' class).
			else if(chosenOption == 2)
			{
				try { TopicsManagement.editScreen(); }
				catch (Exception e) { }
			}
			
			// If the input is 3, it leaves this screen and opens the Deletion Screen (from 'TopicsManagement' class).
			else if(chosenOption == 3)
				TopicsManagement.deletionScreen(loggedA);
			
			// If the input is 4, it opens the help screen corresponding to the current one (Topics Management Screen).
			else if(chosenOption == 4)
				helpScreen("Home.topicsScreen");
			
			// If the input is 5, it leaves this screen and goes back to the previous screen (First Screen).
			else if(chosenOption == 5)
			{
				Screen.clear();
				// By returning, it will go back to the First Screen.
				return;
			}
			
			// Else, if the input wasn't 1, 2, 3, 4 or 5, it is invalid (and it doesn't leave the while loop).
			else
			{
				Screen.clear();
				System.out.println("Invalid input!");
				System.out.println("---------------------------");
				cons.readPassword("Press Enter to continue...");
				Screen.clear();
			}
		}
	}
	
	//---------------------------------------Network Statistics Screen-----------------------------------------
	
	public void statisticsScreen()
	{
		
	}
	
	//----------------------------------------------Help Screen------------------------------------------------
	// Help Screen - this is the screen that can be called in any other screen, when the user chooses the 'Help' option.
	// This screen prints instructions on how to interact with the screen where it is called.
	
	public void helpScreen(String current)
	{
		Screen.clear();
		System.out.println("Help");
		System.out.println();
		// Calls 'screen' method of 'Help' class for the current screen, that will display instructions.
		Help.screen(current);
		// In order to leave the help screen, the user has to press Enter.
		// For that, we use the method readPassword and that way nothing that the user tries to write will appear in the screen.
		cons.readPassword("Press Enter to leave the help screen and return to the previous menu.");
		Screen.clear();
	}	
}
