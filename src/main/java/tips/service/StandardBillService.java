package tips.service;

import tips.entity.MenuItemEnum;

import java.util.Arrays;

public class StandardBillService implements BillService {

	@Override
	public double countBill(MenuItemEnum... menuItems) {
		return Arrays.stream(menuItems).mapToDouble(MenuItemEnum::getPrice).sum();
	}
}
