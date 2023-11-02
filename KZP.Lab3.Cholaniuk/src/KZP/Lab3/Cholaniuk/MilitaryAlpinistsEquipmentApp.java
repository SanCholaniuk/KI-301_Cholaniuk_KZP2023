package KZP.Lab3.Cholaniuk;

public class MilitaryAlpinistsEquipmentApp {

    public static void main(String[] args) {

        MilitaryAlpinistsEquipment gear1 = new MilitaryAlpinistsEquipment("Тактичний ремінь", 1200,
                "Якісна тактична упряж для військових альпіністів", 250, 3, true);
        MilitaryAlpinistsEquipment gear2 = new MilitaryAlpinistsEquipment("Шолом для скелелазіння", 800,
                "Міцний альпіністський шолом з кріпленням нічного бачення", 150, 2, true);
        MilitaryAlpinistsEquipment gear3 = new MilitaryAlpinistsEquipment("Мотузкова драбина", 1500,
                "Спеціальна мотузкова драбина для таємних операцій", 300, 1, false);


        gear1.specialMilitaryInspect();
        gear2.specialMilitaryInspect();
        gear3.specialMilitaryInspect();


        gear1.logItemToFile("military_equipment_log.txt");
        gear2.logItemToFile("military_equipment_log.txt");
        gear3.logItemToFile("military_equipment_log.txt");
    }
}


