package by.epam.library.model.entity;

public enum TypePlace {
    HALL("hall"), BOOK_DELIVERY("book delivey"), UNKNOWN("");

    private String value;

    TypePlace(String value) {
        this.value = value;
    }

    public static TypePlace getTypePlace(String value){
        TypePlace[] places = TypePlace.values();
        for (TypePlace place:places) {
            String placeValue = place.value;
            if (value.equals(placeValue)){
                return place;
            }
        }
        return UNKNOWN;
    }
}
