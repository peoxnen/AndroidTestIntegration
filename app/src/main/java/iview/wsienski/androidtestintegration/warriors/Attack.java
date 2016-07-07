package iview.wsienski.androidtestintegration.warriors;

/**
 * Created by Witold Sienski on 07.07.2016.
 */
public interface Attack {
    Weapon attack(String bodyPart, int damage);
    void throwWeapon();
}
