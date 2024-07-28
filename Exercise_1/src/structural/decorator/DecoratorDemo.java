public class DecoratorDemo {
    public static void main(String[] args) {
        MedicalService basicCheckup = new BasicCheckup();
        MedicalService advancedCheckup = new AdvancedCheckup(basicCheckup);

        System.out.println("Basic Checkup:");
        basicCheckup.performService();

        System.out.println("\nAdvanced Checkup:");
        advancedCheckup.performService();
    }
}
