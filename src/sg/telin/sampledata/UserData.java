package sg.telin.sampledata;

import java.util.ArrayList;
import java.util.List;

import sg.telin.backend.model.User;


public class UserData {
	public List<User> getAllUsers() {
        List<User> listUser = new ArrayList<User>();

        User u1 = new User();
        u1.setName("Darfat");
        u1.setUsername("asdf");
        u1.setEmail("asdf@yahoo.com");
        listUser.add(u1);
        
        u1 = new User();
        u1.setName("Mono");
        u1.setUsername("minuoka");
        u1.setEmail("mono@yahoo.com");
        listUser.add(u1);

        return listUser;
    }
}
