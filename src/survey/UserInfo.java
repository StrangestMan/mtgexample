package survey;

public class UserInfo implements IUserProfile {
    private final String name;
    private final double age;
    private final String email;

    public UserInfo(String name, double age, String email) throws IllegalArgumentException {
        if(name == null || name.isEmpty()) throw new IllegalArgumentException("Refusing to create UserInfo instance with empty name");
        if(age <= 13) throw new IllegalArgumentException("Refusing to create UserInfo instance with <= 13 year old age");
        if(email == null || email.isEmpty()) throw new IllegalArgumentException("Refusing to create UserInfo instance with empty email");

        this.name = name;
        this.age = age;
        this.email = email;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getAge() {
        return age;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Username: " + name + "\t" +
                "Age: " + age + "\n" +
                "Email: " + email;
    }
}
