import java.util.*;

public class MobilePhoneSet {

    private Myset phoneSet;

    public MobilePhoneSet() {
        phoneSet = new Myset();
    }

    // GETTING A MOBILE PHONE (FOR CHANGING ITS SETTINGS...)
    public MobilePhone getMobilePhone(int number) {
        try {
            return (MobilePhone)phoneSet.getItem(new MobilePhone(number));
        }
        catch(IllegalArgumentException e) {
            throw new IllegalArgumentException("No mobile phone with identifier " + number + " found in the network");
        }
    }

    public boolean containsMobile(int number) {
        return phoneSet.IsMember(new MobilePhone(number));
    }

    // ADDING A MOBILE PHONE
    public void addMobile(MobilePhone m) {
        phoneSet.Insert(m);
    }

    public void addMobile(int number) {
        phoneSet.Insert(new MobilePhone(number));
    }

    public void removeMobile(MobilePhone m) {
        try {
            phoneSet.Delete(m);
        }
        catch(IllegalArgumentException e) {
            throw new IllegalArgumentException("No mobile phone with identifier " + m.number() + " found in the network");
        }
    }

    //DELETING A MOBILE PHONE
    public void removeMobile(int number) {
        try {
            phoneSet.Delete(new MobilePhone(number));
        }
        catch(IllegalArgumentException e) {
            throw new IllegalArgumentException("No mobile phone with identifier " + number + " found in the network");
        }
    }

    public Myset getSet() {
        return phoneSet;
    }

    // UNION OF mOBILEpHONEsETS
    public void uniteMobileSet(MobilePhoneSet... phoneSets) {
        for(MobilePhoneSet m: phoneSets)
            phoneSet.unite(phoneSet, m.getSet());
    }

    // PRINTING OF CONTAINED MOBILES WITH VARIOUS CONSTRAINTS
    public void printPhonesWithStatus() {
        Iterator it = phoneSet.getSetList().iterator();
        while(it.hasNext()) {
            MobilePhone m = (MobilePhone)it.next();
            System.out.printf("Mobile Phone %s is Switched %s\n", m.toString(), (m.status())?("On"):("Off"));
        }
    }

    public String printOnPhones() {
        String fi = "";
        Iterator it = phoneSet.getSetList().iterator();
        while(it.hasNext()) {
            MobilePhone m = (MobilePhone)it.next();
            if(m.status()) {
                fi=m.toString()+", "+fi;
            }
        }
        if(fi.length() == 0)
            return "";
        return fi.substring(0, fi.length()-2);
    }

    // EMPTYING THE SET
    public void clearSet() {
        phoneSet.clearSet();
    }
}
