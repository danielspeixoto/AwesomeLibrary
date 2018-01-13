package com.library.creator;

import com.library.operation.PresenterOperation;
import com.library.operation.RentOperation;

public class OperationCreator {

    private static OperationCreator instance;
    private static String RENT_OP = "emp";

    private OperationCreator() {}

    public static OperationCreator getInstance() {
        if(instance == null) {
            instance = new OperationCreator();
        }
        return instance;
    }

    public PresenterOperation getOperation(String operation) {
        String data[] = operation.split(" ");
        String opName = data[0];
        int userId;
        int bookId;
        if(opName.equals(RENT_OP)) {
            userId = Integer.valueOf(data[1]);
            bookId = Integer.valueOf(data[2]);
            return new RentOperation(PresenterCreator.getInstance(), userId, bookId);
        }
        return null;
    }
}
