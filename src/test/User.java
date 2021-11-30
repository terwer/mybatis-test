package test;

/**
 * @author terwer
 * @Description
 * @create 2021-11-30 23:18
 */
public class User {
    int id;
    String username;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "id:" + id + ",username:" + username;
    }
}
