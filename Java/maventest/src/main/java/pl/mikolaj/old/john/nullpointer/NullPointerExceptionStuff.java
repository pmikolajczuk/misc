package pl.mikolaj.old.john.nullpointer;

import pl.mikolaj.old.john.Cat;

import java.util.ArrayList;
import java.util.List;

public class NullPointerExceptionStuff {
    public static void main(String[] args) {

        Cat myCat = null;
        if(myCat != null) {
            myCat.makeNoise();
        }


        List<Cat> cats = new ArrayList<>();
        Cat myOtherCat = new Cat();
        cats.add(myOtherCat);
        myOtherCat.setName("Jerry");

        if("Newman".equals(myOtherCat.getName())) {
            System.out.println("Hello Newman");
        }
        System.out.println(getFirstCatNameLength(cats));
    }
    private static int getFirstCatNameLength(List<Cat> cats) {
        if(cats != null &&
                cats.get(0) != null &&
                cats.get(0).getName() != null) {
            return cats.get(0).getName().length();
        }

        return 0;
    }

    private static List<Cat> getCats() {
        return new ArrayList<>();
    }
}
