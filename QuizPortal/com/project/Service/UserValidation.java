package com.project.Service;
import com.project.DAO.CredentialsValidation;
import com.project.UI.AdminPortal;


public class UserValidation {
    public void verify(String username, String password){
        if(CredentialsValidation.checkCredentials(username, password)){
            AdminPortal.start();

        }
        else{
            System.out.println("Bad username or password. Please enter a valid one. Or Press 2 to sign-up");
        }

    }
    public boolean checkIfUserNameExists(String newUsername,String newPassword){
        if(CredentialsValidation.checkForUserName(newUsername)){
            return false;
        }
        else{
            CredentialsValidation.registerNewUser(newUsername,newPassword);
            return true;
        }
    }
}
