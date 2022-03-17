public class Worker {

    private final OnTaskDoneListener callback;
    private final OnTaskErrorListener errorCallback;

    // constructor
    public Worker(OnTaskDoneListener callback, OnTaskErrorListener errorCallback) {
        this.callback = callback;
        this.errorCallback = errorCallback;
    }

    public void start(int forError) {
        for (int i = 0; i < 100; i++) { // 100 tasks in total
            if (i + 1 == forError) { // if a task is not successfully done
                errorCallback.onError("Task " + (i + 1) + " error!");
                continue;
            }
            callback.onDone("Task " + (i + 1) + " is done"); // listing all tasks for 1 to 100
        }
    }
}