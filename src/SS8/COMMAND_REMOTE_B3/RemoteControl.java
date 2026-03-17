package COMMAND_REMOTE_B3;

import java.util.*;

// Remote điều khiển
class RemoteControl {
    private Map<Integer, Command> buttons = new HashMap<>();

    // lưu lịch sử để undo
    private Stack<Command> history = new Stack<>();

    public void setCommand(int slot, Command command) {

        buttons.put(slot, command);

        System.out.println("Đã gán command cho nút " + slot);
    }

    // nhấn nút
    public void pressButton(int slot) {

        Command cmd = buttons.get(slot);

        if (cmd != null) {

            cmd.execute();

            history.push(cmd); // lưu vào lịch sử
        }
    }

    // undo lệnh gần nhất
    public void undo() {

        if (!history.isEmpty()) {

            Command cmd = history.pop();

            cmd.undo();
        } else {
            System.out.println("Không có lệnh để undo.");
        }
    }
}