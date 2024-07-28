public class AdvancedCheckup extends MedicalServiceDecorator {
    public AdvancedCheckup(MedicalService decoratedService) {
        super(decoratedService);
    }

    @Override
    public void performService() {
        super.performService();
        System.out.println("Performing advanced checkup.");
    }
}
