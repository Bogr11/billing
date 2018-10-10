package tips.entity;

public enum MenuItemEnum {
	COLA(TemperatureEnum.COLD, ItemTypeEnum.DRINK, 0.5),
	COFFEE(TemperatureEnum.HOT, ItemTypeEnum.DRINK, 1),
	CHEESE_SANDWICH(TemperatureEnum.COLD, ItemTypeEnum.FOOD, 2),
	STEAK_SANDWICH(TemperatureEnum.HOT, ItemTypeEnum.FOOD, 4.5);

	private TemperatureEnum temperature;
	private ItemTypeEnum type;
	private double price;

	MenuItemEnum(TemperatureEnum temperature, ItemTypeEnum type, double price) {
		this.temperature = temperature;
		this.type = type;
		this.price = price;
	}

	public TemperatureEnum getTemperature() {
		return temperature;
	}

	public double getPrice() {
		return price;
	}

	public ItemTypeEnum getType() {
		return type;
	}

	public enum TemperatureEnum {
		HOT("Hot"),
		COLD("Cold");

		private String value;

		TemperatureEnum(String value) {
			this.value = value;
		}
	}

	public enum ItemTypeEnum {
		DRINK,
		FOOD
	}
}
