package com.project.Service;
import com.project.DAO.CredentialsValidationDAO;
public class UserValidation {
    CredentialsValidationDAO credentialsValidationDAO=new CredentialsValidationDAO();
    public boolean verify(String username, String password){
        return credentialsValidationDAO.checkCredentials(username, password);
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
