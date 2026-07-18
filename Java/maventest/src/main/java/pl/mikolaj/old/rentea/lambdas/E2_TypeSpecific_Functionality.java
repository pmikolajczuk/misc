package pl.mikolaj.old.rentea.lambdas;

import java.util.function.BiFunction;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static pl.mikolaj.old.rentea.lambdas.Movie2.Type.*;

class Movie2 {
    enum Type {
        REGULAR(PriceService::computeRegularPrice),
        NEW_RELEASE(PriceService::computeNewReleasePrice),
        CHILDREN(PriceService::computeChildrenPrice);

        BiFunction<PriceService, Integer, Integer> computePrice;

        Type(BiFunction<PriceService, Integer, Integer> computePrice) {
            this.computePrice = computePrice;
        }
    }
}

interface NewReleasePriceRepo {
    double getFactor();
}

class PriceService {
    private final NewReleasePriceRepo repo;

    PriceService(NewReleasePriceRepo repo) {
        this.repo = repo;
    }

    int computeRegularPrice(int days) {
        return days + 1;
    }

    int computeNewReleasePrice(int days) {
        return (int) (days * repo.getFactor());
    }

    int computeChildrenPrice(int days) {
        return 5;
    }

    int computePrice(Movie2.Type type, int days) {
        return type.computePrice.apply(this, days);
    }
}

public class E2_TypeSpecific_Functionality {
    public static void main(String[] args) {
        NewReleasePriceRepo repo = mock(NewReleasePriceRepo.class);
        when(repo.getFactor()).then(p -> 2d);

        PriceService priceService = new PriceService(repo);
        System.out.println(priceService.computePrice(REGULAR, 2));
        System.out.println(priceService.computePrice(NEW_RELEASE, 2));
        System.out.println(priceService.computePrice(CHILDREN, 2));

        System.out.println(REGULAR.computePrice.apply(priceService, 5));
    }
}
