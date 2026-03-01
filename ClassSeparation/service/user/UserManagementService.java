/*
ユーザー管理サービス
登録や一覧、退会など、ユーザーデータを管理するサービスクラスとしてまとめました。
メールは迷いましたがユーザーのメールデータなのでこちらに置いています。
*/

public class UserManagementService {
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    // ユーザー登録
    public User register(UserRegistrationForm form) {
        User existing = userMapper.findByEmail(form.getEmail());
        if (existing != null) {
            throw new IllegalArgumentException("既に登録されています");
        }

        User user = new User();
        user.setName(form.getName());
        user.setEmail(form.getEmail());
        user.setPassword(passwordEncoder.encode(form.getPassword()));
        userMapper.insert(user);

        return userMapper.findById(user.getId());
    }

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

    // ユーザー退会
    public void deactivateUser(Long userId) {
        User user = userMapper.findById(userId);
        if (user == null) {
            throw new IllegalArgumentException("存在しません");
        }

        user.setDeleted(true);
        userMapper.update(user);
    }

    // メール存在チェック
    public boolean existsByEmail(String email) {
        return userMapper.findByEmail(email) != null;
    }
}