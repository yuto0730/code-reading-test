/*
 * ユーザー登録処理
 * 新規登録を担当するクラス。
 */
public class UserRegistrationService {
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
}