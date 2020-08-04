package Instance;

public class SingleInstance {
    private static volatile SingleInstance singinstance;

    private SingleInstance() {

    }

    static public SingleInstance getInstance() {
        if (singinstance == null) {
            synchronized (SingleInstance.class) {
                if (singinstance == null) {
                    singinstance = new SingleInstance();
                }
            }
        }
        return singinstance;
    }
}
