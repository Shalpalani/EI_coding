package behavioral.observer;

public class ObserverDemo {
    public static void main(String[] args) {
        Subject doctor = new Subject();

        Observer nurse = (String message) -> {
            System.out.println("Nurse: " + message);
        };

        Observer patient = (String message) -> {
            System.out.println("Patient: " + message);
        };

        doctor.attach(nurse);
        doctor.attach(patient);

        doctor.setMessage("The doctor is now available.");
    }
}
