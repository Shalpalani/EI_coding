import java.util.Scanner;

public class rocket {

    private static final int STAGE_1_DURATION = 30; // seconds
    private static final int STAGE_2_DURATION = 40; // seconds

    private enum Stage {
        PRE_LAUNCH, STAGE_1, STAGE_2, ORBIT, FAILURE
    }

    private static Stage stage = Stage.PRE_LAUNCH;
    private static double fuel = 100.0;
    private static double altitude = 0.0;
    private static double speed = 0.0;
    private static int time = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter command:");
            String command = scanner.nextLine();

            if (command.startsWith("fast_forward ")) {
                int seconds = Integer.parseInt(command.split(" ")[1]);
                fastForward(seconds);
            } else {
                switch (command) {
                    case "start_checks":
                        startChecks();
                        break;
                    case "launch":
                        launch();
                        break;
                    default:
                        System.out.println("Invalid command.");
                }
            }
        }
    }

    private static void startChecks() {
        if (stage == Stage.PRE_LAUNCH) {
            System.out.println("All systems are 'Go' for launch.");
        } else {
            System.out.println("Checks can only be performed during pre-launch.");
        }
    }

    private static void launch() {
        if (stage == Stage.PRE_LAUNCH) {
            stage = Stage.STAGE_1;
            System.out.println("Launching...");
            simulate();
        } else {
            System.out.println("Launch can only be initiated from pre-launch state.");
        }
    }

    private static void simulate() {
        while (stage != Stage.ORBIT && stage != Stage.FAILURE) {
            updateState();
            printStatus();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Simulation interrupted.");
            }
        }
    }

    private static void fastForward(int seconds) {
        for (int i = 0; i < seconds; i++) {
            if (stage == Stage.ORBIT || stage == Stage.FAILURE) break;
            updateState();
        }
        printStatus();
    }

    private static void updateState() {
        time++;
        switch (stage) {
            case STAGE_1:
                fuel -= 0.5;
                altitude += 10;
                speed += 100;
                if (time >= STAGE_1_DURATION) {
                    stage = Stage.STAGE_2;
                    System.out.println("Stage 1 complete. Separating stage. Entering Stage 2.");
                }
                break;
            case STAGE_2:
                fuel -= 0.75;
                altitude += 15;
                speed += 200;
                if (time >= STAGE_1_DURATION + STAGE_2_DURATION) {
                    stage = Stage.ORBIT;
                    System.out.println("Orbit achieved! Mission Successful.");
                }
                break;
            default:
                break;
        }

        if (fuel <= 0) {
            stage = Stage.FAILURE;
            System.out.println("Mission Failed due to insufficient fuel.");
        }
    }

    private static void printStatus() {
        System.out.printf("Stage: %s, Fuel: %.1f%%, Altitude: %.1f km, Speed: %.1f km/h%n",
                stage.name(), fuel, altitude, speed);
    }
}
