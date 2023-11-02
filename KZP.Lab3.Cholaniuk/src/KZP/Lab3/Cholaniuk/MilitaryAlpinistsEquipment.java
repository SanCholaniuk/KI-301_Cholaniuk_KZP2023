package KZP.Lab3.Cholaniuk;

public class MilitaryAlpinistsEquipment extends Main implements Military {
    private int camoPattern;
    private boolean nightVision;

    public MilitaryAlpinistsEquipment(String itemName, double weight, String description, double price, int camoPattern, boolean nightVision) {
        super(itemName, weight, description, price);
        this.camoPattern = camoPattern;
        this.nightVision = nightVision;
    }

    @Override
    public int getCamoPattern() {
        return camoPattern;
    }

    @Override
    public void setCamoPattern(int camoPattern) {
        this.camoPattern = camoPattern;
    }

    public boolean hasNightVision() {
        return nightVision;
    }

    public void setNightVision(boolean nightVision) {
        this.nightVision = nightVision;
    }

    @Override
    public void specialMilitaryInspect() {

        super.inspect();


        System.out.println("Виконання особливої військової функції з: " + getItemName());

        if (hasNightVision()) {
            System.out.println("Використання нічного бачення для спецоперації...");
        } else {
            System.out.println("Це обладнання не має можливості нічного бачення.");
        }

        if (getDescription().toLowerCase().contains("special")) {
            System.out.println("Використовуючи особливі властивості цього обладнання...");
        } else {
            System.out.println("Це обладнання не має особливої властивості.");
        }
    }
}
