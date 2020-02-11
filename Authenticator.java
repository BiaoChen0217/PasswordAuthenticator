package Authenticator;
import java.io.IOException;
import java.util.Scanner;
import java.util.UUID;
public class Authenticator {

	public static void main(String[] args) throws IOException {

		User user =new User();
		user.loadUsers();
		Scanner input = new Scanner(System.in);
		int a=0;
		do {	
		user.instructions();
		a=input.nextInt();
		switch (a){
		case 1:
			user.inputUserName();
			user.inputPassword();
			user.UserID();
			user.SaveList();
			break;
		case 2:
			user.Remove();
			break;
		case 3:
			user.Signup();
			break;	
		}


		}while(a!=4);

	}

}
