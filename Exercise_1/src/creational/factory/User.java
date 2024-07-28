public interface User {
    void displayRole();
}

class Doctor implements User {
    @Override
    public void displayRole() {
        System.out.println("I am a Doctor.");
    }
}

class Nurse implements User {
    @Override
    public void displayRole() {
        System.out.println("I am a Nurse.");
    }
}

class Patient implements User {
    @Override
    public void displayRole() {
        System.out.println("I am a Patient.");
    }
}
