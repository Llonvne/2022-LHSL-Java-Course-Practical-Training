package process.menu;

import database.record.types.ImmutableRecord;
import ui.FormHandler;

public interface Menu extends Iterable<ImmutableRecord>{

    double getPrice();

    FormHandler list();

    void appendNewMenu(Menu menu);

    void update();
}
