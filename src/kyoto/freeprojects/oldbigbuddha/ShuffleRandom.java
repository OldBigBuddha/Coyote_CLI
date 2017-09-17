package kyoto.freeprojects.oldbigbuddha;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShuffleRandom {


    private List<Integer> randomList = new ArrayList<>();
    private int max, min;
    private int count;

    public ShuffleRandom(int min, int max) {
        this.min    = min;
        this.max    = max;
        this.count  = 0;
        initRandomList();
    }

    public Integer getRandomInt() {
        count++;
        if (count > max) return null;
        return randomList.get(count);
    }

    private void initRandomList() {
        for (int i = min; i < max; i++) {
            randomList.add(i);
        }
        Collections.shuffle(randomList);
    }

}
