package org.example.creational.singleton;

public class Configuration {

    //  Singleton- zapobiega stworzeniu dwóch obiektów
    //  Wykonanie:
    //  1. Musi być prywatny konstruktor.
    //  2. Statycza metoda wywoływania obiektu z instancji,
    //     (statyczna, żeby wywołać obiekt bez tworzenia
    //     nowego obiektu)
    //  3. Pole z instancją klasy również musi być staic,
    //     ponieważ pole statyczne nie może odnościć się
    //     do niestatycznych pól.
    //  Pierwsze wywołanie getInstance tworzy obiekt
    //  Każde następne wywołanie zwraca referencje, a
    //  nie nowy obiekt. Polega to na zmianie działnia
    //  kontrutora. Kontruktor za każdym razem nie rezewuje
    //  nowego obszaru w pamięci tylko zwraca referencje do
    //  utworzonego obiektu.

    private static Configuration INSTANCE;

    private Configuration() {
    }

    public static Configuration getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Configuration();
        }
        return INSTANCE;
    }
    
    public static void main(String[] args) {

        Configuration configuration1 = Configuration.getInstance();
        Configuration configuration2 = Configuration.getInstance();

        System.out.println(configuration1 == configuration2);
        //zwraca true jako, że obiekty są sobie równe

        ConfigurationByEnum configurationByEnum1 = ConfigurationByEnum.CONFIGURATION_BY_ENUM;
        ConfigurationByEnum configurationByEnum2 = ConfigurationByEnum.CONFIGURATION_BY_ENUM;

        System.out.println(configurationByEnum1 == configurationByEnum2);
    }
}
