package org.example;

import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.constraints.IntRange;
import org.junit.jupiter.api.BeforeEach;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CoinChangerPropertiesTest {

    private static final List<Integer> EUROS = List.of(1, 2, 5, 10, 20, 50, 100, 200);

    private CoinChanger coinChanger;

    @BeforeEach
    void setUp() {
        coinChanger = new CoinChanger(EUROS);
    }

    @Property
    void changing_should_conserve_total_amount(@ForAll @IntRange(min = 1, max = 500) int amount) {
        List<Integer> coins = coinChanger.change(amount);

        int totalValue = coins.stream().mapToInt(Integer::intValue).sum();
        assertThat(totalValue).isEqualTo(amount);
    }
}