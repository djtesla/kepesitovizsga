package hu.nive.ujratervezes.kepesitovizsga.army;

public class Archer extends MilitaryUnit {

    public Archer() {
        super(50, 20);
    }


    @Override
    public int doDamage() {
        return getDamage();
    }


    @Override
    public void sufferDamage(int damage) {
        setLife(getLife() - damage);
    }


}
