// 問2.以下の不適切な変数名を修正してください。
public class VariableNaming {

  public void calculateNumbers() {
    /*
     * パターン1
     * アンダーバーを削除して、キャメルケースに変更。
     */
    int firstNumber = 10;
    int secondNumber = 20;

    /*
     * パターン2
     * 一文字だと何を表しているのかわからない、検索も困難。
     * 「１つ目の数字」「２つ目の数字」とわかりやすく変更。
     */
    int number1 = 5;
    int number2 = 3;
    /*
     * パターン3
     * returnはエラーになるので、resultValueに変更。
     * 変数名を変えたので計算式も該当の変数名に変更。
     */
    int resultValue = 100;

    int totalResult = firstNumber + secondNumber;
    int sum = number1 + number2 + resultValue;

    System.out.println(totalResult);
    System.out.println(sum);
  }
}
