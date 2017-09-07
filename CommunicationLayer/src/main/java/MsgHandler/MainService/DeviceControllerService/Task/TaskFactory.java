package MsgHandler.MainService.DeviceControllerService.Task;

public class TaskFactory {

    public String dispatcher(String task, String msg) {
        switch (task) {
            case "Control":
                Task tasker = new Control();
                return tasker.doTask(msg);
        }
        return "[Error] bad input: " + msg;
    }
}

