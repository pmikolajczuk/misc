package pl.mikolaj.old.rest;

import com.google.gson.Gson;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DatabaseClientMock {
    private Gson gson = new Gson();
    private List<User> users = new ArrayList<>();

    public DatabaseClientMock() {
        User user = new User("Piotr", 38, "yyy");
        addUser(user);
    }

    @GetMapping("/users")
    public String getUsers() {

        String json = gson.toJson(users);
        return json;
    }

    @GetMapping("/user/{userName}")
    public String getUser(@PathVariable("userName")  String userName) {
        User user = users
                .stream()
                .filter(u -> userName.equals(u.getUserName()))
                .findFirst()
                .orElse(null);

        String json = gson.toJson(user);
        return json;
    }

    @PostMapping("/users")
    public void addUser(@RequestBody User user) {
        users.add(user);
    }

}
