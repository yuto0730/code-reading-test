// 問1.以下の不適切なメソッド名を修正してください。
public class AssignmentTask {

  /*
   * パターン1
   * 挨拶を表示する。メゾッド名は動詞を始めにつけるのがよい。
   */
  public void printHelloUser(User user) {
    System.out.println("Hello, " + user.getName());
  }

  /*
   * パターン2
   * 長かったので端的に。メゾッドは動詞から始める。
   */
  public void greetUser(User user) {
    System.out.println("Hello, " + user.getName());
  }

  /*
   * パターン3
   * 「ユーザーの名前を表示する」とわかりやすく。動詞から始める。
   */
  public void printUserName(User user) {
    System.out.println(user.getName());
  }

  /*
   * パターン4
   * ユーザーの名前を取得する。ゲッターなのでgetは前置きすべき。
   */
  public String getUserName(User user) {
    return user.getName();
  }

  /*
   * パターン5:
   * アンダーバーを削除してキャメルケースに変更。
   */
  public void printUserInfo(User user) {
    System.out.println(user.getName());
  }

  /*
   * パターン6
   * newだけでは何を作成するのかわからないため、
   * また、newだけでは予約語なので使用不可のため、createNewUserに変更。
   */
  public User createNewUser(String name) {
    return new User(name);
  }

  /*
   * パターン7
   * booleanを返すメゾットはisなどを頭につけるのがよい。isActiveUserに変更。
   */
  public boolean isActiveUser(User user) {
    return user.isActive();
  }

}