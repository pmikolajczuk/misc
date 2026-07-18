package pl.mikolaj.r2025.rentea.enums;

import org.mockito.Mockito;

import java.util.function.BiFunction;

class Movie {
	enum Type {
		REGULAR(PriceService::computeRegularPrice),
		NEW_RELEASE(PriceService::computeNewReleasePrice),
		CHILDREN(PriceService::computeChildrenPrice);

		public final BiFunction<PriceService, Integer, Integer> priceAlgo;

		Type(BiFunction<PriceService, Integer, Integer> compute) {
			this.priceAlgo = compute;
		}
	}
}

interface NewReleasePriceRepo {
	double getFactor();
}

class PriceService {
	private final NewReleasePriceRepo repo;

	public PriceService(NewReleasePriceRepo repo) {
		this.repo = repo;
	}

	int computeNewReleasePrice(int days) {
		return (int) (days * repo.getFactor());
	}

	int computeRegularPrice(int days) {
		return days + 1;
	}

	int computeChildrenPrice(int days) {
		return 5;
	}

	int computePrice(Movie.Type type, int days) {
		return type.priceAlgo.apply(this, days);
	}
}

public class E__TypeSpecific_Functionality {
	public static void main(String[] args) {
		NewReleasePriceRepo repo = Mockito.mock(NewReleasePriceRepo.class);
		Mockito.when(repo.getFactor()).thenReturn(2d);

		PriceService priceService = new PriceService(repo);
		System.out.println(priceService.computePrice(Movie.Type.REGULAR, 2));
		System.out.println(priceService.computePrice(Movie.Type.NEW_RELEASE, 2));
		System.out.println(priceService.computePrice(Movie.Type.CHILDREN, 2));
	}
}
