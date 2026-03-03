/*
 * ユーザー認証サービス
    * ユーザーのログイン認証を担当するクラス。
    * ログインというセキュリティについての処理を担当するため、
    * ユーザー管理関連のクラスから分離させました。
 */

public class UserAuthenticationService {
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    // ログイン認証
    public User authenticate(LoginForm form) {
        User user = userMapper.findByEmail(form.getEmail());
        if (user == null) {
            throw new IllegalArgumentException("認証失敗");
        }

        if (!passwordEncoder.matches(form.getPassword(), user.getPassword())) {
            throw new IllegalArgumentException("認証失敗");
        }

        return user;
    }
}