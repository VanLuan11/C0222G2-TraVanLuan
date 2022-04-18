package ss12_java_collection_framework.bai_tap.model;

public class Product {
    private String name;
    private Integer id;
    private Integer money;

    public Product(String tenSanPham, String idSanPham, String giaSanPham) {
    }

    public Product(String name, Integer id, Integer money) {
        this.name = name;
        this.id = id;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Product: " +
                "name :" + name +
                " id :" + id +
                " money :" + money;
    }

}
