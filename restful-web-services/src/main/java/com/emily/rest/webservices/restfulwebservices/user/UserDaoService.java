package com.emily.rest.webservices.restfulwebservices.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
    //JAP -> Database, for now we use UserDaoService -> static arraylist
    private static List<User> users = new ArrayList<>();

    private static int userCount = 0;
    static {
        users.add(new User(++userCount,"Adam",LocalDate.now().minusYears(30)));
        users.add(new User(++userCount,"Eve",LocalDate.now().minusYears(25)));
        users.add(new User(++userCount,"Jin",LocalDate.now().minusYears(20)));
    }

    public List<User> findAll(){
        return users;
    }

    public User findUser(int userid){
        for (User user: UserDaoService.users){
            if (user.getId() == userid) return user;
        }
        return null;
    }

    public User save(User user){
        user.setId(++userCount);
        users.add(user);
        return user;
    }

    public void deleteUserById(int id) {
        for (User user: UserDaoService.users){
            if (user.getId() == id) users.remove(user);
        }
    }
    
}
