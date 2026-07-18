package pl.mikolaj.r2025.rentea.optionals;

import java.util.Optional;

class DiscountService {
	public String getDiscountLine(Customer customer) {
		return Optional.of(customer)
				.flatMap(Customer::getMemberCard)
				.flatMap(this::getApplicableDiscountPercentage)
				.map(d -> "Discount: " + d)
				.orElse("");
	}

	private Optional<Integer> getApplicableDiscountPercentage(MemberCard card) {
		if (card.getFidelityPoints() >= 100) {
			return Optional.of(5);
		}
		if (card.getFidelityPoints() >= 50) {
			return Optional.of(3);
		}
		return Optional.empty();
	}

	public static void main(String[] args) {
		DiscountService discountService = new DiscountService();
		System.out.println(discountService.getDiscountLine(new Customer(new MemberCard(60))));
		System.out.println(discountService.getDiscountLine(new Customer(new MemberCard(10))));
		System.out.println(discountService.getDiscountLine(new Customer(null)));

	}
}

class Customer {
    private final MemberCard memberCard;
    public Customer(MemberCard memberCard) {
        this.memberCard = memberCard;
    }

    public Optional<MemberCard> getMemberCard() {
        return Optional.ofNullable(memberCard);
    }
}

class MemberCard {
	private final int fidelityPoints;

	MemberCard(int fidelityPoints) {
		this.fidelityPoints = fidelityPoints;
	}

	public int getFidelityPoints() {
		return fidelityPoints;
	}
}