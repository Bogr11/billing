package tips.entity;

public enum MenuItemEnum {
	COLA(ItemType.COLD, 0.5),
	COFFEE(ItemType.HOT, 1),
	CHEESE_SANDWICH(ItemType.COLD, 2),
	STEAK_SANDWICH(ItemType.HOT, 4.5);

	private ItemType type;
	private double price;

	MenuItemEnum(ItemType type, double price) {
		this.type = type;
		this.price = price;
	}

	public ItemType getType() {
		return type;
	}

	public double getPrice() {
		return price;
	}

	enum ItemType {
		HOT("Hot"),
		COLD("Cold");

		private String value;

		ItemType(String value) {
			this.value = value;
		}
	}
}
