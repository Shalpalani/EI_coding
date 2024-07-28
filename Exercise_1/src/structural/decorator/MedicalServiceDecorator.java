public abstract class MedicalServiceDecorator implements MedicalService {
    protected MedicalService decoratedService;

    public MedicalServiceDecorator(MedicalService decoratedService) {
        this.decoratedService = decoratedService;
    }

    @Override
    public void performService() {
        decoratedService.performService();
    }
}
