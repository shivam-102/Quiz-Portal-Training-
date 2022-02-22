package com.project.DAO;
import java.util.HashMap;
import java.util.Map;
public class CredentialsValidationDAO {
    public Map<String,String> credentials=new HashMap<>();
     public boolean checkCredentials(String userName, String password){
         return credentials.containsKey(userName) && password.equals(credentials.get(userName));
    }
    public void registerNewUser(String newUserId,String newPassword){
        credentials.put(newUserId,newPassword);
        }
        public boolean checkForUserName(String userIdCheck) {
         return credentials.containsKey(userIdCheck);
     }
}
