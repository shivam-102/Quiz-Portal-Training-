package com.project.DAO;
import java.util.HashMap;
import java.util.Map;
public class CredentialsValidationDAO {
    public Map<String,String> credentials=new HashMap<>();
     public boolean checkCredentials(String userName, String password){
        if(credentials.containsKey(userName) && password.equals(credentials.get(userName))){
            return true;
        }
        else{
            return false;
        }
    }
    public void registerNewUser(String newUserId,String newPassword){
        credentials.put(newUserId,newPassword);
        }
        public boolean checkForUserName(String userIdCheck) {
            if (credentials.containsKey(userIdCheck)) {
                return true;
            }
            return false;
        }
}
