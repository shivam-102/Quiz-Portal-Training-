package com.project.Service;
import com.project.DAO.CredentialsValidationDAO;
import com.project.UI.AdminPortal;


public class UserValidation {
    AdminPortal adminPortal=new AdminPortal();
    CredentialsValidationDAO credentialsValidationDAO=new CredentialsValidationDAO();
    public void verify(String username, String password){
        if(credentialsValidationDAO.checkCredentials(username, password)){
           adminPortal.start();

        }
        else{
            System.out.println("Bad username or password. Please enter a valid one. Or Press 2 to sign-up");
        }

    }
    public boolean checkIfUserNameExists(String newUsername,String newPassword){
        if(credentialsValidationDAO.checkForUserName(newUsername)){
            return false;
        }
        else{
            credentialsValidationDAO.registerNewUser(newUsername,newPassword);
            return true;
        }
    }
}
