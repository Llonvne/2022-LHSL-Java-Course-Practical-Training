package database.record.constructor.recordConstructor;

import database.record.constructor.attributesConstructor.AttributesConstructor;
import database.record.types.MuteableRecord;

public class AppointmentRecordConstructor implements RecordConstructor{
    private final AttributesConstructor attributesConstructor;
    public AppointmentRecordConstructor(AttributesConstructor attributesConstructor){
        this.attributesConstructor = attributesConstructor;
    }
    @Override
    public MuteableRecord generatorEmptyRecord() {
        MuteableRecord record = attributesConstructor.constructor("appointment_name",
                new String[]{"appointment_name","appointment_time","appointment_number","phone_number","remarks"});
        record.setTableName("Appointment");
        return record;
    }

}

