
public class Player_B0444238 extends Player{
	public Player_B0444238(int chips) {
		super("zi-ting Zhan(B0444238)", chips); //Please modify Example to Your Name (Your ID), for example: "Yi-Ju Tseng (B0000000)"
	}

	@Override
	public int make_bet() {
		setBet(500);
		if (get_current_chips() > getBet()) {
			setBet(get_current_chips()*10/100);
			return getBet();
			} else {
			setBet(get_current_chips()*5/100);
			return getBet();
		}
	}

	@Override
	public boolean hit_me(Table tbl) {
		int total_value = getTotalValue();

		if (total_value >= 17) {
			return false;
		} 
		else {
			return true;
		}

	}
}
