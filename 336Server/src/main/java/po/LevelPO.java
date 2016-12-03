package po;

public class LevelPO {

	private int creditDistance;
	private int maxLevel;
	private double discountDistance;

	public LevelPO(int creditDistance, int maxLevel, double discountDistance) {
		this.creditDistance = creditDistance;
		this.maxLevel = maxLevel;
		this.discountDistance = discountDistance;
	}

	public void setCreditDistance(int creditDistance) {
		this.creditDistance = creditDistance;
	}

	public int getCreditDistance() {
		return this.creditDistance;
	}

	public void setMaxLevel(int maxLevel) {
		this.maxLevel = maxLevel;
	}

	public int getMaxLevel() {
		return this.maxLevel;
	}

	public void setDiscountDistance(double discountDistance) {
		this.discountDistance = discountDistance;
	}

	public double getDiscountDistance(){
		return this.discountDistance;
	}
}
