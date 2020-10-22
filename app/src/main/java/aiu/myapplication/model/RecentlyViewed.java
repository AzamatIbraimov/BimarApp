package aiu.myapplication.model;

public class RecentlyViewed {

    private String name;
    private String description;
    private String price;
    private String quantity;
    private String unit;
    private int imageUrl;
    private int bigimageUrl;

    public RecentlyViewed(String name, String description, String price, String quantity, String unit, int
            imageUrl, int bigimageUrl) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.unit = unit;
        this.imageUrl = imageUrl;
        this.bigimageUrl = bigimageUrl;
    }

    public int getBigimageUrl() {
        return bigimageUrl;
    }

    public void setBigimageUrl(int bigimageUrl) {
        this.bigimageUrl = bigimageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(int imageUrl) {
        this.imageUrl = imageUrl;
    }
}
