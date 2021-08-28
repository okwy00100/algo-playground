package com.okwy.algoplayground.Arrays;

import java.util.Arrays;
import java.util.List;

public class JumpingOnTheClouds {

    /**
     * Description of the problem
     * --------------------------
     * There is a new mobile game that starts with consecutively numbered clouds. Some of the clouds are thunderheads
     * and others are cumulus. The player can jump on any cumulus cloud having a number that is equal to the number of
     * the current cloud plus 1 or 2. The player must avoid the thunderheads. Determine the minimum number of jumps it will
     * take to jump from the starting postion to the last cloud. It is always possible to win the game.
     * <p>
     * For each game, you will get an array of clouds numbered 0 if they are safe or 1 if they must be avoided.
     * <p>
     * c = [0,1,0,0,0,1,0]
     * <p>
     * Index the array from 0...6. The number on each cloud is its index in the list so the player must avoid the clouds at
     * indices  and . They could follow these two paths: 0->2->4->6  or 0->2->3->4->6. The first path takes 3 jumps while the second takes 4.
     * Return 3.
     */


    public static int jumpingOnClouds(List<Integer> cloud) {

        int minJumps = 0;
        int tracker = 0;
        while (tracker < cloud.size() - 1) {
            if (tracker + 2 < cloud.size() && cloud.get(tracker + 2) != 1) {
                tracker += 2;
            } else {
                tracker++;
            }
            minJumps++;
        }

        return minJumps;
    }

    public static void main(String[] args) {

        Integer[] cloudPath = {0, 1, 0, 0, 0, 1, 0};

        System.out.println(">>>>>>>>>Minimum jumps");
        System.out.println(jumpingOnClouds(Arrays.asList(cloudPath)));
    }
}
