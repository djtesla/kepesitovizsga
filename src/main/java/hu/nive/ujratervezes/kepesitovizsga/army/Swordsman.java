package hu.nive.ujratervezes.kepesitovizsga.army;

public class Swordsman extends MilitaryUnit {

    private boolean isActiveShield = true;

    public Swordsman(boolean isArmour) {
        super(100, 10, isArmour);
    }


    @Override
    public int doDamage() {
        return getDamage();
    }


    @Override
    public void sufferDamage(int damage) {
        if (isActiveShield) {
            isActiveShield = false;
            return;
        } else {
            sufferDamageWithoutShield(damage);
        }
    }

    private void sufferDamageWithoutShield(int damage) {
        if (isArmour()) {
            setLife(getLife() - damage / 2);
        } else {
            setLife(getLife() - damage);
        }
    }


}