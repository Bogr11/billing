package tips;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import tips.entity.MenuItemEnum;
import tips.service.BillService;
import tips.service.ChargeBillService;
import tips.service.StandardBillService;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BillServiceTest {

	private BillService standardBillService = new StandardBillService();
	private BillService chargeBillService = new ChargeBillService();

	private static double MAX_DELTA = 0.00001;

	@Test
	public void standardBillServiceTest() {
		Assert.assertEquals(3.5, standardBillService.countBill(MenuItemEnum.COLA, MenuItemEnum.COFFEE, MenuItemEnum.CHEESE_SANDWICH), 0);
		Assert.assertEquals(3.0, standardBillService.countBill(MenuItemEnum.COFFEE, MenuItemEnum.CHEESE_SANDWICH), 0);
		Assert.assertEquals(1.0, standardBillService.countBill(MenuItemEnum.COFFEE), 0);
		Assert.assertEquals(0.5, standardBillService.countBill(MenuItemEnum.COLA), 0);
		Assert.assertEquals(8.0, standardBillService.countBill(MenuItemEnum.values()), 0);
		Assert.assertTrue(standardBillService.countBill(MenuItemEnum.values()) != standardBillService.countBill(MenuItemEnum.COFFEE));
	}

	@Test
	public void chargeBillServiceOnlyDrinksNoChargeTest() {
		Assert.assertEquals(chargeBillService.countBill(MenuItemEnum.COLA, MenuItemEnum.COFFEE), standardBillService.countBill(MenuItemEnum.COLA, MenuItemEnum.COFFEE), MAX_DELTA);
	}

	@Test
	public void chargeBillServiceSimple10PercentChargeTest() {
		Assert.assertEquals((2 + 0.5) * 1.1, chargeBillService.countBill(MenuItemEnum.COLA, MenuItemEnum.CHEESE_SANDWICH), MAX_DELTA);
	}

	@Test
	public void chargeBillService10PercentChargeWithColdFoodTest() {
		Assert.assertEquals(3.3, chargeBillService.countBill(MenuItemEnum.COFFEE, MenuItemEnum.CHEESE_SANDWICH), MAX_DELTA);
	}

	@Test
	public void chargeBillService10PercentMoreThan20PoundsChargeTest() {
		Assert.assertEquals(((120 * 2) + 1) * 1.1, chargeBillService.countBill(
				MenuItemEnum.CHEESE_SANDWICH, MenuItemEnum.CHEESE_SANDWICH, MenuItemEnum.CHEESE_SANDWICH, MenuItemEnum.CHEESE_SANDWICH,
				MenuItemEnum.CHEESE_SANDWICH, MenuItemEnum.CHEESE_SANDWICH, MenuItemEnum.CHEESE_SANDWICH, MenuItemEnum.CHEESE_SANDWICH,
				MenuItemEnum.CHEESE_SANDWICH, MenuItemEnum.CHEESE_SANDWICH, MenuItemEnum.CHEESE_SANDWICH, MenuItemEnum.CHEESE_SANDWICH,
				MenuItemEnum.CHEESE_SANDWICH, MenuItemEnum.CHEESE_SANDWICH, MenuItemEnum.CHEESE_SANDWICH, MenuItemEnum.CHEESE_SANDWICH,
				MenuItemEnum.CHEESE_SANDWICH, MenuItemEnum.CHEESE_SANDWICH, MenuItemEnum.CHEESE_SANDWICH, MenuItemEnum.CHEESE_SANDWICH,
				MenuItemEnum.CHEESE_SANDWICH, MenuItemEnum.CHEESE_SANDWICH, MenuItemEnum.CHEESE_SANDWICH, MenuItemEnum.CHEESE_SANDWICH,
				MenuItemEnum.CHEESE_SANDWICH, MenuItemEnum.CHEESE_SANDWICH, MenuItemEnum.CHEESE_SANDWICH, MenuItemEnum.CHEESE_SANDWICH,
				MenuItemEnum.CHEESE_SANDWICH, MenuItemEnum.CHEESE_SANDWICH, MenuItemEnum.CHEESE_SANDWICH, MenuItemEnum.CHEESE_SANDWICH,
				MenuItemEnum.CHEESE_SANDWICH, MenuItemEnum.CHEESE_SANDWICH, MenuItemEnum.CHEESE_SANDWICH, MenuItemEnum.CHEESE_SANDWICH,
				MenuItemEnum.CHEESE_SANDWICH, MenuItemEnum.CHEESE_SANDWICH, MenuItemEnum.CHEESE_SANDWICH, MenuItemEnum.CHEESE_SANDWICH,
				MenuItemEnum.CHEESE_SANDWICH, MenuItemEnum.CHEESE_SANDWICH, MenuItemEnum.CHEESE_SANDWICH, MenuItemEnum.CHEESE_SANDWICH,
				MenuItemEnum.CHEESE_SANDWICH, MenuItemEnum.CHEESE_SANDWICH, MenuItemEnum.CHEESE_SANDWICH, MenuItemEnum.CHEESE_SANDWICH,
				MenuItemEnum.CHEESE_SANDWICH, MenuItemEnum.CHEESE_SANDWICH, MenuItemEnum.CHEESE_SANDWICH, MenuItemEnum.CHEESE_SANDWICH,
				MenuItemEnum.CHEESE_SANDWICH, MenuItemEnum.CHEESE_SANDWICH, MenuItemEnum.CHEESE_SANDWICH, MenuItemEnum.CHEESE_SANDWICH,
				MenuItemEnum.CHEESE_SANDWICH, MenuItemEnum.CHEESE_SANDWICH, MenuItemEnum.CHEESE_SANDWICH, MenuItemEnum.CHEESE_SANDWICH,
				MenuItemEnum.CHEESE_SANDWICH, MenuItemEnum.CHEESE_SANDWICH, MenuItemEnum.CHEESE_SANDWICH, MenuItemEnum.CHEESE_SANDWICH,
				MenuItemEnum.CHEESE_SANDWICH, MenuItemEnum.CHEESE_SANDWICH, MenuItemEnum.CHEESE_SANDWICH, MenuItemEnum.CHEESE_SANDWICH,
				MenuItemEnum.CHEESE_SANDWICH, MenuItemEnum.CHEESE_SANDWICH, MenuItemEnum.CHEESE_SANDWICH, MenuItemEnum.CHEESE_SANDWICH,
				MenuItemEnum.CHEESE_SANDWICH, MenuItemEnum.CHEESE_SANDWICH, MenuItemEnum.CHEESE_SANDWICH, MenuItemEnum.CHEESE_SANDWICH,
				MenuItemEnum.CHEESE_SANDWICH, MenuItemEnum.CHEESE_SANDWICH, MenuItemEnum.CHEESE_SANDWICH, MenuItemEnum.CHEESE_SANDWICH,
				MenuItemEnum.CHEESE_SANDWICH, MenuItemEnum.CHEESE_SANDWICH, MenuItemEnum.CHEESE_SANDWICH, MenuItemEnum.CHEESE_SANDWICH,
				MenuItemEnum.CHEESE_SANDWICH, MenuItemEnum.CHEESE_SANDWICH, MenuItemEnum.CHEESE_SANDWICH, MenuItemEnum.CHEESE_SANDWICH,
				MenuItemEnum.CHEESE_SANDWICH, MenuItemEnum.CHEESE_SANDWICH, MenuItemEnum.CHEESE_SANDWICH, MenuItemEnum.CHEESE_SANDWICH,
				MenuItemEnum.CHEESE_SANDWICH, MenuItemEnum.CHEESE_SANDWICH, MenuItemEnum.CHEESE_SANDWICH, MenuItemEnum.CHEESE_SANDWICH,
				MenuItemEnum.CHEESE_SANDWICH, MenuItemEnum.CHEESE_SANDWICH, MenuItemEnum.CHEESE_SANDWICH, MenuItemEnum.CHEESE_SANDWICH,
				MenuItemEnum.CHEESE_SANDWICH, MenuItemEnum.CHEESE_SANDWICH, MenuItemEnum.CHEESE_SANDWICH, MenuItemEnum.CHEESE_SANDWICH,
				MenuItemEnum.CHEESE_SANDWICH, MenuItemEnum.CHEESE_SANDWICH, MenuItemEnum.CHEESE_SANDWICH, MenuItemEnum.CHEESE_SANDWICH,
				MenuItemEnum.CHEESE_SANDWICH, MenuItemEnum.CHEESE_SANDWICH, MenuItemEnum.CHEESE_SANDWICH, MenuItemEnum.CHEESE_SANDWICH,
				MenuItemEnum.CHEESE_SANDWICH, MenuItemEnum.CHEESE_SANDWICH, MenuItemEnum.CHEESE_SANDWICH, MenuItemEnum.CHEESE_SANDWICH,
				MenuItemEnum.CHEESE_SANDWICH, MenuItemEnum.CHEESE_SANDWICH, MenuItemEnum.CHEESE_SANDWICH, MenuItemEnum.CHEESE_SANDWICH,
				MenuItemEnum.COFFEE), MAX_DELTA);
	}

	@Test
	public void chargeBillServiceSimple20PercentChargeTest() {
		Assert.assertEquals(6.6, chargeBillService.countBill(MenuItemEnum.COFFEE, MenuItemEnum.STEAK_SANDWICH), MAX_DELTA);
	}

	@Test
	public void chargeBillService20PercentLessThan20PoundsChargeTest() {
		Assert.assertEquals(((20 * 4.5) + 1) * 1.2, chargeBillService.countBill(MenuItemEnum.COFFEE,
				MenuItemEnum.STEAK_SANDWICH, MenuItemEnum.STEAK_SANDWICH, MenuItemEnum.STEAK_SANDWICH, MenuItemEnum.STEAK_SANDWICH,
				MenuItemEnum.STEAK_SANDWICH, MenuItemEnum.STEAK_SANDWICH, MenuItemEnum.STEAK_SANDWICH, MenuItemEnum.STEAK_SANDWICH,
				MenuItemEnum.STEAK_SANDWICH, MenuItemEnum.STEAK_SANDWICH, MenuItemEnum.STEAK_SANDWICH, MenuItemEnum.STEAK_SANDWICH,
				MenuItemEnum.STEAK_SANDWICH, MenuItemEnum.STEAK_SANDWICH, MenuItemEnum.STEAK_SANDWICH, MenuItemEnum.STEAK_SANDWICH,
				MenuItemEnum.STEAK_SANDWICH, MenuItemEnum.STEAK_SANDWICH, MenuItemEnum.STEAK_SANDWICH, MenuItemEnum.STEAK_SANDWICH),
				MAX_DELTA);
	}

	@Test
	public void chargeBillService20PercentMoreThan20PoundsChargeTest() {
		Assert.assertEquals((40 * 4.5) + 1 + 20, chargeBillService.countBill(
				MenuItemEnum.STEAK_SANDWICH, MenuItemEnum.STEAK_SANDWICH, MenuItemEnum.STEAK_SANDWICH, MenuItemEnum.STEAK_SANDWICH,
				MenuItemEnum.STEAK_SANDWICH, MenuItemEnum.STEAK_SANDWICH, MenuItemEnum.STEAK_SANDWICH, MenuItemEnum.STEAK_SANDWICH,
				MenuItemEnum.STEAK_SANDWICH, MenuItemEnum.STEAK_SANDWICH, MenuItemEnum.STEAK_SANDWICH, MenuItemEnum.STEAK_SANDWICH,
				MenuItemEnum.STEAK_SANDWICH, MenuItemEnum.STEAK_SANDWICH, MenuItemEnum.STEAK_SANDWICH, MenuItemEnum.STEAK_SANDWICH,
				MenuItemEnum.STEAK_SANDWICH, MenuItemEnum.STEAK_SANDWICH, MenuItemEnum.STEAK_SANDWICH, MenuItemEnum.STEAK_SANDWICH,
				MenuItemEnum.STEAK_SANDWICH, MenuItemEnum.STEAK_SANDWICH, MenuItemEnum.STEAK_SANDWICH, MenuItemEnum.STEAK_SANDWICH,
				MenuItemEnum.STEAK_SANDWICH, MenuItemEnum.STEAK_SANDWICH, MenuItemEnum.STEAK_SANDWICH, MenuItemEnum.STEAK_SANDWICH,
				MenuItemEnum.STEAK_SANDWICH, MenuItemEnum.STEAK_SANDWICH, MenuItemEnum.STEAK_SANDWICH, MenuItemEnum.STEAK_SANDWICH,
				MenuItemEnum.STEAK_SANDWICH, MenuItemEnum.STEAK_SANDWICH, MenuItemEnum.STEAK_SANDWICH, MenuItemEnum.STEAK_SANDWICH,
				MenuItemEnum.STEAK_SANDWICH, MenuItemEnum.STEAK_SANDWICH, MenuItemEnum.STEAK_SANDWICH, MenuItemEnum.STEAK_SANDWICH,
				MenuItemEnum.COFFEE), MAX_DELTA);
	}
}