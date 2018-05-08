package main;

import java.io.Console;
import java.io.IOException;

import util.Screen;


public class SSocietyClient
{
	private static Console cons = System.console();
	static String pathHome = System.getProperty("user.home");
	
	public static void helpScreen()
	{
		//open help file
		
		System.out.print("Press Enter to continue...");
	}
	
	public static void registrationScreen() throws IOException
	{
		int chosenOption = 0;
		
		while(true)
		{
			System.out.println("1 - Back");
			System.out.println("2 - Continue");
			
			try { chosenOption = Integer.parseInt(cons.readLine("Insert option number: ")); }
			catch(Exception e) { chosenOption = 0; Screen.clear();}
			
			if(chosenOption == 1)
			{
				Screen.clear();
				firstScreen();
			}
			else if (chosenOption == 2)
			{	
				Screen.clear();
				String username;
				char[] firstPassword;
				char[] secondPassword;
				
				System.out.println("Registration...");
				System.out.println();
				username = cons.readLine("Choose your username: ");
				firstPassword = cons.readPassword("Choose your password: ");
				secondPassword = cons.readPassword("Enter chosen password again: ");
				
				Registration userRegistration = new Registration(username, firstPassword, secondPassword);
				
				if (userRegistration.checkRegistration() == 0) 
				{
					Screen.clear();
					System.out.println("Congratulations! Registration concluded...");
					System.out.println("Wait for admin's decision.");
					cons.readLine("Press Enter to continue...");
					Screen.clear();
					firstScreen();
					
				}
				else if (userRegistration.checkRegistration() == 1)
				{
					Screen.clear();
					System.out.println("A user with this name already exists...");
					System.out.println("Choose another username and try again.");
					cons.readLine("Press Enter to continue...");
				}
				else if (userRegistration.checkRegistration() == 2)
				{
					Screen.clear();
					System.out.println("Entered passwords don't match");
					cons.readLine("Press Enter to continue...");
				}
				else if (userRegistration.checkRegistration() == 3)
				{
					Screen.clear();
					System.out.println("Registration request already done.");
					System.out.println("Please wait for admin's decision...");
					cons.readLine("Press Enter to continue...");
					
				}
				else if (userRegistration.checkRegistration() == 4)
				{
					Screen.clear();
					System.out.println("Your username can not contain the character '|'.");
					cons.readLine("Press Enter to continue...");
				}
				Screen.clear();
			}
		}
	}
	
	public static void loginScreen () throws IOException

	{	
		int chosenOption = 0;
		
		while (true)
		{
			System.out.println("1 - Back");
			System.out.println("2 - Continue");
			
			try { chosenOption = Integer.parseInt(cons.readLine("Insert option number: ")); }
			catch(Exception e) { chosenOption = 0; }
			
			if(chosenOption == 1)
			{	
				Screen.clear();
				firstScreen();
			}
			else if (chosenOption == 2)
			{	
				Screen.clear();
				boolean success = false;
				
				String username;
				char[] password;
				
				System.out.println("Login...");
				System.out.println();
				username = cons.readLine("Username: ");
				password = cons.readPassword("Password: ");
				
				Login userLogin = new Login(username, password);
				
				success = userLogin.checkLogin();
				
				if(success)
				{
					Screen.clear();
					System.out.println("You are logged in!");
					cons.readLine("Press Enter to continue...");
					//login animation
					//displays new screen -- inicio de sessao
				}
				else
				{
					cons.readLine("Press Enter to continue...");
					Screen.clear();
				}
			}	
			Screen.clear();
		}
	}
	
	
	public static void firstScreen() throws IOException
	{	
		int chosenOption = 0;
		
		while(true)
		{
			System.out.println("Welcome to SSociety!");
			System.out.println();
			System.out.println("1 - Login");
			System.out.println("2 - Register");
			System.out.println("3 - Help");
			System.out.println("4 - Exit");
			
			try { chosenOption = Integer.parseInt(cons.readLine("Insert option number: ")); }
			catch(Exception e) { chosenOption = 0; }
			
			if(chosenOption == 1) 
			{
				Screen.clear();
				loginScreen();
			}
			else if(chosenOption == 2) {
				Screen.clear();
				registrationScreen();
			}
			else if(chosenOption == 3)
			{
				helpScreen();
				//cat file with help instruction --> toko18
			}
			else if(chosenOption == 4)
			{	
				Screen.clear();
				System.exit(0);
			}
			Screen.clear();
		}
	}
	
	
	public static void main(String[] args) throws IOException 
	{	
		if(!FileSystem.checkFileSystem())
		{
			cons.readLine("Press Enter to continue...");
			Screen.clear();
			System.exit(0);
		}
		else
		{	
			Screen.clear();
			firstScreen();
		}
	}
}
