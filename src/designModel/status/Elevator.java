package designModel.status;

/**
 * 电梯状态设计
 * Col1	    开门 关门 运行 停止
 * 开门 态	no	yes	no	no
 * 关门 态	yes	no	yes	yes
 * 运行 态	no	no	no	yes
 * 停止 态	yes	no	yes	no
 */
public class Elevator {
    public static void main(String[] args) {
        Elevator elevator = new Elevator();
        elevator.setMyStatus(new stoppingStatus(elevator));
        elevator.open();
    }
    LiftStatus opening, closing, stopping, running;
    LiftStatus myStatus;
    {
        opening = new openingStatus(this);
        closing = new closingStatus(this);
        stopping = new stoppingStatus(this);
        running = new runStatus(this);
    }

    public LiftStatus getOpening() {
        return opening;
    }

    public void setOpening(LiftStatus opening) {
        this.opening = opening;
    }

    public LiftStatus getClosing() {
        return closing;
    }

    public void setClosing(LiftStatus closing) {
        this.closing = closing;
    }

    public LiftStatus getStopping() {
        return stopping;
    }

    public void setStopping(LiftStatus stopping) {
        this.stopping = stopping;
    }

    public LiftStatus getRunning() {
        return running;
    }

    public void setRunning(LiftStatus running) {
        this.running = running;
    }

    public LiftStatus getMyStatus() {
        return myStatus;
    }

    public void setMyStatus(LiftStatus myStatus) {
        this.myStatus = myStatus;
    }

    void run() {
        myStatus.run();
    }

    void close() {
        myStatus.closeDoor();
    }

    void open() {
        myStatus.openDoor();
    }

    void stop() {
        myStatus.stop();
    }
}

abstract class LiftStatus {
    Elevator elevator;

    LiftStatus(Elevator elevator) {
        this.elevator = elevator;
    }

    abstract void stop();

    abstract void run();

    abstract void openDoor();

    abstract void closeDoor();
}

class openingStatus extends LiftStatus {

    openingStatus(Elevator elevator) {
        super(elevator);
    }

    @Override
    void stop() {

    }

    @Override
    void run() {

    }

    @Override
    void openDoor() {
        System.out.println("开门");
    }

    @Override
    void closeDoor() {
        elevator.setMyStatus(elevator.getClosing());
        elevator.close();
    }

}

class closingStatus extends LiftStatus {

    closingStatus(Elevator liftStatus) {
        super(liftStatus);
    }

    @Override
    void stop() {
        elevator.setMyStatus(elevator.getStopping());
        elevator.stop();
    }

    @Override
    void run() {
        elevator.setMyStatus(elevator.getRunning());
        elevator.run();
    }

    @Override
    void openDoor() {
        elevator.setMyStatus(elevator.getOpening());
        elevator.open();
    }

    @Override
    void closeDoor() {
        System.out.println("关门");
    }
}

class runStatus extends LiftStatus {

    runStatus(Elevator liftStatus) {
        super(liftStatus);
    }

    @Override
    void stop() {
        elevator.setMyStatus(elevator.getStopping());
        elevator.stop();
    }

    @Override
    void run() {
        System.out.println("运行中");
    }

    @Override
    void openDoor() {

    }

    @Override
    void closeDoor() {

    }
}

class stoppingStatus extends LiftStatus {

    stoppingStatus(Elevator liftStatus) {
        super(liftStatus);
    }

    @Override
    void stop() {
        System.out.println("停止运行");
    }

    @Override
    void run() {

    }

    @Override
    void openDoor() {
        elevator.setMyStatus(elevator.getOpening());
        elevator.open();
    }

    @Override
    void closeDoor() {

    }
}
