package COMMAND_REMOTE_B3;

class ACSetTemperatureCommand implements Command {

    private AirConditioner ac;
    private int newTemp;
    private int oldTemp;

    public ACSetTemperatureCommand(AirConditioner ac, int temp) {
        this.ac = ac;
        this.newTemp = temp;
    }

    public void execute() {

        // lưu nhiệt độ cũ để undo
        oldTemp = ac.getTemperature();

        ac.setTemperature(newTemp);
    }

    public void undo() {

        // quay lại nhiệt độ cũ
        ac.setTemperature(oldTemp);

        System.out.println("Undo: Điều hòa quay lại " + oldTemp);
    }
}