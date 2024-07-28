public class UserFactory {
    public User getUser(String userType) {
        if (userType == null) {
            return null;
        }
        if (userType.equalsIgnoreCase("DOCTOR")) {
            return new Doctor();
        } else if (userType.equalsIgnoreCase("NURSE")) {
            return new Nurse();
        } else if (userType.equalsIgnoreCase("PATIENT")) {
            return new Patient();
        }
        return null;
    }
}
