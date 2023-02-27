package animals.comparators;

import java.util.Comparator;

import animals.Snake;

public class SnakeComparator implements Comparator<Snake> {

    @Override
    public int compare(Snake o1, Snake o2) {
        if (Integer.compare(o1.getBodyLength(), o2.getBodyLength()) != 0) {
            return Integer.compare(o1.getBodyLength(), o2.getBodyLength());
        } else {
            return Integer.compare(o1.getAge(), o2.getAge());
        }
    }

}