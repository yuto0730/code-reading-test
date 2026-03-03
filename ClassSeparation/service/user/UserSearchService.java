/*
 * 検索・取得処理
 * ユーザー情報の取得や存在チェックを担当するクラス。
 */

import java.util.ArrayList;
import java.util.List;

public class UserSearchService {
    private final UserMapper userMapper;

    // ユーザー一覧取得
    public List<User> getActiveUsers() {
        List<User> users = userMapper.findAll();
        List<User> result = new ArrayList<>();

        for (User user : users) {
            if (!user.isDeleted()) {
                result.add(user);
            }
        }
        return result;
    }

    // メール存在チェック
    public boolean existsByEmail(String email) {
        return userMapper.findByEmail(email) != null;
    }
}