/*
 * 状態変更処理
 * 退会処理など状態の変更を担当するクラス。
 */
public class UserStatusService {
    private final UserMapper userMapper;

    // ユーザー退会
    public void deactivateUser(Long userId) {
        User user = userMapper.findById(userId);
        if (user == null) {
            throw new IllegalArgumentException("存在しません");
        }

        user.setDeleted(true);
        userMapper.update(user);
    }
}