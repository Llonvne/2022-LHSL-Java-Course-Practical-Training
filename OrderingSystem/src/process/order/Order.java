package process.order;

import process.menu.Menu;
import process.order.status.OrderStatusController;

public class Order {
    private final OrderStatusController orderStatusController;
    private final Menu menu = new Menu();

    public Order(OrderStatusController orderStatusController){
        this.orderStatusController = orderStatusController;
    }


}
