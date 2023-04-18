package com.in28minutes;

public class UserValidationService {
    public boolean isUserValid(String user, String password){
        if(user.equals("Rishabh") && password.equals("Mishra"))
            return true;
        return false;
    }

}
