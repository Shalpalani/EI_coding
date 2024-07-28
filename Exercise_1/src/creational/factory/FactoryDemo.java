public class FactoryDemo {
    public static void main(String[] args) {
        UserFactory userFactory = new UserFactory();

        User user1 = userFactory.getUser("DOCTOR");
        user1.displayRole();

        User user2 = userFactory.getUser("NURSE");
        user2.displayRole();

        User user3 = userFactory.getUser("PATIENT");
        user3.displayRole();
    }
}
