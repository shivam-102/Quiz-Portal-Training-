package com.project;
import java.util.HashMap;
import java.util.Map;
public class AdminDB {
    Map<String,String> admin=new HashMap<>();
    boolean checkCredentials(String userName,String password){
        if(admin.containsKey(userName) && password.equals(admin.get(userName))){
            return true;
        }
        else{
            return false;
        }
    }
    void registerNewUser(String newUserId,String newPassword){
        admin.put(newUserId,newPassword);
        }
}
