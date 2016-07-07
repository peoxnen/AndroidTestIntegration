package iview.wsienski.androidtestintegration.mockito.warriors;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.junit.Assert;

import iview.wsienski.androidtestintegration.warriors.Attack;
import iview.wsienski.androidtestintegration.warriors.Battle;
import iview.wsienski.androidtestintegration.warriors.BattleImpl;
import iview.wsienski.androidtestintegration.warriors.Defence;
import iview.wsienski.androidtestintegration.warriors.Weapon;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;

/**
 * Created by Witold Sienski on 07.07.2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class WarriorTest {

    @Mock
    Attack attack;
    @Mock
    Defence defence;

    Battle battle;

    @Before
    public void setUp(){
        battle = new BattleImpl(attack, defence);
    }

    @Test
    public void testAttack(){
        Weapon weapon = new Weapon();
        Mockito.when(attack.attack(anyString(), anyInt())).thenReturn(weapon);

    }

    @Test
    public void testThrowWeapon(){
        Mockito.doNothing().when(attack).throwWeapon();
    }

    @Test
    public void testThrowWeaponNumber(){
        attack.attack("",2);
        Mockito.verify(attack, Mockito.times(1)).attack(anyString(), anyInt());
    }

    @Test
    public void testArgumentWeapon(){
        ArgumentCaptor<String> argumentCaptor= ArgumentCaptor.forClass(String.class);
        attack.attack("head",3);
        Mockito.verify(attack).attack(argumentCaptor.capture(),anyInt());
        Assert.assertEquals("head", argumentCaptor.getValue());
    }
}
