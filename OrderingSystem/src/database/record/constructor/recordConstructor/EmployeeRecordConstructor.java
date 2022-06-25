package database.record.constructor.recordConstructor;

import database.record.constructor.attributesConstructor.AttributesConstructor;
import database.record.types.MuteableRecord;

public class EmployeeRecordConstructor implements RecordConstructor{
    private final AttributesConstructor attributesConstructor;
    public EmployeeRecordConstructor(AttributesConstructor attributesConstructor){
        this.attributesConstructor = attributesConstructor;
    }
    @Override
    public MuteableRecord generatorEmptyRecord() {
        MuteableRecord record = attributesConstructor.constructor("employee_account",
                new String[]{"employee_account","employee_password","employee_identity"});
        record.setTableName("Employee");
        return record;
    }
}

