package pl.mikolaj.temp.model;

public class ProductModel implements HasId {
    private Integer id;

    @Override
    public Integer getId() {
        return id;
    }
}
