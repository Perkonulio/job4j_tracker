package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int result = -1;
        for (int i = 0; i < value.length; i++) {
            if(value[i].equals(key)) {
                result = i;
                break;
            }
        }
        if(result == -1) {
            throw new ElementNotFoundException();
        }
        return result;
    }

    public static void main(String[] args) {
        FindEl findEl = new FindEl();
        String[] array = {"Clone1" , "Clone2", "Clone3"};
        try {
            findEl.indexOf(array, "Clone4");
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}
