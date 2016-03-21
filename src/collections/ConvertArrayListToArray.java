package collections;

import java.util.ArrayList;

/**
 * toArray():
 * 1. No argument => returns Object[]
 * 2. Empty array argument => returns same type of array
 * 3. Less sized array argument, argument array will be overwritten and returns new array from the arrayList
 * 4. Greater sized array argument, arrayList will overwrite from beginning of the array
 * and add null after that. Argument array and resulting array will refer to same.
 */
public class ConvertArrayListToArray {
    public static void main(String[] args) {
        ArrayList<Character> originalArrayList = new ArrayList<>();
        for (char c = 'a'; c < 'd'; c++)
            originalArrayList.add(c);   // [a, b, c]

        // 1. No argument => returns Object[]
        Object[] newArrayObject = originalArrayList.toArray(); // [a, b, c]

        // 2. Empty array argument => returns same type of array
        Character[] newArrayCharacter = originalArrayList.toArray(new Character[0]); // [a, b, c]

        // 3. Less sized array argument, argument array will be overwritten and returns new array from the arrayList
        Character[] argArrayShort = { '?', '?' };
        Character[] newArrayShort = originalArrayList.toArray(argArrayShort); // [a, b, c]
        for (Object c : newArrayShort)
            System.out.print(c + " ");
        System.out.println(argArrayShort == newArrayShort);     // false

        // 4. Greater sized array argument, arrayList will overwrite from beginning of the array
        // and add null after that. Argument array and resulting array will refer to same.
        // It does: System.arraycopy(this.elementData, 0, arg, 0, this.size);
        Character[] argArrayLong = { '?', '?', '?', '?', '?', '?', '?' };
        Character[] newArrayLong = originalArrayList.toArray(argArrayLong);  // [a b c null ? ? ?]
        for (Object c : newArrayLong)
            System.out.print(c + " ");
        System.out.println(argArrayLong == newArrayLong);       // true

    }
}
