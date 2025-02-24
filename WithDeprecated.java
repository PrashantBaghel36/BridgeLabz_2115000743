class LegacyAPI {
    @Deprecated
    void oldFeature() {
        System.out.println("This is the old feature.");
    }

    void newFeature() {
        System.out.println("This is the new feature.");
    }
}

public class WithDeprecated {
    public static void main(String[] args) {
        LegacyAPI api = new LegacyAPI();
        api.oldFeature();
        api.newFeature();
    }
}