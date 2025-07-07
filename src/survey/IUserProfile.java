package survey;

public interface IUserProfile {
    void setName(String name);
    void setAge(double age);
    void setEmail(String email);

    String getName();
    double getAge();
    String getEmail();

    String toString();
}
