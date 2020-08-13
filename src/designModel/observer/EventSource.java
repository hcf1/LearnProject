package designModel.observer;

import java.util.LinkedList;

public class EventSource {
    LinkedList<Listener> listeners = new LinkedList<>();
    Event mEvent = new Event();

    void add(Listener listener) {
        listeners.add(listener);
    }

    void remove(Listener listener) {
        listeners.remove(listener);
    }

    void fireEvent(String status) {
        mEvent.setStatus(status);
        for (Listener listener : listeners) {
            listener.handEvent(mEvent);
        }
    }

    public static void main(String[] args) {
        EventSource eventSource = new EventSource();
        eventSource.add(new myListener1());
        eventSource.add(new myListener2());
        eventSource.add(new myListener3());
        eventSource.fireEvent("1");
        eventSource.fireEvent("2");
    }
}
class Event{
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
interface Listener {
    void handEvent(Event event);
}
class myListener1 implements Listener {

    @Override
    public void handEvent(Event event) {
        if ("1".equals(event.getStatus())) {
            System.out.println("my1"+event.getStatus());
        }
    }
}
class myListener2 implements Listener {

    @Override
    public void handEvent(Event event) {
        if ("2".equals(event.getStatus())) {
            System.out.println("my2"+event.getStatus());
        }
    }
}
class myListener3 implements Listener {

    @Override
    public void handEvent(Event event) {
        if ("2".equals(event.getStatus())) {
            System.out.println("my3"+event.getStatus());
        }
    }
}
