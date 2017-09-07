package MsgHandler.MainService.DeviceManagerService.Task;

public class TaskFactory {

    public String dispatcher(String task, String msg) {
        switch (task) {
            case "Register":
                Task tasker = new Register();
                return tasker.doTask(msg);
        }
        return "[Error] bad input: " + msg;
    }
}
