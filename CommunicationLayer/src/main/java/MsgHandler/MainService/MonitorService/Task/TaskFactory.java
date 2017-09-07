package MsgHandler.MainService.MonitorService.Task;

public class TaskFactory {
    public String dispatcher(String task, String msg) {
        switch (task) {
            case "Report":
                Task tasker = new Report();
                return tasker.doTask(msg);
        }
        return "[Error] bad input: " + msg;
    }
}