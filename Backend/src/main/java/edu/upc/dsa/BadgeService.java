package edu.upc.dsa;
import edu.upc.dsa.models.Badge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BadgeService {
    private static Map<Integer, List<Badge>> userBadges = new HashMap<>();

    static {
        // Datos iniciales
        List<Badge> badgesForUser1 = new ArrayList<>();
        badgesForUser1.add(new Badge("Java Master", "url_to_java_master_icon"));
        badgesForUser1.add(new Badge("Spring Guru", "url_to_spring_guru_icon"));
        userBadges.put(1, badgesForUser1);

        List<Badge> badgesForUser2 = new ArrayList<>();
        badgesForUser2.add(new Badge("Database Expert", "url_to_db_expert_icon"));
        userBadges.put(2, badgesForUser2);
    }

    public List<Badge> getUserBadges(int userId) {
        return userBadges.getOrDefault(userId, new ArrayList<>());
    }
}
