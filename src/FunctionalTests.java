public class FunctionalTests  {
    public static void main(String[] args)
    {
        final int testSize = 2;

        MyHashMap customMap = new MyHashMap(testSize);

        System.out.println(customMap.load() == 0);
        System.out.println(customMap.set("Smith", "Jerry") == true);
        System.out.println(customMap.get("Smith") == "Jerry");
        System.out.println(customMap.set("Smith", "John") == true);
        System.out.println(customMap.set("Smith", "Jack") == true);
        System.out.println(customMap.set("Lee", "Bob") == true);
        System.out.println(customMap.set("Zombie", "Rob") == false);
        System.out.println(customMap.load() == 1);
        System.out.println(customMap.delete("Smith") == "Jack");
        System.out.println(customMap.get("Smith") == null);
        System.out.println(customMap.delete("Lee") == "Bob");
        System.out.println(customMap.delete("Zombie") == null);
        System.out.println(customMap.load() == 0);
    }
}