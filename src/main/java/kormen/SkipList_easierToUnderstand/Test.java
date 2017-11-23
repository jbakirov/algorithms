package kormen.SkipList_easierToUnderstand;

import java.util.Iterator;

/**
 * Created by Baka on 22.12.2016.
 */
public class Test {

    public static void main(String[] args) {
        SkipList<Integer> skipList = new SkipList<>();
        skipList.add(4);
        skipList.add(6);
        skipList.add(3);
        skipList.add(8);
        skipList.add(7);
        skipList.add(1);
        skipList.add(43);
        skipList.add(33);

        skipList.contains(33);

        Iterator iterator = skipList.iterator();

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

}
