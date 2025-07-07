package survey;

public class UserInfo implements IUserProfile {
    private String name;
    private double age;
    private String email;

    public UserInfo(String name, double age, String email) throws IllegalArgumentException {
        setName(name);
        setAge(age);
        setEmail(email);
    }

    @Override
    public void setName(String name) throws IllegalArgumentException {
        if(name == null || name.isEmpty()) throw new IllegalArgumentException("Refusing to set an empty name");
        this.name = name;
    }

    @Override
    public void setAge(double age) throws IllegalArgumentException {
        if(age <= 13) throw new IllegalArgumentException("Refusing to set an age of 13 or under");
        this.age = age;
    }

    @Override
    public void setEmail(String email) throws IllegalArgumentException {
        if(email == null || email.isEmpty()) throw new IllegalArgumentException("Refusing to set empty email");
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
