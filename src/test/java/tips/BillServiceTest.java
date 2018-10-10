package tips;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import tips.entity.MenuItemEnum;
import tips.service.BillService;
import tips.service.StandardBillService;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BillServiceTest {

	private BillService billService = new StandardBillService();

	@Test
	public void standardBillServiceTest() {
		Assert.assertEquals(3.5, billService.countBill(MenuItemEnum.COLA, MenuItemEnum.COFFEE, MenuItemEnum.CHEESE_SANDWICH), 0);
		Assert.assertEquals(3.0, billService.countBill(MenuItemEnum.COFFEE, MenuItemEnum.CHEESE_SANDWICH), 0);
		Assert.assertEquals(1.0, billService.countBill(MenuItemEnum.COFFEE), 0);
		Assert.assertEquals(0.5, billService.countBill(MenuItemEnum.COLA), 0);
		Assert.assertEquals(8.0, billService.countBill(MenuItemEnum.values()), 0);
	}

}