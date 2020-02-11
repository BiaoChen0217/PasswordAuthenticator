package Authenticator;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.UUID;


public class User {
	  String username;
	  String userID;
	  String password;
	  String salt;
	  String hashcode;
	  //static int b=0;
	  static ArrayList<String>list = new ArrayList<String>();
	  
	public void instructions()
	{
		System.out.println("Enter 1 if you want to sign up a new user account");
		System.out.println("Enter 2 if you want to remove a user account");
		System.out.println("Enter 3 if you want to sign in!");
		System.out.println("Enter 4 if you want to leave!");
	}
	
	
	public void inputUserName()
	{

		Scanner input = new Scanner(System.in);
		System.out.println("Create your user name: ");
		username  = input.nextLine();
		//b=b+4;
		
	}
	public void UserID()
	{
		int a;
		Random r = new Random();
		int random1=r.nextInt(100);
		int random2=r.nextInt(100);
		int random3=r.nextInt(100);
		a=random1*random2*random3;
		userID=Integer.toString(a);
		
	}
	
	
	public void inputPassword()
	{

		Scanner input = new Scanner(System.in);
		System.out.println("Create your password: ");
		password  = input.nextLine();
		
		salt = UUID.randomUUID().toString();
		StringBuffer buf=new StringBuffer();
				buf.append(password);
				buf.append(salt);
				
				
		String PasswordSalt;
		PasswordSalt=buf.toString();
		int hashcode1=PasswordSalt.hashCode();
		hashcode=Integer.toString(hashcode1);
		
	}


	public void SaveList() throws IOException
	{
	
		list.add(userID);
		list.add(username);
		list.add(salt);
		list.add(hashcode);
		
		
		
		//FileWriter writer=new FileWriter("C:/Users/30133/Desktop/out.csv",true);
		FileWriter writer=new FileWriter("C:/Users/30133/Desktop/out.csv");
		for(int i=0;i<list.size();i++) {

			writer.append((String) list.get(i));
			writer.append(",");
			if((i+1)%4==0)
				 writer.write("\n");
		}  

		  writer.close();
	}
	public static int loadUsers() throws IOException, FileNotFoundException
	{
		String filePath;
		filePath = ("C:/Users/30133/Desktop/out.csv");
		
		//FileWriter fileWriter = new FileWriter(filePath , true);
		Scanner file = new Scanner (new File(filePath));
		while(file.hasNextLine())
		{
			//=new String[3];
		
			String line = new String(file.nextLine());
			if(line ==null)
				break;
			String arrayStr[]= line.split(",");
			
			
			
			list.add(arrayStr[0]);
			list.add(arrayStr[1]);
			list.add(arrayStr[2]);
			list.add(arrayStr[3]);
			//b++;
		}
		
		file.close(); 
		
		return 0;
	}
	
	
	public void Remove() throws IOException
	{
		String remove;
		boolean found=false;
		System.out.println("Please enter the user name you want to remove:");
		Scanner input = new Scanner(System.in);
		remove  = input.nextLine();
		int j=0;
		for(int i=0;i<list.size();i++) {
			if(remove.equals(list.get(i)))
				{
				found=true;
				j=i;
				}
			
		}
		if(found) {
			list.remove(j-1);	
			list.remove(j-1);
			list.remove(j-1);
			list.remove(j-1);
		}
		else
			System.out.println("The user name do not exist");
		
		FileWriter writer=new FileWriter("C:/Users/30133/Desktop/out.csv");
		for(int i=0;i<list.size();i++) {

			writer.append((String) list.get(i));
			writer.append(",");
			if((i+1)%4==0)
				 writer.write("\n");
		}  

		  writer.close();
	}

	public void Signup()
	{
		String signup;
		String truepass = null;
		String truesalt = null;
		String pass;
		boolean found=false;
		Scanner input = new Scanner(System.in);
		int j=0;
		while(!found) {
			
			System.out.println("Please enter the user name:");
			signup  = input.nextLine();
		for(int i=0;i<list.size();i++) {
			if(signup.equals(list.get(i)))
				{
				found=true;
				j=i;
				truesalt=list.get(j+1);
				truepass=list.get(j+2);
				}
			
		}


	}
		System.out.println("Please enter the password:");
		pass=input.nextLine();
		
		StringBuffer buff=new StringBuffer();
		buff.append(pass);
		buff.append(truesalt);
		
		
		String PassWordSalt;
		PassWordSalt=buff.toString();
		int hashcode2=PassWordSalt.hashCode();
		String hash=Integer.toString(hashcode2);
		if(hash.equals(truepass))
		{		
			System.out.println("Correct!Welcome to League of Legends");
			System.out.println(hash);
			System.out.println(truepass);
		}
	
		else		
			{System.out.println("PASSWORD ERROR!");
			System.out.println(hash);
			System.out.println(truepass);
			}
		

		
		
}
}
