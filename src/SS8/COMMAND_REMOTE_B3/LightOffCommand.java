package COMMAND_REMOTE_B3;

class LightOffCommand implements Command {

    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.off();
    }

    public void undo() {
        light.on(); // undo tắt -> bật
    }
}