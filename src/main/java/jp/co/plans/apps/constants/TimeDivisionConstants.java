package jp.co.plans.apps.constants;

/**
 * 時間区分enum
 * @author kotarominamiyama
 *
 */
public enum TimeDivisionConstants {

	UKNNOWN("0"), EARLY_MORNING("1"), MORNING("2"), DAYTIME("3"), EVENINNG("4"), NIGNT("5"), MIDNIGHT("6");

	private String division;

	TimeDivisionConstants(String division) {
		this.division = division;
	};

	public String getDivision() {
		return this.division;
	}

}
