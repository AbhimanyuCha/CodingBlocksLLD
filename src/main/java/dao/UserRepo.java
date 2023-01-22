package dao;

import enitities.User;

import java.util.HashMap;
import java.util.Map;

public class UserRepo {

    private Map<String, User> users;
    private static  UserRepo instance = null;
    private UserRepo(){
        users = new HashMap<>();
    }

    public static UserRepo getInstance(){
        if (instance == null){
            instance = new UserRepo();
        }
        return instance;
    }

    public boolean addUser(String userName){
        if(users.containsKey(userName)) {
            System.out.println("WARN : User Already Present with username " + userName);
            return false;
        }
        users.put(userName, User.builder().rating(1500).username(userName).build());
        return true;
    }

    public boolean removeUser(String userName){
        if(!users.containsKey(userName)){
            System.out.println("ERROR : User not present with userName " + userName);
            return false;
        }
        users.remove(userName);
        return true;
    }

    public User getUser(String userName){
        if(!users.containsKey(userName)){
            System.out.println("ERROR : User not present with userName" + userName);
            return null;
        }
        return users.get(userName);
    }

    public Map<String, User> getUsers(){
        return users;
    }


}
