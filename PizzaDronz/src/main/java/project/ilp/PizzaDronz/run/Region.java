package project.ilp.PizzaDronz.run;

import java.util.List;

public record Region(
        String name,
        List<Position> vertices
) {
}
