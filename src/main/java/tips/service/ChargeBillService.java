package tips.service;

import tips.entity.MenuItemEnum;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

public class ChargeBillService implements BillService {

	@Override
	public double countBill(MenuItemEnum... menuItems) {
		double totalBill = Arrays.stream(menuItems).mapToDouble(MenuItemEnum::getPrice).sum();

		if (Arrays.stream(menuItems)
				.allMatch(it -> it.getType().equals(MenuItemEnum.ItemTypeEnum.DRINK)))
			return totalBill;

		double chargedBill = totalBill;

		if (Arrays.stream(menuItems)
				.anyMatch(it -> it.getType().equals(MenuItemEnum.ItemTypeEnum.FOOD)))
			chargedBill = totalBill * 1.1;

		if (Arrays.stream(menuItems)
				.filter(it -> it.getType().equals(MenuItemEnum.ItemTypeEnum.FOOD))
				.anyMatch(it -> it.getTemperature().equals(MenuItemEnum.TemperatureEnum.HOT))) {

			double charge = totalBill * 0.2;
			chargedBill = totalBill + (charge > 20 ? 20 : charge);
		}

		return scale(chargedBill);
	}

	double scale(double value) {
		return BigDecimal.valueOf(value).setScale(2, RoundingMode.HALF_UP).doubleValue();
	}
}
