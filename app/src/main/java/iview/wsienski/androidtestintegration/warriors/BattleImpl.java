package iview.wsienski.androidtestintegration.warriors;

/**
 * Created by Witold Sienski on 07.07.2016.
 */
public class BattleImpl implements Battle{
    private Attack attack;
    private Defence defence;
    public BattleImpl(Attack attack, Defence defence) {
        this.attack=attack;
        this.defence=defence;
    }

    @Override
    public void fight(Weapon weapon, Armor armor) {
        if(weapon!=null){
            attack.attack("head", 1);
        }
        if(armor!=null){
            defence.block("arm", 2);
        }
    }
}
