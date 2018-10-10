package tips.service;

import tips.entity.MenuItemEnum;

public interface BillService {

	double countBill(MenuItemEnum ... menuItems);

}