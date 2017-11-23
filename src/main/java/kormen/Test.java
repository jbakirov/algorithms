package kormen;

/**
 * Created by Baka on 22.12.2016.
 */
public class Test {

    public static void main(String[] args) {
        SkipList<Integer> skipList = new SkipList<>();

        skipList.insert(4);
        skipList.insert(6);
        skipList.insert(3);
        skipList.insert(8);
        skipList.insert(7);
        skipList.insert(1);
        skipList.insert(43);
        skipList.insert(33);

    }
}
