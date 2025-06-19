// Step 2: Command Interface
interface Command {
    void execute();
}

// Step 5: Receiver Class
class Light {
    private String location;

    public Light(String location) {
        this.location = location;
    }

    public void turnOn() {
        System.out.println(location + " light is ON");
    }

    public void turnOff() {
        System.out.println(location + " light is OFF");
    }
}

// Step 3: Concrete Command - Turn Light ON
class LightOnCommand implements Command {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.turnOn();
    }
}

// Step 3: Concrete Command - Turn Light OFF
class LightOffCommand implements Command {
    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.turnOff();
    }
}

// Step 4: Invoker Class
class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        if (command != null) {
            command.execute();
        } else {
            System.out.println("No command set.");
        }
    }
}

// Step 6: Test Class
public class CommandPatternExample {
    public static void main(String[] args) {
        // Create receiver
        Light livingRoomLight = new Light("Living Room");

        // Create commands
        Command lightOn = new LightOnCommand(livingRoomLight);
        Command lightOff = new LightOffCommand(livingRoomLight);

        // Create invoker
        RemoteControl remote = new RemoteControl();

        // Execute commands
        System.out.println("Turning on the light:");
        remote.setCommand(lightOn);
        remote.pressButton();

        System.out.println("\nTurning off the light:");
        remote.setCommand(lightOff);
        remote.pressButton();
    }
}
