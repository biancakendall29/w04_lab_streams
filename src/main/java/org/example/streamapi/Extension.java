package org.example.streamapi;

import org.example.streamapi.model.Bodybuilder;
import org.example.streamapi.model.Friend;
import org.example.streamapi.model.User;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class Extension {
    /*
        Given two int numbers a and b, return int [] with values that are in the range between smaller and bigger arg:
        - use IntStream.range
        - swap the argument's values without introducing a new, local variable.
    */
    public int [] streamNumbers(int a, int b) {
        // Implement me :)
        int[] sorted = Arrays.stream(new int[] {a, b}).sorted().toArray();
        int[] range =
                IntStream
                .range(sorted[0], sorted[1])
                .toArray();
        return range;
    }

    /*
        Given a list of users, return a User with the given user id. If there is no user with this id,
        return new user with the name "New user", given id, gender "unknown".

        (use Optional API)
    */
    public User getUserByIdOrCreateNew(List<User> users, long userId) {
        // Implement me :)
        User gottenID = users
                .stream()
                .filter(el -> el.getId() == userId)
                .findAny()
                .orElse(new User(userId, "New user", User.GENDER.UNKNOWN));
        return gottenID;
    }

    /*
        Given List<Friend>, filter the ones who are available on Saturday and want to party:
        - getAvailableDay returns "Saturday" and
        - getActivity returns "Party"
        - define predicates and use '.and' method.
    */

    public List<String> partyWithFriends(List<Friend> friends) {
        // Implement me :)
        Predicate<Friend> availDay = friend -> friend.getAvailableDay() == "Saturday";
        Predicate<Friend> partier = friend -> friend.getActivity() == "Party";

        List<String> partiesOnSaturday = friends
                .stream()
                .filter(availDay.and(partier))
                .map(Friend::getName)
                .toList();
        return partiesOnSaturday;
    }

    /*
        Return names of sorted bodybuilders.

        Sort List<Bodybuilder> using your custom comparator.

        Write a comparator for type BodyBuilder that will sort bodybuilders by:
        - who can lift more,
        - then who is younger,
        - then name alphabetically.
     */
    public List<String> sortBodybuilders(List<Bodybuilder> bodybuilders) {
        // Implement me :)
        return null;
    }

}
