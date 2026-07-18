package pl.mikolaj.old.rentea.lambdas;

import static pl.mikolaj.old.rentea.lambdas.Movie.Type.*;

class Movie {
    enum Type {
        REGULAR {
            @Override
            public int computePrice(int days) {
                return days + 1;
            }
        }, NEW_RELEASE {
            @Override
            public int computePrice(int days) {
                return days * 2;
            }
        }, CHILDREN {
            @Override
            public int computePrice(int days) {
                return 5;
            }
        };

        abstract public int computePrice(int days);
    }

    private final Type type;

    public Movie(Type type) {
        this.type = type;
    }

    public int computePrice(int days) {
        return type.computePrice(days);
    }
}


public class E_TypeSpecific_Functionality {
    public static void main(String[] args) {
        System.out.println(new Movie(REGULAR).computePrice(2));
        System.out.println(new Movie(NEW_RELEASE).computePrice(2));
        System.out.println(new Movie(CHILDREN).computePrice(2));
    }
}
