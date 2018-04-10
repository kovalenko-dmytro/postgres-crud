package study.apach.app;

public enum OperationType {
    INDEX(0),
    LIST(1),
    CREATE(2),
    VIEW(3),
    EDIT(4),
    DELETE(5),
    EXIT(6);

    OperationType(int numOfOperation) {
        this.numOfOperation = numOfOperation;
    }

    private int numOfOperation;

    public int getNumOfOperation() {
        return numOfOperation;
    }

    public void setNumOfOperation(int numOfOperation) {
        this.numOfOperation = numOfOperation;
    }
}
