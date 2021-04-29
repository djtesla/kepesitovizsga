package hu.nive.ujratervezes.kepesitovizsga.army;

public class HeavyCavalry extends MilitaryUnit {

    private int attack;

    public HeavyCavalry() {
        super(150, 20, true);
    }


    @Override
    public int doDamage() {
        attack++;
        if (attack == 1) {
            return 3 * getDamage();
        } else {
            return getDamage();
        }
    }


    @Override
    public void sufferDamage(int damage) {
        setLife(getLife() - damage / 2);

    }

}
